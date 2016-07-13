package first.modulesfour;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 2015 on 27-Jun-16.
 */

public class SingleListActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlelist);

        TextView txtName = (TextView) findViewById(R.id.textView);
        ImageView imgview = (ImageView)findViewById(R.id.imageView);
        Button btnClose = (Button) findViewById(R.id.button);

        Intent i = getIntent();
        // Receiving the Data
        String name = i.getStringExtra("name");
        String path =i.getStringExtra("imagepath");
        if(path.isEmpty())
            return;
        imgview.setImageResource(Integer.parseInt(path));


        // Displaying Received data
        txtName.setText(name);

        // Binding Click event to Button
        btnClose.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Closing SecondScreen Activity
                finish();
            }
        });

    }
}