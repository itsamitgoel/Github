package first.module3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 2015 on 26-Jun-16.
 */

public class SecondActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen2);

        TextView txtName = (TextView) findViewById(R.id.textView);

        Button btnClose = (Button) findViewById(R.id.button7);

        Intent i = getIntent();
        // Receiving the Data
        String name = i.getStringExtra("result");

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
