package com.example.buoi4_bai3_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CallLog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Date;


public class DisplayAllCallLog extends AppCompatActivity {
    Button back2;
    ListView lvcallLog;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_call_log);
        back2 = (Button) findViewById(R.id.btntrove2);
        lvcallLog = (ListView) findViewById(R.id.lvcallLog);
        ArrayList<String> list2 = new ArrayList<String>();
        ContentResolver cr2 = getContentResolver();
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list2);
        lvcallLog.setAdapter(adapter2);
        // Lấy lịch sử cuộc gọi
        String[] projection = new String[]{CallLog.Calls.DATE, CallLog.Calls.NUMBER, CallLog.Calls.DURATION};
        if (checkSelfPermission(Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            // Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            // public void onRequestPermissionsResult(int requestCode, String[]permissions,
                    // int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        Cursor managedCursor = getContentResolver().query(CallLog.Calls.CONTENT_URI,projection, CallLog.Calls.DURATION + "<?", new String[]{"30"}, CallLog.Calls.DATE + " Asc"); // Asc: sắp theo thứ tự tăng dần
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);

        while (managedCursor.moveToNext()) {
            // lấy các cột trong cursor
            String phNumber = managedCursor.getString(number);
            String callDate = managedCursor.getString(date);
            Date callDayTime = new Date(Long.valueOf(callDate));
            String callDuration = managedCursor.getString(duration);

            // hiển thị toàn bộ lịch sử cuộc gọi
            String cuocgoi = "Phone Number:--- " + phNumber + " \nCall Type:--- " + "?" + " \nCall Date:--- " + callDayTime + " \nCall duration in sec :--- " + callDuration + "\n----------------------------------";
            list2.add(cuocgoi);
            adapter2.notifyDataSetChanged();
        }
        managedCursor.close();
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
