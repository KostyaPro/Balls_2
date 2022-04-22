package com.example.myapplication1;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class MyView extends View {
    int N = 10; // количество шариков
    float[] x = new float[N];
    float[] y = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];

    public MyView(Context context) {
        super(context);

    }
boolean started=false;
    @Override
        protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(); //создаём объект класса Paint
        // отрисовываем все шарики
        if(!started) {
            for (int i = 0; i < N; i++) {
                x[i] = (float) (Math.random() * canvas.getWidth());
                y[i] = (float) (Math.random() * canvas.getHeight());
                vx[i] = (float) (Math.random() * 6 - 3);
                vy[i] = (float) (Math.random() * 6 - 3);
            }
            started=true;
        }
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 20, paint);
        }
        // готовим массивы x и у для следущего кадра
        for (int i = 0; i < N; i++) {
            x[i] =x[i]+ vx[i];
            if(x[i]<0||x[i]>canvas.getWidth()){
                x[i]=-x[i];
            vx[i]=-vx[i];
            }
            y[i] =y[i]+ vy[i];
            if(y[i]<0||y[i]>canvas.getHeight()){
                y[i]=-y[i];
                vy[i]=-vy[i];
            }
        }
        //запрашиваем перерисовку
        invalidate();

    }
}
