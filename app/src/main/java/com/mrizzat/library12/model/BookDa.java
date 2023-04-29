package com.mrizzat.library12.model;




import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.mrizzat.library12.addBooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class BookDa {
    private ArrayList<Book> books;

    public BookDa() throws IOException {
        books = new ArrayList<Book>();
        //loadBooks();
//        books.add(new Book("Harry Potter","Fantasy",759));
//        books.add(new Book("Calculus and Applications","Mathematics",1502));
//        books.add(new Book("Introduction to Python","Programming",1324));
//        books.add(new Book("Data Structures and Algorithms","Programming",1823));
//        books.add(new Book("How to think like a millionare","Business",547));
    }

    public ArrayList<Book> getBooksByType(String type){
        ArrayList<Book> results = new ArrayList<Book>();

        for(Book b:books){
            if(b.getType().equalsIgnoreCase(type)){
                results.add(b);
            }
        }


        return results;
    }
    public void loadBooks(Context c) throws IOException{
//        File test = new File("\"C:\\Users\\Mr Izzat\\Desktop\\New Text Document.txt");
//        Scanner sc = new Scanner(test);
//        while(sc.hasNextLine()){
//            Log.d("Test", sc.nextLine());
//        }
        InputStream fis = c.getAssets().open("books2.txt");
        int size = fis.available();
        byte[] buf = new byte[size];
        fis.read(buf);
        fis.close();
        String file = new String(buf);

        String[] Tbooks = file.split("\n");;
        for(int i=0;i<Tbooks.length;i++){
            Log.d("ASDASDA",Tbooks[i]);
            String[] temp = Tbooks[i].split("\\|");
            Book b = new Book(temp[0],temp[1],Integer.parseInt(temp[2]));
            books.add(b);
        }
    }

    public String loadBookstoString(Context c) throws IOException{
        InputStream fis = c.getAssets().open("books2.txt");
        int size = fis.available();
        byte[] buf = new byte[size];
        fis.read(buf);
        fis.close();
        String file = new String(buf);
        return file;
    }
    public void addBook(Context c,Book book) throws IOException {


    }

    public String[] getBookTypes(){
        String[] types = {"Programming","Database","Testing" };
        return types;
    }
    //TODO: add..... remove.....
}
