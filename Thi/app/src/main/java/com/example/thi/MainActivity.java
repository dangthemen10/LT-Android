package com.example.thi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3;
    TextView txt;
    static int status = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView)findViewById(R.id.txt);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);

        if(status == 1){
            txt.setText("Đã mở");
        }else{
            txt.setText("Đã tắt");
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 1;
                txt.setText("Đã mở");
                Intent intent = new Intent(MainActivity.this, Activity1.class);
                Bundle bundle = new Bundle();
                bundle.putInt("key", status);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 0;
                txt.setText("Đã tắt");
                Intent intent = new Intent(MainActivity.this, Activity1.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Key",status);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
