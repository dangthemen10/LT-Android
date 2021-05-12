package com.example.buoi6_bai1_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText addressBar;
    private WebView webView;
    private Button run;
    private Button conn;
    private TextView status;
    private TextView network;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        run = findViewById(R.id.btrun);
        conn = findViewById(R.id.btncon);
        addressBar = findViewById(R.id.edturl);
        webView =(WebView)findViewById(R.id.webView);
        status = findViewById(R.id.tvStatus);
        network = findViewById(R.id.tvNetwork);
        webView.setWebViewClient(new MyWebViewClient(addressBar));
        run.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                goUrl();
            }
        });
        conn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {

                checkInternetConnection();
            }
        });
    }
    private void goUrl(){
        String url = addressBar.getText().toString().trim();
        if(url.isEmpty())  {
            Toast.makeText(this,"Please enter url", Toast.LENGTH_SHORT).show();
            return;
        }
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
    }
    private boolean checkInternetConnection() {
        ConnectivityManager connManager =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        int type = networkInfo.getType();
        if(type == ConnectivityManager.TYPE_MOBILE){
            network.setText( "3G - ");
        }
        else if(type == ConnectivityManager.TYPE_WIFI){
            network.setText( "Wifi - ");
        }
        else if(type == ConnectivityManager.TYPE_BLUETOOTH){
            network.setText( "Bluetooth - ");
        }
        else {
            network.setText( "Non - ");
        }
        if (networkInfo == null) {
            Toast.makeText(this, "No default network is currently active", Toast.LENGTH_LONG).show();
            return false; }
        if (!networkInfo.isConnected()) {
            Toast.makeText(this, "Network is not connected", Toast.LENGTH_LONG).show();
            return false; }
        if (!networkInfo.isAvailable()) {
            Toast.makeText(this, "Network not available", Toast.LENGTH_LONG).show();
            return false; }
        status.setText("Network ok!");
        return true;
    }
}
