package com.del222.utsproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_tinggi ;
    EditText editText_berat ;
    EditText editText_bmi ;
    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_tinggi = findViewById(R.id.editText_tinggi);
        editText_berat = findViewById(R.id.editText_berat);
        editText_bmi = findViewById(R.id.editText_bmi);

        dbHelper = new DatabaseHelper(this);

    }

    public void addData (View view){
        String tinggi = editText_tinggi.getText().toString();
        String berat = editText_berat.getText().toString();
        String bmi = editText_bmi.getText().toString();

        boolean result =  dbHelper.insertData(tinggi, berat, bmi);

        if (result){
            Toast.makeText(this,"Data Added", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this,"Data Not Added", Toast.LENGTH_SHORT).show();
        }

    }

    public void viewData (View view){
        Intent viewIntent = new Intent(this, List.class);
        startActivity(viewIntent);
    }

    public void deleteData (View view){

    }

}
