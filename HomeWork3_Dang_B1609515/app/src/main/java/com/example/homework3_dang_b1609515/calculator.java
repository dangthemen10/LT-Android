package com.example.homework3_dang_b1609515;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        final EditText edtnhapsoluong =  findViewById(R.id.edtnhapsoluong);
        final EditText edtnhapdongia =  findViewById(R.id.edtnhapdongia);
        final EditText edtnhaptilethue =  findViewById(R.id.edtnhaptilethue);
        Button  btntinhtien =  findViewById(R.id.btntinhtien);
        Button btntieptuc =  findViewById(R.id.btntieptuc);
        final EditText edtthanhtien =  findViewById(R.id.edtthanhtien);
        Button thoatbanhang =  findViewById(R.id.btnthoatbanhang);

        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtnhapdongia.setText("");
                edtnhapsoluong.setText("");
                edtnhaptilethue.setText("");
            }
        });
        btntinhtien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sl = edtnhapsoluong.getText().toString().trim();
                String dg = edtnhapdongia.getText().toString();
                String thue = edtnhaptilethue.getText().toString();
                float tongtien = 0.2f;
                if (sl.equals("")){
                    Toast.makeText(getApplicationContext(),"Can nhap vao so luong",Toast.LENGTH_SHORT).show();
                }else if(edtnhapdongia.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Can nhap vao don gia",Toast.LENGTH_SHORT).show();
                }else  if(edtnhaptilethue.getText().toString().equals("")){
                    tongtien = (float) (Integer.parseInt(sl)*Float.parseFloat(dg)+(Integer.parseInt(sl)*Float.parseFloat(dg)*0.1));
                    edtthanhtien.setText(""+tongtien);
                }
                else {
                    tongtien =  (float) ((Integer.parseInt(sl)*Float.parseFloat(dg)) +(Integer.parseInt(sl)*Float.parseFloat(dg)*Integer.parseInt(thue)/100));
                    edtthanhtien.setText(""+tongtien);
                }
            }
        });
        thoatbanhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

}
