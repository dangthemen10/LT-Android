package com.example.homework3_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnmenu = findViewById(R.id.btnchucnang);
        btnmenu.setOnCreateContextMenuListener(this);
        final Button thoat =  findViewById(R.id.btnthoat);
        final CheckBox cb =  findViewById(R.id.checkbox);
        final AnalogClock dongho = findViewById(R.id.analog);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb.isChecked()){
                    dongho.setVisibility(View.VISIBLE);
                }else {
                    dongho.setVisibility(View.INVISIBLE);
                }
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        CreateContextMenu(menu);
    }
    public void CreateContextMenu(Menu menu) {
        MenuItem m1=menu.add(0, 0, 0, "KIỂM TRA CHẲN LẺ");
        {
            m1.setAlphabeticShortcut('a');
        }
        MenuItem m2=menu.add(0, 1, 1, "ĐỔI THẬP PHÂN - NHỊ PHÂN");
        {
            m2.setAlphabeticShortcut('b');
        }
        MenuItem m3=menu.add(0, 2, 2, "TÍNH TIỀN BÁN HÀNG");
        {
            m3.setAlphabeticShortcut('c');
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return contextmenuChoice(item);
    }
    public boolean contextmenuChoice(MenuItem item){
        //ImageView hinh=(ImageView)findViewById(R.id.img);
        switch(item.getItemId()){
            case 0:
                Intent i1 = new Intent(this, check.class);
                startActivity(i1);
                return true;
            case 1:
                Intent i2 = new Intent(this, change.class);
                startActivity(i2);
                return true;
            case 2:
                Intent i3 = new Intent(this, calculator.class);
                startActivity(i3);
                return true;
        }
        return false;
    }
}
