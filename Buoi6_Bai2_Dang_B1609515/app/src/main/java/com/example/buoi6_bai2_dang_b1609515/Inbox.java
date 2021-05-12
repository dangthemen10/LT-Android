package com.example.buoi6_bai2_dang_b1609515;


import android.os.Bundle;
import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Inbox extends ListActivity {

    private ListAdapter adapter;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Cursor c = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
        getLoaderManager();
        String[] columns = new String[]{"body"};
        int[] names = new int[]{R.id.row};
        adapter = new SimpleCursorAdapter(this, R.layout.activity_inbox, c, columns, names, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long ida) {
        super.onListItemClick(l, v, position, ida);
        Cursor mycursor = (Cursor) getListView().getItemAtPosition(position);
        Toast toast = Toast.makeText(Inbox.this, "From " +
                mycursor.getString(mycursor.getColumnIndex("address")) + ":\n" +
                mycursor.getString(mycursor.getColumnIndex("body")), Toast.LENGTH_LONG);
        toast.show();
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
