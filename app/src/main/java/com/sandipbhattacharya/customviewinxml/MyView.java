package com.sandipbhattacharya.customviewinxml;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    Bitmap bird[] = new Bitmap[15];
    long UPDATE_MILLIS = 30;
    Handler handler;
    Runnable runnable;
    int birdFrame = 0;
    int dWidth, dHeight;
    int birdWidth, birdHeight;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = size.y;
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        bird[0] = BitmapFactory.decodeResource(getResources(), R.drawable.bird_frame1);
        bird[1] = BitmapFactory.decodeResource(getResources(), R.drawable.bird_frame2);
        bird[2] = BitmapFactory.decodeResource(getResources(), R.drawable.bird_frame3);
        bird[3] = BitmapFactory.decodeResource(getResources(), R.drawable.bird_frame4);
        bird[4] = BitmapFactory.decodeResource(getResources(), R.drawable.bird_frame5);
        bird[5] = BitmapFactory.decodeResource(getResources(), R.drawable.bird_frame6);
        bird[6] = BitmapFactory.decodeResource(getResources(), R.drawable.bird_frame7);
        bird[7] = BitmapFactory.decodeResource(getResources(), R.drawable.bird_frame8);
        birdWidth = bird[0].getWidth();
        birdHeight = bird[0].getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        birdFrame++;
        if(birdFrame == 8)
            birdFrame = 0;
        canvas.drawBitmap(bird[birdFrame], (dWidth / 2 - birdWidth / 2), (dHeight/2 - birdHeight/2), null);
        handler.postDelayed(runnable, UPDATE_MILLIS);
    }
}
