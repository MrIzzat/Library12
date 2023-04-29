package com.mrizzat.library12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.mrizzat.library12.model.Book;
import com.mrizzat.library12.model.BookDa;

import java.io.IOException;
import java.util.ArrayList;

public class searchBookbyType extends AppCompatActivity {

    private Button btnShow;
    private android.widget.Spinner Spinner;
    private TextView txtResults;
    private BookDa Controller;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Library App System");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bookby_type);

        {
            try {
                Controller = new BookDa();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Controller.loadBooks(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnShow = findViewById(R.id.btnSubmit);
        txtResults = findViewById(R.id.txtResults);
        Spinner = findViewById(R.id.spnTypes);
        String[] text = Controller.getBookTypes();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,text);
        Spinner.setAdapter(adapter);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = Spinner.getSelectedItem().toString();
                ArrayList<Book> temp=Controller.getBooksByType(type);
                String names="";
                for(Book b:temp){
                    names+=b.getTitle()+"\n";
                }
                txtResults.setText(names);
                //               txtResults.setText(Spinner.getSelectedItem().toString());
            }
        });

    }

    public void backtoMain(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}