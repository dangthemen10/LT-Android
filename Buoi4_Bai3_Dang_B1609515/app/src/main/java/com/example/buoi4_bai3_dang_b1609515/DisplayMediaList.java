package com.example.buoi4_bai3_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.os.Bundle;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayMediaList extends AppCompatActivity {
    Button back3;
    ListView lvmedialist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_media_list);
        back3 = (Button) findViewById(R.id.btntrove3);
        lvmedialist = (ListView) findViewById(R.id.lvmedialist);
        ArrayList<String> list3 = new ArrayList<String>();
        ContentResolver cr3 = getContentResolver();
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list3);
        lvmedialist.setAdapter(adapter3);
        // Lấy media
        String []projection={MediaStore.MediaColumns.DISPLAY_NAME, MediaStore.MediaColumns.DATE_ADDED, MediaStore.MediaColumns.MIME_TYPE};
        CursorLoader loader=new CursorLoader(this, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projection, null, null, null);
        Cursor c=loader.loadInBackground();
        c.moveToFirst();
        String s="";
        while(!c.isAfterLast()){
            for(int i=0;i<c.getColumnCount();i++){
                s+=c.getString(i)+" - ";
            }
            s+="\n";
            c.moveToNext();
        }
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        c.close();
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
