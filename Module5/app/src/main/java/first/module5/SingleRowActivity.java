package first.module5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 2015 on 30-Jun-16.
 */

public class SingleRowActivity  extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlerow);

        TextView txtName10 = (TextView) findViewById(R.id.textView10);
        TextView txtName17 = (TextView) findViewById(R.id.textView17);
        TextView txtName11 = (TextView) findViewById(R.id.textView11);
        TextView txtName12 = (TextView) findViewById(R.id.textView12);
        TextView txtName13 = (TextView) findViewById(R.id.textView13);
        TextView txtName14 = (TextView) findViewById(R.id.textView14);
        TextView txtName15 = (TextView) findViewById(R.id.textView15);
        TextView txtName16 = (TextView) findViewById(R.id.textView16);

        Button btnClose = (Button) findViewById(R.id.button);

        Intent i = getIntent();
        // Receiving the Data
        String name = i.getStringExtra("name");


        // Displaying Received data
        txtName10.setText(i.getStringExtra("subscription_groupid"));
        txtName17.setText(i.getStringExtra("subscription_groupname"));
        txtName11.setText(i.getStringExtra("subscription_groupdesc"));
        txtName12.setText(i.getStringExtra("subscription_groupcreationdate"));
        txtName13.setText(i.getStringExtra("subscription_groupowner"));
        txtName14.setText(i.getStringExtra("is_public"));
        txtName15.setText(i.getStringExtra("is_approved"));
        txtName16.setText(i.getStringExtra("is_subscribed"));



        // Binding Click event to Button
        btnClose.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Closing SecondScreen Activity
                finish();
            }
        });

    }
}
