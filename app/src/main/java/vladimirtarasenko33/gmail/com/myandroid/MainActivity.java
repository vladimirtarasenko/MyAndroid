package vladimirtarasenko33.gmail.com.myandroid;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView textView1 = (TextView) findViewById(R.id.textView2);
        View button1 =  findViewById(R.id.textView2);
        button1.setOnClickListener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = (String) textView.getText();
                textView.setText(textView1.getText());
                textView1.setText(text);
                ColorStateList color = textView.getTextColors();
                textView.setTextColor(textView1.getTextColors());
                textView1.setTextColor(color);
            }
        });
    }

    @Override
    public void onClick(View v) {
        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView textView1 = (TextView) findViewById(R.id.textView2);
        View button1 =  findViewById(R.id.textView2);
        String text = (String) textView.getText();
        textView.setText(textView1.getText());
        textView1.setText(text);
        ColorStateList color = textView.getTextColors();
        textView.setTextColor(textView1.getTextColors());
        textView1.setTextColor(color);
    }

    public void onMyClick(View view) {
        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView textView1 = (TextView) findViewById(R.id.textView2);
        String text = (String) textView.getText();
        textView.setText(textView1.getText());
        textView1.setText(text);
        ColorStateList color = textView.getTextColors();
        textView.setTextColor(textView1.getTextColors());
        textView1.setTextColor(color);
    }
}
