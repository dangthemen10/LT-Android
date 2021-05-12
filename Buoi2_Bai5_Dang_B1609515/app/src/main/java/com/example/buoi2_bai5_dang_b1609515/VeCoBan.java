package com.example.buoi2_bai5_dang_b1609515;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class VeCoBan extends View{
    private final Paint paint = new Paint();
    public VeCoBan(Context context){super(context);}
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int xcanvas = canvas.getWidth(); //Lấy chiều ngang của màn hình.
        int ycanvas = canvas.getHeight(); // Lấy chiều dọc của màn hình.
        // cho canvas màu trắng
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        //Vẽ text "LẬP TRÌNH GIAO DIỆN MỨC THẤP"
        paint.setColor(Color.MAGENTA);
        paint.setTextSize(60);
        canvas.drawText("LẬP TRÌNH GIAO DIỆN MỨC THẤP", 60, 60, paint);
        // Hiển thị kích thước màn hình
        paint.setColor(Color.BLUE);
        paint.setTextSize(50);
        String Wcanvas = Integer.toString(xcanvas);
        canvas.drawText("Chiều rộng của màn hình ="+Wcanvas, 80,140,paint);
        String Hcanvas = Integer.toString(ycanvas);
        canvas.drawText("Chiều cao của màn hình = " + Hcanvas, 80, 220,paint);
        // Khai báo 1 hình chữ nhật để vẽ cung trong đó
        RectF rectF = new RectF(30, ycanvas/3-xcanvas/8, xcanvas/2-60, ycanvas/4+xcanvas/2-120);
        paint.setColor(Color.WHITE);
        canvas.drawOval(rectF,paint);//Hình Oval nằm trong hình chữ nhật chứa cung sắp vẽ
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF,-135,90,true,paint); // Vẽ cung
        //Vẽ circle
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawCircle(xcanvas/2+60, ycanvas/3, xcanvas/8, paint);
        //Vẽ line
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawLine(xcanvas/2+xcanvas/4, xcanvas/3, xcanvas-60, ycanvas/3+xcanvas/8, paint);
        //Vẽ hình chữ nhật đầy màu
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(20, ycanvas/4+350, canvas.getWidth()-20,canvas.getHeight()-20, paint);
        // Vẽ rotated text "Seahorse"
        paint.setColor(Color.RED);
        canvas.rotate(-45, xcanvas/4, ycanvas/4+450); // Quay canvas -45 độ
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(100);
        canvas.drawText("Seahorse", xcanvas/4, 3*ycanvas/4+200, paint);
        //canvas.restore();
        canvas.rotate(45, xcanvas/2, ycanvas/4+450); // Quay canvas trở lại (thay hàm restore)
        //Vẽ image
        Resources res = this.getResources();
        Bitmap bit = BitmapFactory.decodeResource(res,R.drawable.seahorse);
        float d=bit.getWidth(); //the width of the bitmap
        float xstar=xcanvas/8; //the coordinates of the left edge of the rectangle
        float ystar=3*ycanvas/4 ; //the coordinates of the top edge of the rectangle
        RectF rectF2 = new RectF(xstar,ystar, xstar+d,ystar+d); //defined rectangle
        canvas.drawBitmap(bit,null,rectF2,paint);
    }
}
