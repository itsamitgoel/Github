package first.modulesfour;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 2015 on 27-Jun-16.
 */

public class AddButtonActivity extends MainActivity {
    Button btnadd,btnclose;
    EditText txtName;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbutton);

         txtName = (EditText) findViewById(R.id.editText);
         btnadd = (Button) findViewById(R.id.button3);
        btnclose= (Button) findViewById(R.id.button4);

        Intent i = getIntent();

        AddData();
        // Binding Click event to Button
        btnclose.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent nextScreen1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(nextScreen1);
                //Closing SecondScreen Activity
                finish();
            }
        });

    }
    public void AddData()
    {

        btnadd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(TextUtils.isEmpty(txtName.getText().toString()))
                        {
                           return;
                        }

                      boolean isInserted=  myDb.insertData(txtName.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(AddButtonActivity.this,"DATA INSERTED",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddButtonActivity.this,"DATA  NOT INSERTED",Toast.LENGTH_LONG).show();

                }
                } );
    }
    @Override
    public void onBackPressed()
    {

  finish();
    }


}
