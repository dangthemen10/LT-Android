package com.example.kiem_tra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    EditText thuchanh, dienkhuyet, tracnghiem, thuchanh1;
    Button tieptuc, diemtonghop, thoat;
    TextView kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        thuchanh = (EditText)findViewById(R.id.thuchanh);
        dienkhuyet = (EditText)findViewById(R.id.dienkhuyet);
        tracnghiem = (EditText)findViewById(R.id.tracnghiem);
        thuchanh1 = (EditText)findViewById(R.id.thuchanh1);
        tieptuc = (Button)findViewById(R.id.tieptuc);
        diemtonghop = (Button)findViewById(R.id.diemtonghop);
        thoat = (Button)findViewById(R.id.thoat);
        kq = (TextView)findViewById(R.id.kq);

        tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thuchanh.setText("");
                dienkhuyet.setText("");
                tracnghiem.setText("");
                thuchanh1.setText("");
            }
        });

        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        diemtonghop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = thuchanh.getText().toString().trim();
                String str2 = dienkhuyet.getText().toString().trim();
                String str3 = tracnghiem.getText().toString().trim();
                String str4 = thuchanh1.getText().toString().trim();
                double ketqua = 0;
                if(str1.equals("")){
                    Toast.makeText(Activity2.this, "Bạn chưa nhập điểm thực hành", Toast.LENGTH_SHORT).show();
                }else if(str2.equals("")){
                    Toast.makeText(Activity2.this, "Bạn chưa nhập điểm điền khuyết", Toast.LENGTH_SHORT).show();
                }else if(str3.equals("")){
                    Toast.makeText(Activity2.this, "Bạn chưa nhập điểm trắc nghiệm", Toast.LENGTH_SHORT).show();
                }else if(str4.equals("")){
                    Toast.makeText(Activity2.this, "Bạn chưa nhập điểm thi thực hành", Toast.LENGTH_SHORT).show();
                }else{
                    ketqua = ((float)Float.parseFloat(str1)*0.2 + (float)Float.parseFloat(str2)*0.2 + (float)Float.parseFloat(str3)*0.3 + (float)Float.parseFloat(str4)*0.3);
                    kq.setText(""+ketqua);
                }
            }
        });
    }
}
