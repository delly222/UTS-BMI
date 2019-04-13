package com.del222.utsproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    ListView listView_bmi;
    DatabaseHelper dbHelper;
    BMI bmi;
    ArrayList<BMI> ArrayListBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        listView_bmi = findViewById(R.id.list_view_bmi);
        dbHelper = new DatabaseHelper(this);
        ArrayList<BMI> ArraylistBMI = getAllData();

        BMIAdaper adapter = new BMIAdaper(this, R.layout.item, ArraylistBMI);
        listView_bmi.setAdapter(adapter);
    }

    public ArrayList<BMI> getAllData(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor data = dbHelper.getData();
        ArrayList<BMI> list = new ArrayList<>();

        data.moveToFirst();

        if (data.getCount() > 0){
            do {
                bmi = new BMI();
                bmi.setTinggi(data.getString(0));
                bmi.setBerat(data.getString(1));
                bmi.setBmi(data.getString(2));


                list.add(bmi);
                data.moveToNext();
            }while (!data.isAfterLast());
        }
        return list;

    }

}
