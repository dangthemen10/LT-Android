package com.example.homework2_dang_b1609515;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
public class ArbitraryDraw extends View{
    private Paint paint = new Paint();
    private Path path = new Path();
    public ArbitraryDraw (Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setAntiAlias(true); // Khử răng cưa, làm “trơn” đường vẽ.
        paint.setStrokeWidth(20); // Đặt bề rộng của nét vẽ.
        paint.setColor(Color.RED); // Đặt màu cho nét vẽ là màu đen.
        paint.setStyle(Paint.Style.STROKE); // Đặt kiểu nét vẽ (STROKE: nét đơn, FILL: vẽ và tô đầy màu các bên trong các đoạn cong).
        paint.setStrokeJoin(Paint.Join.ROUND); // Đặt kiểu điểm nối (BEVEL: đoạn thẳng, MITER: góc nhọn, ROUND: tròn).
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint); // Khai báo đối tượng chứa nét vẽ là một đường.
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
// Lấy toạ độ điểm chạm của ngón tay.
        float eventX = event.getX();
        float eventY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY); // Di chuyển đến toạ độ của điểm chạm ngón tay.
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY); // Vẽ đường sợ tóc đến toạ độ của điểm chạm ngón tay.
                break;
            case MotionEvent.ACTION_UP:
                // Không làm gì cả.
                break;
            default:
                return false;
        }
        invalidate(); // Vẽ lại liên tục.
        return true;
    }
}
