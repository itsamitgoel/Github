package first.module7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 2015 on 10-Jul-16.
 */

public class SingleRowActivity2 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlerow2);

        TextView txtName10 = (TextView) findViewById(R.id.textView20);
        TextView txtName17 = (TextView) findViewById(R.id.textView21);
        TextView txtName11 = (TextView) findViewById(R.id.textView22);
        TextView txtName12 = (TextView) findViewById(R.id.textView23);
        TextView txtName13 = (TextView) findViewById(R.id.textView24);


        Button btnClose = (Button) findViewById(R.id.button2);

        Intent i = getIntent();
        // Displaying Received data
        txtName10.setText(i.getStringExtra("issue_name"));
        txtName17.setText(i.getStringExtra("issue_category"));
        txtName11.setText(i.getStringExtra("reported_by"));
        txtName12.setText(i.getStringExtra("reported_time"));
        txtName13.setText(i.getStringExtra("subscription_groupname"));



        // Binding Click event to Button
        btnClose.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Closing SecondScreen Activity
                finish();
            }
        });

    }
}


