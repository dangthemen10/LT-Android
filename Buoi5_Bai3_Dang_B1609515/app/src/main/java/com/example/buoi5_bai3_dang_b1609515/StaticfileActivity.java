package com.example.buoi5_bai3_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StaticfileActivity extends AppCompatActivity {

    TextView textView;
    static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staticfile);
        textView = (TextView) findViewById(R.id.txtHuongDan);

        InputStream is = this.getResources().openRawResource(R.raw.huongdan);
        InputStreamReader ir=new InputStreamReader(is);
        BufferedReader br = new BufferedReader(ir);
        String str = null;
        String huondan = "";
        try {
            while ((str = br.readLine()) != null) {
                huondan += str + " ";
            }
            is.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textView.setText(huondan);

    }
}

