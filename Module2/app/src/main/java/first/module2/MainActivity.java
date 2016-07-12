package first.module2;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    EditText inputtext;
    Button btn;
    Activity context = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         inputtext = (EditText)findViewById(R.id.editText);
         btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener()
        {

            public  void onClick(View arg0) {
                if(inputtext.getText().toString().equals("")) {
                    Toast.makeText(context, " Please enter some text",
                            Toast.LENGTH_LONG).show();
                }else{
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(),Secondactivity.class);

                //Sending data to another Activity
                nextScreen.putExtra("text", inputtext.getText().toString());

                Log.e("n", inputtext.getText().toString());

                startActivity(nextScreen);

            }}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
