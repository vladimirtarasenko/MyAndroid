package vladimirtarasenko33.gmail.com.myandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class SecondActivity extends Activity {

    public static final int BUTTON_ONE_KEY =1;
    public static final int BUTTON_TWO_KEY =2;
    public static final String BUTTON_KEY_NAME ="Button_key_Name";

    public static void show(Activity activity, int key){
        Intent intent =new Intent(activity, SecondActivity.class);
        intent.putExtra(BUTTON_KEY_NAME, key);
        activity.startActivity(intent);
    }

    // ще один метод запуска новой Активитию
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

int buttonKey =getIntent().getIntExtra(BUTTON_KEY_NAME,0);

if(buttonKey==BUTTON_ONE_KEY){
    Toast.makeText(this, " Button 1 ", Toast.LENGTH_SHORT).show();
} else {
    Toast.makeText(this, " Button 2 ", Toast.LENGTH_SHORT).show();
}
    }
}
