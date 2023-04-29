package com.mrizzat.library12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.mrizzat.library12.model.Book;
import com.mrizzat.library12.model.BookDa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class addBooks extends AppCompatActivity {

    BookDa Controller;
    Button addBook;
    EditText edtTitle;
    Spinner Spinner;
    EditText edtPage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Controller = new BookDa();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            loadBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);
        getSupportActionBar().setTitle("Library App System");

        addBook = findViewById(R.id.btnAddBook);

        edtTitle = findViewById(R.id.edtTitle);
        Spinner = findViewById(R.id.spnTypes);
        edtPage = findViewById(R.id.edtPages);


        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = String.valueOf(edtTitle.getText());
                String types = Spinner.getSelectedItem().toString();
                int pages = Integer.parseInt(String.valueOf(edtPage.getText()));
                Book b = new Book(title,types,pages);
                Log.d("asdsa",b.toFile());
                try {
                    addBook(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



    }

    private void loadBooks() throws IOException {
        Controller.loadBooks(this);

    }

    public void addBook(Book book) throws IOException {
        try {
            Controller.addBook(this,book);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void backtoMain(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}