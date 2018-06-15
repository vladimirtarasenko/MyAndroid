package vladimirtarasenko33.gmail.com.myandroid;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            }

    public void OnClickDz1(View view) {
        Intent intent=new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    public void OnClickDz2(View view) {
        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(intent);
    }
}
