package vladimirtarasenko33.gmail.com.myandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyView extends View {
    RectF rectF = new RectF();
    Paint paint = new Paint();
    Paint paint1 = new Paint();
    Paint paint2 = new Paint();
    Paint paint3 = new Paint();
    Paint paint4 = new Paint();


    int hours = Integer.valueOf(new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()));
    int minutes = Integer.valueOf(new SimpleDateFormat("mm").format(Calendar.getInstance().getTime()));

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init() {
        paint.setColor(Color.BLACK);
        paint1.setColor(Color.GREEN);
        paint2.setColor(Color.BLACK);
        paint3.setColor(Color.BLUE);
        paint4.setColor(Color.RED);
        paint.setAntiAlias(true);
    }

    /**
     * @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) { // метод вызывается при изменении экрана
     * super.onSizeChanged(w, h, oldw, oldh);
     * <p>
     * // rectF.left=getWidth()*0.05f;
     * // rectF.top=getHeight()*0.25f;
     * // rectF.right=getWidth()-rectF.left;
     * // rectF.bottom=getHeight()-rectF.top;
     * }
     **/
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);      // рисуем все на экране
        paint.setColor(Color.BLACK);
        paint1.setColor(Color.GREEN);
        paint2.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint2.setStrokeWidth(15);

        canvas.drawCircle(getWidth() / 2, getHeight() / 4, 200, paint1);//рисуем круг
        for (int i = 1; i < 13; i++) {
            canvas.drawLine(getWidth() / 2, getHeight() / 4 + 150, getWidth() / 2, getHeight() / 4 + 200, paint); // рисуем линию
            canvas.save();
            canvas.rotate(30 * i, getWidth() / 2, getHeight() / 4);
            canvas.drawLine(getWidth() / 2, getHeight() / 4 + 150, getWidth() / 2, getHeight() / 4 + 200, paint);
            canvas.restore();
        }
        canvas.save();
        canvas.rotate(30 * hours, getWidth() / 2, getHeight() / 4);
        canvas.drawLine(getWidth() / 2, getHeight() / 4, getWidth() / 2, getHeight() / 4 - 90, paint2);
        canvas.rotate(720 - 30 * hours, getWidth() / 2, getHeight() / 4);
        canvas.restore();
        canvas.save();
        canvas.rotate(6 * minutes, getWidth() / 2, getHeight() / 4);
        canvas.drawLine(getWidth() / 2, getHeight() / 4, getWidth() / 2, getHeight() / 4 - 120, paint2);
        canvas.rotate(360 - 6 * minutes, getWidth() / 2, getHeight() / 4);
        canvas.restore();
        paint.setTextSize(30);
        canvas.drawText("12", getWidth() / 2, getHeight() / 4 - 220, paint);
        canvas.drawText("3", getWidth() / 2 + 220, getHeight() / 4, paint);
        canvas.drawText("6", getWidth() / 2, getHeight() / 4 + 220, paint);
        canvas.drawText("9", getWidth() / 2 - 220, getHeight() / 4, paint);

    }
}
