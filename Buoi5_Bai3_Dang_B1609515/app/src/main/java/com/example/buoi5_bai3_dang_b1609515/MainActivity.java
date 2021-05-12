package com.example.buoi5_bai3_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText textBox;
    static final int READ_BLOCK_SIZE = 100;
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox = (EditText) findViewById(R.id.txtText1);
    }
    public void onClickSave(View view) {
        String str = textBox.getText().toString();
        try
        {

            FileOutputStream fOut = openFileOutput("textfile.txt",
                    Context.MODE_PRIVATE);
            OutputStreamWriter osw = new
                    OutputStreamWriter(fOut);
            //---write the string to the file---
            osw.write(str);osw.flush();
            osw.close();
            //---display file saved message---
            Toast.makeText(getBaseContext(),"File saved successfully!",
                    Toast.LENGTH_SHORT).show();
            //---clears the EditText---
            textBox.setText(" ");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    public void onClickLoad(View view) {
        try
        {
            //……………………………………………………………………………………………………….
            FileInputStream fIn = openFileInput("textfile.txt");
            InputStreamReader isr = new InputStreamReader(fIn);
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;
            while ((charRead = isr.read(inputBuffer))>0)
            {
                //---convert the chars to a String---
                String readString = String.copyValueOf(inputBuffer,0,charRead);
                s += readString;
                inputBuffer = new char[READ_BLOCK_SIZE];
            }
            //---set the EditText to the text that has been
            // read---
            textBox.setText(s);
            Toast.makeText(getBaseContext(),"File loaded successfully!",
                    Toast.LENGTH_SHORT).show();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public void onClickHelp(View view) {
        // TODO Auto-generated method stub
        Intent hd = new Intent(MainActivity.this, StaticfileActivity.class);
        startActivity(hd);
    }

}
