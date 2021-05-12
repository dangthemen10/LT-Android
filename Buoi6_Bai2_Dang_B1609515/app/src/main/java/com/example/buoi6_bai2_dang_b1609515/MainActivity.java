package com.example.buoi6_bai2_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView inbox = (TextView)this.findViewById(R.id.inbox);
        TextView newmess = (TextView)this.findViewById(R.id.newmessage);
        TextView exit = (TextView)this.findViewById(R.id.exit);
        newmess.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent newmess = new Intent(MainActivity.this, Newmassage.class);
                startActivity(newmess);
            }
        });
        inbox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent inbox = new Intent(MainActivity.this, Inbox.class);
                startActivity(inbox);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
