package first.module2;

/**
 * Created by 2015 on 18-Jun-16.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import first.module2.utils.SharedPreference;

public class Secondactivity extends Activity {

    private  String text;
    private SharedPreference sharedPreference;
    Activity context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        sharedPreference = new SharedPreference();


        final TextView  txt = (TextView) findViewById(R.id.textView3);
        Button btnClose = (Button) findViewById(R.id.button2);

        Intent i = getIntent();
        // Receiving the Data
            text = i.getStringExtra("text");
        Log.e("Second Activity", text);
        // Displaying Received data
        txt.setText(text);
        // Binding Click event to Button
        btnClose.setOnClickListener(new View.OnClickListener() {

            public  void onClick(View arg0) {
                text = txt.getText().toString();

                // Save the text in SharedPreference
                sharedPreference.save(context, text);
                Toast.makeText(context,text+" is saved in Shared Reference",
                        Toast.LENGTH_LONG).show();
                //Closing SecondScreen Activity
                finish();
            }
        });

    }
}



