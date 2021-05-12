package com.example.homework3_dang_b1609515;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Math.pow;

public class change extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        Button btnTPsangNP =  findViewById(R.id.btnTPsangNP);
        Button btnNPsangTP =  findViewById(R.id.btnNPsangTP);
        Button backnhiphan =  findViewById(R.id.btnbacknhiphan);
        final EditText edtnhapso =  findViewById(R.id.edtnhapso);
        final EditText edtThapphan =  findViewById(R.id.edtThapphan);
        final EditText edtNhiphan =  findViewById(R.id.edtNhiphan);

        btnTPsangNP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = edtnhapso.getText().toString().trim();
                if (Integer.parseInt(number)<0){
                    Toast.makeText(getApplicationContext(),"Vui long nhap so lon hon 0",Toast.LENGTH_SHORT).show();
                }else {
                    String kq = Integer.toBinaryString(Integer.parseInt(number));
                    edtThapphan.setText(number);
                    edtNhiphan.setText(kq);
                }
            }
        });
        btnNPsangTP.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String number = edtnhapso.getText().toString().trim();
                long sonhiphan = ConvertDecimal(number);
                edtNhiphan.setText(number+"");
                edtThapphan.setText(sonhiphan+"");
            }
            private long ConvertDecimal(String number){
                long Decimal=0,i=0,remainder;
                while (Long.parseLong(number)!=0){
                    remainder = Long.parseLong(number)%10;
                    number = String.valueOf(Long.parseLong(number)/10);
                    Decimal+=remainder*pow(2,i);
                    i++;
                }
                return  Decimal;
            }
        });
        backnhiphan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

}
