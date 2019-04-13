package com.del222.utsproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BMIAdaper extends ArrayAdapter<BMI> {

    Context context;
    int resource;

    public BMIAdaper(Context context, int resource, ArrayList<BMI> listMahasiswa) {
        super(context, resource, listMahasiswa);

        this.context = context;
        this.resource = resource;

    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        TextView text_nim;
        TextView text_nama;
        TextView text_kelas;

        View view = convertView;

        BMI bmi = getItem(position);

        if (view == null){
            view = LayoutInflater.from(context).inflate(resource, null);
        }
        if (view != null){
            text_nim = view.findViewById(R.id.item_nim);
            text_nama = view.findViewById(R.id.item_nama2);
            text_kelas = view.findViewById(R.id.item_kelas);

            if (text_nama != null){
                text_nama.setText(bmi.getTinggi());
            }
            if (text_nim != null){
                text_nim.setText(bmi.getBerat());
            }
            if (text_kelas != null){
                text_kelas.setText(bmi.getBmi());
            }
        }
        return view;
    }


}
