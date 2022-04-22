package com.example.myapplication1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyDraw extends View {

    int N = 50; // количество шариков
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    public MyDraw(Context context) {
        super(context);
        fillRandom(x, 0, 500);
        fillRandom(y, 0, 500);
        fillRandom(vx, -3, 3);
        fillRandom(vy, -3,3);
    }
    float rand(float min , float max){
        return (float)(Math.random() * (max - min + 1)) + min;
    }

    void fillRandom(float[] array , float min, float max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }
    Paint paint = new Paint();

    void add(float[] array , float[] values){
        for (int i = 0; i < array.length; i++){
            array[i] += values[i];
        }
    }
    void DrawBalls(Canvas canvas){
        for (int i = 0; i < N; i++)
            canvas.drawCircle(x[i], y[i], 20, paint);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        // отрисовываем все шарики
       DrawBalls(canvas);
        // готовим массивы x и у для следущего кадра
        add(x, vx);
        add(y, vy);
        // Запрос на перерисовку экрана
        invalidate();
    }
}
