package vladimirtarasenko33.gmail.com.myandroid;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ThirdActivity extends Activity {

    ImageView imageView;
    EditText newURL;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
       imageView =(ImageView) findViewById(R.id.imageView);
        newURL=findViewById(R.id.edit);
    }

    public void ImageClick(View view) {
       Picasso.get().load(String.valueOf(newURL.getText())).into(imageView);
    }
}
