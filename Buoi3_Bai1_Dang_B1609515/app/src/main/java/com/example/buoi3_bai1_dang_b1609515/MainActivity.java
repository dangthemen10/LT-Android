package com.example.buoi3_bai1_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nut1 = (Button) this.findViewById(R.id.btn1);
        nut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, Activity1.class);
                startActivity(intent);
            }
        });
        Button nut2=(Button)this.findViewById(R.id.btn2);
        nut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// TODO Auto-generated method stub
                Intent i2 = new Intent(MainActivity.this,Activity2.class);
                startActivity(i2);
            }
        });
        Button nut3=(Button)this.findViewById(R.id.btn3);
        nut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                Intent i3 = new Intent(MainActivity.this,Activity3.class);
                startActivity(i3);
            }
        });

        Button nut4=(Button)this.findViewById(R.id.btn4);
        nut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                Intent i4 = new Intent(MainActivity.this,Activity4.class);
                startActivity(i4);
            }
        });
        Button nut5=(Button)this.findViewById(R.id.btn5);
        nut5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                Intent i5 = new Intent(MainActivity.this,Activity5.class);
                startActivity(i5);
            }
        });
        Button nut6=(Button)this.findViewById(R.id.btn6);
        nut6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                System.exit(0);
            }
        });

    }
}
