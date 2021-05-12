package com.example.homework3_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class check extends AppCompatActivity {
    private ArrayList arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        Button thoatchanle =  findViewById(R.id.btnthoatchanle);
        final EditText nhapvaoso =  findViewById(R.id.nhapso) ;
        Button btnketqua =  findViewById(R.id.btnketqua);
        final TextView txtchanhayle =  findViewById(R.id.txtchanhayle);
        final TextView txtdaysovuanhap =  findViewById(R.id.txtdaysovuanhap);
        thoatchanle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        btnketqua.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String nhapmotso = nhapvaoso.getText().toString();
                if (nhapmotso.equals("")){
                    Toast.makeText(getApplicationContext(),"Vui long nhap vao mot so nguyen",Toast.LENGTH_SHORT).show();
                }else {
                    if ((Integer.parseInt(nhapmotso)%2)==0){
                        txtchanhayle.setText("Chẳn");
                        arrayList.add(nhapvaoso.getText().toString());
                        txtdaysovuanhap.setText(arrayList+" ");
                    }else {
                        txtchanhayle.setText("Lẻ");
                        txtdaysovuanhap.setText(nhapmotso);
                        arrayList.add(nhapvaoso.getText().toString());
                        txtdaysovuanhap.setText(arrayList+" ");
                    }
                }
            }
        });
        arrayList=new ArrayList();
    }

}
