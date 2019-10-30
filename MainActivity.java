package com.example.sqlitekino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    DatabaseM myDB;
    EditText movie,genre,price;
    Button button_a;
    Button button_s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseM(this);

        movie = (EditText) findViewById(R.id.movieN);
        genre = (EditText)  findViewById(R.id.genreN);
        price = (EditText)  findViewById(R.id.priceN);
        button_a = (Button)findViewById(R.id.buttonA);
        button_s = (Button)findViewById(R.id.buttonS);

        //addData();


    }
    public void sendMovies(View view){
        Intent intent = new Intent(MainActivity.this, displayM.class);
        startActivity(intent);

    }
    public void addData(View view){
        button_a.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Log.e("ran", "ran OnClick");
                        boolean addData_works=myDB.addData(movie.getText().toString(),genre.getText().toString(),price.getText().toString());
                            if(addData_works)
                                Toast.makeText(MainActivity.this, "Movie Added", Toast.LENGTH_SHORT).show();

                            else
                                Toast.makeText(MainActivity.this, "Movie Not Added", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }

}
