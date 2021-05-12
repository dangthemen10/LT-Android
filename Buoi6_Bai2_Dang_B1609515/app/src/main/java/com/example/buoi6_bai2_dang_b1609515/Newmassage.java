package com.example.buoi6_bai2_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Newmassage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmassage);
        Button btn = (Button)this.findViewById(R.id.send);
        Button exit = (Button)this.findViewById(R.id.exitinbox);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub
                EditText phone = (EditText)Newmassage.this.findViewById(R.id.phone);
                EditText message = (EditText)Newmassage.this.findViewById(R.id.message);
                try{
/*………………………………………………………………………………………………………………………………………………………………………………………………………..
……………………………………………………………………………………………………………………………………………………………………………………………………*/
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(phone.getText().toString(), null,
                            message.getText().toString(), null, null);
                    Toast toast = Toast.makeText(Newmassage.this, "Success", Toast.LENGTH_LONG);
                    toast.show();
                }catch(Exception e){
                    Toast toast = Toast.makeText(Newmassage.this, "Fail",Toast.LENGTH_LONG);
                    toast.show();
                    e.printStackTrace();
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub
                finish();
            }
        });
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
    protected void onDestroy(){
        super.onDestroy();
    }
}
