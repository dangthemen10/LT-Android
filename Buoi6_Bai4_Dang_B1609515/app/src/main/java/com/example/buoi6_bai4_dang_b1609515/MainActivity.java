package com.example.buoi6_bai4_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    public InputStream OpenHttpConnection(PostComponent component) throws
            IOException {
        /** (1) Khởi tạo một đối tượng InputStream từ URL và đối số truyền vào **/
        InputStream in = null;
        int response = -1;
        URL url = new URL(component.getURL());
        // Mở kết nối tới url
        URLConnection conn = url.openConnection();
        // Nếu không là một HttpURLConnection
        // thì thông báo không có kết nối HTTP
        if (!(conn instanceof HttpURLConnection))
            throw new IOException("Not an HTTP connection");
        try {
            /******** (2) Mở kết nối HTTP với URL từ xa ********/
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            /******** (3) Thiết lập các thuộc tính kết nối ********/
            //Thời gian đọc InputStream tối đa 15000ms
            httpConn.setReadTimeout(15000);
            //Thời gian tối đa giữ kết nối với Server
            httpConn.setConnectTimeout(15000);
            //Phương thức kết nối là POST
            httpConn.setRequestMethod("POST");
            //Đặt cờ chỉ ra kết nối này cho phép có Output hoặc Input
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            /******** (4) Gửi đi POST request ********/
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            //Hàm getPostDataString dùng để chuyển dữ liệu thành chuỗi
            writer.write(getPostDataString(component.getParam()));
            writer.flush();
            writer.close();
            os.close();
            /* (5) Lấy đáp ứng HTTP_OK để biết kết nối đã được thiết lập hay chưa */
            response = httpConn.getResponseCode();
            Log.w("Respone Code", "" + response);

/*****************************************************************
 * (6) Nếu kết nối được thiết lập thì tiến hành
 * lấy đối tượng InputStream từ kết nối để lấy dữ liệu từ Server


 ****************************************************************/
            if (response == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        } catch (Exception e) {
            Log.e("Networking", e.getLocalizedMessage());
        }
        return in;
    }
/**************************** LƯU Ý *************************************
 * Để kết nối Internet,cần thêm lệnh sau vào AndroidManifest.xml: *
 * <uses-permission android:name="android.permission.INTERNET" /> *

 ************************************************************************/
    /**
     * Lấy dữ liệu text từ Server
     *
     * @param component
     * @return String
     */
    public String getTextInfo(PostComponent component) {
        int BUFFER_SIZE = 2000;
        InputStream in = null;
        String str = "";
        try {
            in = OpenHttpConnection(component);
        } catch (IOException e) {
            Log.e("Networking", e.getLocalizedMessage());
            return str;
        }
        if (in == null){
            Log.e("URL", "Check connection or URL again!");
            return str;
        }
        try {
            InputStreamReader isr = new InputStreamReader(in);
            int charRead;
            char[] inputBuffer = new char[BUFFER_SIZE];
            while ((charRead = isr.read(inputBuffer)) > 0) {
                //Chuyển chars thành String
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                str += readString;
                inputBuffer = new char[BUFFER_SIZE];
            }
            in.close();
        } catch (IOException e) {
            Log.e("Networking", e.getLocalizedMessage());
            return "";
        }
        return str;
    }
    private class GetServerResponse extends AsyncTask<PostComponent, Void,
            String> {
        protected String doInBackground(PostComponent... postComponents) {
            return getTextInfo(postComponents[0]);
        }
        @Override
        protected void onPostExecute(String result) {
            TextView tv = (TextView) findViewById(R.id.tv);
            if (tv != null) {
                tv.setText(result);
            }
        }
    }
    /**
     * Đối tượng POST gồm
     * URL: giữ địa chỉ dẫn tới nơi lấy dữ liệu
     * JSONObject: đối số để lấy được dữ liệu
     */
    private class PostComponent {
        String URL;
        JSONObject param;
        PostComponent(String URL, JSONObject param) {
            this.URL = URL;
            this.param = param;
        }
        public String getURL() {
            return URL;
        }
        public JSONObject getParam() {
            return param;
        }
    }
    /**
     * Chuyển đối tượng JSON (giữ 2 giá trị) về kiểu String
     *
     * @param params
     * @return String
     */
    public String getPostDataString(JSONObject params) throws Exception {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        Iterator<String> itr = params.keys();
        while (itr.hasNext()) {
            String key = itr.next();
            Object value = params.get(key);
            if (first)
                first = false;
            else
                result.append("&");
            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));
        }
        return result.toString();
    }

    EditText edtURL;
    Button btnConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtURL = findViewById(R.id.edtURL);
        btnConnect = findViewById(R.id.btnConnect);

        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String URL;// = "http://10.0.2.2/Buoi_6/thongtin.php";
                URL = edtURL.getText().toString().trim();
                JSONObject postParams = new JSONObject();
                try {
                    postParams.put("mssv", "B1609515");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                PostComponent postRequest = new PostComponent(URL, postParams);
                new GetServerResponse().execute(postRequest);
            }
        });
    }
}
