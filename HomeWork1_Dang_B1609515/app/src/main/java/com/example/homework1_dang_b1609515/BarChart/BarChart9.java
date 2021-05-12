package com.example.homework1_dang_b1609515.BarChart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;
import com.example.homework1_dang_b1609515.R;

public class BarChart9 extends AppCompatActivity {

    BarChart mChart;
    TextView textView,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10;
    String Des1,Des2,Des3,Des4,Des5,Des6,Des7,Des8,Des9,Title;
    BarData databar9;
    double amountbar1,amountbar2,amountbar3,amountbar4,amountbar5,amountbar6,amountbar7,amountbar8,amountbar9;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart9);
        textView = (TextView) findViewById(R.id.texViewBar);
        textView2 = (TextView) findViewById(R.id.textviewtenduong1);
        textView3 = (TextView) findViewById(R.id.textviewtenduong2);
        textView4 = (TextView) findViewById(R.id.textviewtenduong3);
        textView5 = (TextView) findViewById(R.id.textviewtenduong4);
        textView6 = (TextView) findViewById(R.id.textviewtenduong5);
        textView7 = (TextView) findViewById(R.id.textviewtenduong6);
        textView8 = (TextView) findViewById(R.id.textviewtenduong7);
        textView9 = (TextView) findViewById(R.id.textviewtenduong8);
        textView10 = (TextView) findViewById(R.id.textviewtenduong9);
        // Tương tác click vào mũi tên trở về.
        imageButton = (ImageButton) findViewById(R.id.imagebuttoncot);//Back
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Khai báo gia diện đồ thị BarCharts
        mChart = findViewById(R.id.BarChartMpAndroid);
        // Khai báo Intent và lấy dữ liệu từ BarChartsActivity gởi đến.
        Intent intent = getIntent();
        amountbar1 = intent.getDoubleExtra("cot1", 123);
        amountbar2 = intent.getDoubleExtra("cot2", 123);
        amountbar3 = intent.getDoubleExtra("cot3", 123);
        amountbar4 = intent.getDoubleExtra("cot4", 123);
        amountbar5 = intent.getDoubleExtra("cot5", 123);
        amountbar6 = intent.getDoubleExtra("cot6", 123);
        amountbar7 = intent.getDoubleExtra("cot7", 123);
        amountbar8 = intent.getDoubleExtra("cot8", 123);
        amountbar9 = intent.getDoubleExtra("cot9", 123);
        Title = intent.getStringExtra("tendothi"); // Lấy tên đố thị
        Des1 = intent.getStringExtra("tencot1"); // Lấy tên cột 1
        Des2 = intent.getStringExtra("tencot2"); // lấy tên cột 2
        Des3 = intent.getStringExtra("tencot3"); // Lấy tên cột 3
        Des4 = intent.getStringExtra("tencot4"); // Lấy tên cột 4
        Des5 = intent.getStringExtra("tencot5"); // Lấy tên cột 5
        Des6 = intent.getStringExtra("tencot6"); // Lấy tên cột 6
        Des7 = intent.getStringExtra("tencot7"); // Lấy tên cột 7
        Des8 = intent.getStringExtra("tencot8"); // Lấy tên cột 8
        Des9 = intent.getStringExtra("tencot9"); // Lấy tên cột 9
        // Hiển thị tên đồ thị và tên các cộ
        textView.setText("Đồ thị: " + Title); // Hiển thị tên đồ thị
        textView2.setText("1-" + Des1); // Hiển thị tên cộ 1
        textView3.setText("2-" + Des2); // Hiển thị tên cột 2
        textView4.setText("3-" + Des3); // Hiển thị tên cộ 3
        textView5.setText("4-" + Des4); // Hiển thị tên cộ 4
        textView6.setText("5-" + Des5); // Hiển thị tên cộ 5
        textView7.setText("6-" + Des6); // Hiển thị tên cộ 6
        textView8.setText("7-" + Des7); // Hiển thị tên cộ 7
        textView9.setText("8-" + Des8); // Hiển thị tên cộ 8
        textView10.setText("9-" + Des9); // Hiển thị tên cộ 9
        // Đặt các thuộc tính của đồ thị
        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);
        mChart.getDescription().setEnabled(false);
        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart.setMaxVisibleValueCount(60);
        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);
        mChart.setDrawGridBackground(false);
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(15);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setTextSize(15);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(8, false);
        rightAxis.setTextSize(15);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);
        setDataBar9(9, 100);
        mChart.setData(databar9); //Đã khai báo ở trên BarData databar3;
        mChart.setVisibility(View.VISIBLE);
        mChart.invalidate();
    }
    private void setDataBar9(int count, float range) {
        XAxis xAxis= mChart.getXAxis();
        xAxis.setGranularity(1f);
        float start = 1f;
        Double[] Y9={amountbar1,amountbar2,amountbar3,amountbar4,amountbar5,amountbar6,amountbar7,amountbar8,amountbar9};
        ArrayList<BarEntry> yVals9 = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            double mult = (range);
            double val9 = (double) (Y9[i]);
            yVals9.add(new BarEntry(i+1, (float)(val9)));
        }
        BarDataSet set1;
        set1 = new BarDataSet(yVals9, "The year 2019");
        set1.setColors(ColorTemplate.MATERIAL_COLORS);
        int startColor1 = ContextCompat.getColor(this,
                android.R.color.holo_orange_light);
        int startColor2 = ContextCompat.getColor(this,
                android.R.color.holo_blue_light);
        int startColor3 = ContextCompat.getColor(this,
                android.R.color.holo_green_light);
        int startColor4 = ContextCompat.getColor(this,
                android.R.color.holo_red_light);
        int startColor5 = ContextCompat.getColor(this,
                android.R.color.holo_purple);
        int startColor6 = ContextCompat.getColor(this,
                android.R.color.holo_blue_bright);
        int startColor7 = ContextCompat.getColor(this,
                android.R.color.holo_blue_dark);
        int startColor8 = ContextCompat.getColor(this,
                android.R.color.holo_orange_dark);
        int startColor9 = ContextCompat.getColor(this,
                android.R.color.holo_green_dark);
        List<Integer> gradientColors = new ArrayList<>();
        gradientColors.add(0, startColor1);
        gradientColors.add(1, startColor2);
        gradientColors.add(2, startColor3);
        gradientColors.add(3, startColor4);
        gradientColors.add(4, startColor5);
        gradientColors.add(5, startColor6);
        gradientColors.add(6, startColor7);
        gradientColors.add(7, startColor8);
        gradientColors.add(8, startColor9);
        set1.setColors(gradientColors);
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        databar9 = new BarData(dataSets);
        databar9.setValueTextSize(15f);
        databar9.setBarWidth(0.5f);
    }
}
