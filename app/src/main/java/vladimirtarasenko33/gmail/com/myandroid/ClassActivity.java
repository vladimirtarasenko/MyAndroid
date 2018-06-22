package vladimirtarasenko33.gmail.com.myandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class ClassActivity extends Activity{
    View clock;
    View diagram;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

// clock=findViewById(R.id.clock);
//diagram=findViewById(R.id.diagram);
    }
}
