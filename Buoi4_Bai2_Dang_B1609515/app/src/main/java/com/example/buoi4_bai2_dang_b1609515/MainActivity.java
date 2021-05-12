package com.example.buoi4_bai2_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.database.Cursor;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();

        values.put(StudentsProvider.NAME,((EditText)findViewById(R.id.editText2)).getText().toString());

        values.put(StudentsProvider.BUOI,((EditText)findViewById(R.id.editText3)).getText().toString());
        Uri uri = getContentResolver().insert(StudentsProvider.CONTENT_URI, values);
        Toast.makeText(getBaseContext(),uri.toString(), Toast.LENGTH_LONG).show();
    }
    public void onClickRetrieveStudents(View view) {
        Uri students = StudentsProvider.CONTENT_URI;
        String[] projection = {StudentsProvider._ID, StudentsProvider.NAME, StudentsProvider.BUOI};
        CursorLoader loader = new CursorLoader(this,students, projection,null, null,null);
        Cursor c = loader.loadInBackground();
        c.moveToFirst();
        String s = "";
        while (!c.isAfterLast()){
            for (int i=0; i<c.getColumnCount();i++){
                s+= c.getString(i)+"\n";
            }
            s+="\n";
            c.moveToNext();
        }
        displayToast(s);
        c.close();
    }
    private void displayToast(String msg) {
        Toast toast = new Toast(this);
        TextView tv4 = new TextView(this);
        tv4.setBackgroundColor(Color.BLACK);
        tv4.setTextColor(Color.YELLOW);
        tv4.setTextSize(25);
        Typeface t4 = Typeface.create("serif", Typeface.BOLD);
        tv4.setTypeface(t4);
        tv4.setPadding(10, 10, 10, 10);
        tv4.setText(msg);
        toast.setGravity(Gravity.CENTER, 10, 100);
        toast.setView(tv4);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}
