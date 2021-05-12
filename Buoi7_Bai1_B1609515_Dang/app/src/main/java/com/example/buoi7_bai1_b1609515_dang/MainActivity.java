package com.example.buoi7_bai1_b1609515_dang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.net.URISyntaxException;
import java.util.ArrayList;


import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;





public class MainActivity extends AppCompatActivity {
    private Socket mSocket;
    private  ListView lvUser, lvChat;
    private EditText edtContent;
    private ImageButton btnAdd, btnSend;
    ArrayList<String> arrayUser, arrayChat;
    ArrayAdapter adapterUser, adapterChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btn_login);
        btnSend = findViewById(R.id.btnchat);
        edtContent = findViewById(R.id.editTextContent);
        lvChat = findViewById(R.id.listviewChat);
        lvUser = findViewById(R.id.listviewUser);


        try {
            mSocket = IO.socket( "http://192.168.43.99:3000");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mSocket.connect();
        mSocket.on("server-send-result", onRetrieveResult);
        mSocket.on("server-send-user", onListUser);
        mSocket.on("server-send-chat", onListChat);
        arrayChat = new ArrayList<>();
        adapterChat = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayChat);
        lvChat.setAdapter(adapterChat);
        arrayUser = new ArrayList<>();
        adapterUser = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayUser);
        lvUser.setAdapter(adapterUser);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtContent.getText().toString().trim().length() > 0){
                    mSocket.emit("client-register-user", edtContent.getText().toString());
                    //Toast.makeText(MainActivity.this,edtContent.getText().toString(),Toast.LENGTH_LONG).show();
                }

            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtContent.getText().toString().trim().length() > 0){
                    mSocket.emit("client-send-chat", edtContent.getText().toString());
                    //Toast.makeText(MainActivity.this,edtContent.getText().toString(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private  Emitter.Listener onListChat = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        String noiDung = object.getString("chatContent");
                        arrayChat.add(noiDung);
                        adapterChat.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };

    private Emitter.Listener onListUser = new Emitter.Listener(){
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        JSONArray array = object.getJSONArray("danhsach");
                        arrayUser.clear();
                        for(int i = 0; i < array.length(); i++){
                            String username = array.getString(i);
                            arrayUser.add(username);
                        }
                        adapterUser.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    };





    private Emitter.Listener onRetrieveResult = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        boolean exits = object.getBoolean("ketqua");
                        if(exits){
                            Toast.makeText(MainActivity.this, "Tài khoản này đã tồn tại !", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Đăng ký thành công !", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };


}
