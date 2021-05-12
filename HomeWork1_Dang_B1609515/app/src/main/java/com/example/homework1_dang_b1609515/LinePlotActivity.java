package com.example.homework1_dang_b1609515;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.*;
import java.util.*;
import static java.lang.Float.*;
import static java.lang.Float.parseFloat;

public class LinePlotActivity extends AppCompatActivity {
    private XYPlot plot;
    Float[] domainLabels;
    Float[] series1Numbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_plot);
        plot = (XYPlot) findViewById(R.id.plot);
//Lấy về Bundle được gửi kèm Intent rồi lấy ra các ArrayList đã được gởi đến.
        Bundle receiveBundle = this.getIntent().getExtras();
        final ArrayList<String> numberx = receiveBundle.getStringArrayList("xLabels");
        final ArrayList<String> numbery = receiveBundle.getStringArrayList("yData");
// Chuyển các ArrayList thành Array, 1 cặp mảng giá trị trên trục x và trục y
        final Float[] domainLabels = new Float[numberx.size()];
        for (int i = 0; i < numberx.size(); i++) {
            domainLabels[i] = parseFloat(numberx.get(i));
        }
        final Float[] series1Numbers = new Float[numbery.size()];
        for (int i = 0; i < numbery.size(); i++) {
            series1Numbers[i] = parseFloat(numbery.get(i));
        }
        XYSeries series1 = new SimpleXYSeries(
                Arrays.<Float>asList(series1Numbers),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series1");
// Tạo các định dạng dùng cho việc vẽ một chuỗi sử dụng LineAndPointRenderer
// và cấu hình chúng từ tập tin xml xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter(Color.RED,
                Color.GREEN, Color.BLUE, null);
// Để cho đẹp, thêm sự làm mịn cho đồ thị đường
// Xem tại URL: http://androidplot.com/smooth-curves-and-androidplot/
        series1Format.setInterpolationParams(
                new CatmullRomInterpolator.Params(10,
                        CatmullRomInterpolator.Type.Centripetal));
// Thêm một series vào the xyplot:
        plot.addSeries(series1, series1Format);
        plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new
                                                                                       Format() {
                                                                                           @Override
                                                                                           public StringBuffer format(Object obj, StringBuffer toAppendTo,
                                                                                                                      FieldPosition pos) {
                                                                                               int i = Math.round(((Number) obj).floatValue());
                                                                                               return toAppendTo.append(domainLabels[i]);
                                                                                           }
                                                                                           @Override
                                                                                           public Object parseObject(String source, ParsePosition pos) {
                                                                                               return null;
                                                                                           }
                                                                                       });
    }
}
