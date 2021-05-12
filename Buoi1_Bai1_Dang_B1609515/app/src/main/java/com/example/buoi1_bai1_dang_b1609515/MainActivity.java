package com.example.buoi1_bai1_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnTest = (Button) findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                DisplayToast("You have clicked the TEST button");
            }
        });
        //---Button Exit---
        Button btnexit = (Button) findViewById(R.id.btnexit);
        btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DisplayToast("You have clicked the EXIT button");
                System.exit(0);
            }
        });
        //---ImageButton---
        ImageButton btnImg = (ImageButton) findViewById(R.id.btnImg1);
        btnImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DisplayToast("You have clicked the IMAGEBUTTON button");
                //System.exit(0);
            }
        });
        //---RadioButton---
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1 = (RadioButton) findViewById(R.id.rb1);
                RadioButton rb2 = (RadioButton) findViewById(R.id.rb2);
                // ---- ImageView -------
                ImageView image1 = (ImageView)findViewById(R.id.image1);
                ImageView image2 = (ImageView)findViewById(R.id.image2);
                image1.setVisibility(ImageView.INVISIBLE);
                image2.setVisibility(ImageView.INVISIBLE);
                if (rb1.isChecked()) {
                    image1.setVisibility(ImageView.VISIBLE);
                    image2.setVisibility(ImageView.INVISIBLE);
                }
                if (rb2.isChecked()) {
                    image2.setVisibility(ImageView.VISIBLE);
                    image1.setVisibility(ImageView.INVISIBLE);
                }
            }
        });
        //---CheckBox---
        CheckBox checkBox = (CheckBox) findViewById(R.id.chkAutosave);
        checkBox.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                if (((CheckBox)v).isChecked())
                    DisplayToast("CheckBox is checked");
                else
                    DisplayToast("CheckBox is unchecked");
            }
        });
        //---Star style CheckBox---
        CheckBox checkstar = (CheckBox) findViewById(R.id.star);
        checkstar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                if (((CheckBox)v).isChecked())
                    DisplayToast("Star style CheckBox is checked");
                else
                    DisplayToast("Star style CheckBox is unchecked");
            }
        });
        //---ToggleButton---
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggle_1);
        toggleButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                EditText edit=(EditText) findViewById(R.id.txtName);
                String vanban=edit.getText().toString();
                TextView tx=(TextView)findViewById(R.id.text);
                if (((ToggleButton)v).isChecked())
                    tx.setText(vanban);
                else
                    tx.setText("");
            }
        });
    }
    //---DisplayToast Method---
    private void DisplayToast(String msg) {
        Toast.makeText(getBaseContext(), msg,
                Toast.LENGTH_SHORT).show();
    }
}
