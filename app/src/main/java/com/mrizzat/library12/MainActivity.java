

package com.mrizzat.library12;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Library App System");

    }

    public void openAddBook(View view) {
        startActivity(new Intent(this,addBooks.class));
    }

    public void openSearchBookType(View view) {
        startActivity(new Intent(this,searchBookbyType.class
        ));
    }
}