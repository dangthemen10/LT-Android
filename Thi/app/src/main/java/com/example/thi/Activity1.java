package com.example.thi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class Activity1 extends AppCompatActivity {
    Button trove;
    ToggleButton turn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        trove = findViewById(R.id.trove);
        turn = findViewById(R.id.turn);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            int key = bundle.getInt("Key");
            if(key == 1){
                turn.setChecked(true);
            }else{
                turn.setChecked(false);
            }
        }
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
