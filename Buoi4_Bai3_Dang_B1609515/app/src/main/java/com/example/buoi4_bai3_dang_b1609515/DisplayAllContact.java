package com.example.buoi4_bai3_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class DisplayAllContact extends AppCompatActivity {
    Button back;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_contact);
        back = (Button)findViewById(R.id.btntrove);
        lv = (ListView)findViewById(R.id.lvcontact);
        ArrayList<String> list=new ArrayList<String>();
        ContentResolver cr = getContentResolver();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
        // lay toan bo danh ba
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                // get id va name cua tung nguoi trong danh ba
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    // lay tat ca cac sdt cua ng co _id = id
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[] { id }, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        // log toan bo so dien thoai ra logcat
                        String contact = "Name: " + name + "|| Phone No: " + phoneNo + "\n--------------------------";
                        list.add(contact);
                        adapter.notifyDataSetChanged();
                    }
                    pCur.close();
                }
            }
        }
        cur.close();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
