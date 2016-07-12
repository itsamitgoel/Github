package first.module3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements  View.OnClickListener {
    EditText input1,input2;
    Button btn1,btn2,btn3,btn4;
    float res=0;
    String oper ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 = (EditText) findViewById(R.id.editText4);
        input2 = (EditText) findViewById(R.id.editText3);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);


    }
                    @Override
                    public void onClick(View v) {
                        float num1=0;
                        float num2=0;
                        if(TextUtils.isEmpty(input1.getText().toString()) || TextUtils.isEmpty(input2.getText().toString())) {
                            return;
                        }
                        num1 =Float.parseFloat(input1.getText().toString());
                        num2 =Float.parseFloat(input2.getText().toString());
                     switch(v.getId()) {
                         case R.id.button:
                             oper = "+";
                             res = num1 + num2;
                             Toast.makeText(MainActivity.this, " + operator is used", Toast.LENGTH_LONG).show();
                             break;
                         case R.id.button2:
                             oper = "-";
                             res = num1 - num2;
                             Toast.makeText(MainActivity.this, " - operator is used", Toast.LENGTH_LONG).show();
                             break;
                         case R.id.button3:
                             oper = "*";
                             res = num1 * num2;
                             Toast.makeText(MainActivity.this, " * operator is used", Toast.LENGTH_LONG).show();
                             break;
                         case R.id.button4:
                             oper = "/";
                             res = num1 / num2;
                             Toast.makeText(MainActivity.this, " / operator is used", Toast.LENGTH_LONG).show();
                             break;
                         default:
                             break;
                     }
                        //Starting a new Intent
                        Intent nextScreen = new Intent(getApplicationContext(), SecondActivity.class);

                        //Sending data to another Activity
                        nextScreen.putExtra("result", Float.toString(res));




                        startActivity(nextScreen);





                    }

}
