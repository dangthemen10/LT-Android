package com.example.buoi4_bai3_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Button btgetAllCallLogs, btgetAllContacts, btgetMediaList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // link button den layout de dieu khien
        btgetAllCallLogs = (Button) findViewById(R.id.btgetAllCallLogs);
        btgetAllContacts = (Button) findViewById(R.id.btgetAllContacts);
        btgetMediaList = (Button) findViewById(R.id.btgetMediaList);
        // dang ky lang nghe su kien onclick vao cac button
        btgetAllCallLogs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO Auto-generated mehtod stub
                Intent intent1 = new Intent(MainActivity.this, DisplayAllCallLog.class);
                startActivity(intent1);
            }
        });
        btgetAllContacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO Auto-generated mehtod stub
                Intent intent2 = new Intent(MainActivity.this, DisplayAllContact.class);
                startActivity(intent2);
            }
        });
        btgetMediaList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO Auto-generated mehtod stub
                Intent intent3 = new Intent(MainActivity.this, DisplayMediaList.class);
                startActivity(intent3);
            }
        });
    }
}
