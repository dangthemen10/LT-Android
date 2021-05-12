package com.example.kiem_tra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {
    CheckBox check1;
    EditText edit;
    TextView txt3, txt4, txt5;
    Button chuyendoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        check1 = (CheckBox)findViewById(R.id.check1);
        edit = (EditText)findViewById(R.id.edit);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);
        txt5 = (TextView)findViewById(R.id.txt5);
        chuyendoi = (Button)findViewById(R.id.chuyendoi);
        chuyendoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String giatri = edit.getText().toString().trim();
                double ketqua = 0;
                if(check1.isChecked()){
                    if(giatri.equals("")){
                        Toast.makeText(Activity1.this, "Bạn chưa nhập giá trị", Toast.LENGTH_SHORT).show();
                    }else{
                        ketqua = (5.5/100) * (float)Float.parseFloat(giatri);
                        txt4.setText(""+ketqua);
                        txt3.setText("mg/dL");
                        txt5.setText("mmol/L");
                    }
                }else{
                    if(giatri.equals("")){
                        Toast.makeText(Activity1.this, "Bạn chưa nhập giá trị", Toast.LENGTH_SHORT).show();
                    }else{
                        ketqua = Math.round(100/5.5* (float)Float.parseFloat(giatri));
                        txt4.setText(""+ketqua);
                        txt3.setText("mmol/L");
                        txt5.setText("mg/dL");
                    }
                }
            }
        });
    }
}
