package com.example.myapplication1;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class MyView extends View {
    public MyView(Context context){
     super(context);
    }
    @Override
        protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(); //создаём объект класса Paint
        paint.setColor(Color.BLUE); //цвет линии
        paint.setStrokeWidth(5); //толщина линии
        int x=0,y = 0;
        while (y<2*canvas.getHeight()||x<2*canvas.getWidth()){
            canvas.drawLine(0, y,x, 0, paint); //рисуем линию
            x=x+100;
            y=y+100;
        }

        /*paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300, 300, 200, paint);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(300, 300, 200, paint);*/

        /*paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(600, 100, 1000, 400, paint);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(600, 100, 1000, 400, paint);*/
    }
}
