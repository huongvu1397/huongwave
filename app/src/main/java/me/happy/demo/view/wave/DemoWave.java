package me.happy.demo.view.wave;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DemoWave extends View {
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    int x = getHeight() / 2;
    int i = 0;
    int k =getHeight() / 2;
    //graph point
    int[] a = {20, 50, 40, 65, 56, 43, 22, 23, 55, 77, 76,
            25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 150,
            150, 150, 150, 150, 150, 150, 20, 20, 20, 20, 20,
            20, 20, 150, 52, 52, 52, 52, 52, 52, 52, 52, 52,
            52, 52, 52, 52, 52, 52, 30, 30, 30, 30, 30, 30,
            30, 30, 30, 30, 30, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 22, 22, 22, 22, 50, 50, 50};

    public DemoWave(Context context) {
        super(context);
        init();
    }

    public DemoWave(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DemoWave(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init() {
        paint.setColor(Color.GREEN);
        paint1.setColor(Color.RED);
    }

    @Override
    public synchronized void onDraw(final Canvas canvas) {

        int n = 35;
        int j = 1;

        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);

        if (i != 0) {

            for (j = 1; j <= i; j++) {

                if (n > getWidth() - 25) {
                    n = 36;
                    k = n;
                    //drawPulseIterator=k;
                } else {

                    n += 1;

                }

                canvas.drawRect(k++, 0, n + 5, getHeight(), paint);
                canvas.drawLine(n, (getHeight() / 2) - a[j], n + 1, (getHeight() / 2) - a[j - 1], paint1);
            }
        }

        i++;
        if (j == a.length) {
            i = 0;
        }

        invalidate();

    }

}