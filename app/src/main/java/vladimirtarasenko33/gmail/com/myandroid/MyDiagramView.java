package vladimirtarasenko33.gmail.com.myandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyDiagramView extends View {

    Paint paint1 =new Paint();
    Paint paint3 =new Paint();
    Paint paint4 =new Paint();

    public MyDiagramView(Context context) {
        super(context);
        init();
    }

    public MyDiagramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyDiagramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyDiagramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init() {

        paint1.setColor(Color.GREEN);
        paint3.setColor(Color.BLUE);
        paint4.setColor(Color.RED);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float arr[] = {5, 5, 10};
        Paint paints[]={paint1, paint3, paint4};
        float startAngel=0;
        float sweepAngel=0;
        for (int i = 0; i < arr.length; i++) {
            sweepAngel =arr[i]/(arr[0]+arr[1]+arr[2])*360;
            canvas.drawArc(getWidth() / 2 - 200, getHeight() / 2, getWidth() / 2 + 200, getHeight() / 2 + 400, startAngel, sweepAngel, true, paints[i]);
            startAngel=startAngel+sweepAngel;
        }
    }
}
