package com.example.sqlitekino;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class displayM extends AppCompatActivity {
    DatabaseM myDB;
    GridView gridView;
    public String[] M;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_m);

        gridView = (GridView) findViewById(R.id.gridMovies);
        myDB = new DatabaseM(this);
        seeMovies();
        gridView.setAdapter(new ImageAdapter(this, M));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent i = new Intent(displayM.this, )



            }
        }

        );


    }
    public void seeMovies(){
        Cursor show = myDB.showMovies();
        if(show.getCount() == 0){
            showMessage("Error", "Nothing Found");
        }

        int numofm = show.getCount();
        M = new String[numofm];
        int counter = 0;
        while(show.moveToNext()){
            int i = show.getColumnIndex("NAME");
            M[counter] = show.getString(i);
            counter++;

        }
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder((this));
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
