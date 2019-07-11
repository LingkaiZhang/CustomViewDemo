package com.lingkai.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


/**
 * description ： 可以再屏幕拖动的圆
 * author : lingkai
 * date : 2019/7/11 11:34
 */
public class DragCricleView extends View {
    private int mLastX;
    private int mLastY;

    private String TAG = getClass().getName();

    public DragCricleView(Context context) {
        super(context);
    }

    public DragCricleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragCricleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(40);
        canvas.drawCircle(100, 100, 60, paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltax = x - mLastX;
                int deltay = y - mLastY;
                Log.d(TAG, "move， deltaX:" + deltax + " deltaY: " + deltay);
                //scrollBy(-deltax, -deltay);
                setTranslationX(getX() + (event.getX() - deltax));
                setTranslationY(getY() + (event.getY() - deltay));
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }

        mLastX = x;
        mLastY = y;

        return true;
    }
}
