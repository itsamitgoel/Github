package first.modulesfour;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.database.sqlite.SQLiteDatabase;

import static android.R.attr.id;
import static first.modulesfour.R.id.listView;

public class MainActivity extends ActionBarActivity {
    private static ListView list_view;
    private static String[] NAMES = new String[]{"john","peter","mark"};
    private static int[] icons= new int[] {R.drawable.img1,R.drawable.img2,R.drawable.img3};
     Button btn;
    int len;
    DatabaseHelper myDb;
    StringBuffer buffer = new StringBuffer();
    String[] strArrContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb= new DatabaseHelper(this);

        click();
        viewAll();
        listView();




    }
    public void listView()
    {

        Name name_data[] =new Name[len];
        for(int i=0;i<len;i++)
        {
            name_data[i] =new Name(icons[i%3],strArrContent[i]);
        }
        list_view=(ListView)findViewById(R.id.listView);
        NameAdapter adapter = new NameAdapter(this,
                R.layout.layout_singlerow, name_data);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Name name1 = (Name) (list_view.getItemAtPosition(i));

                        String title1 = name1.title;
                       String icon1 = Integer.toString(name1.icon);

                        Intent nextScreen = new Intent(getApplicationContext(), SingleListActivity.class);

                        //Sending data to another Activity
                        nextScreen.putExtra("name",title1);
                        nextScreen.putExtra("imagepath",icon1);

                        startActivity(nextScreen);

                    }
                }
        );


                    }
    public void click()
    {
        btn=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent nextScreen1 = new Intent(getApplicationContext(),AddButtonActivity.class);
                        startActivity(nextScreen1);


                    }
                }
        );
    }
    public void viewAll()
    {

        Intent i = getIntent();
        Cursor res = myDb.getAllData();
         while(res.moveToNext())
         {
             buffer.append( res.getString(1) +"&" );

         }
       String strstr = buffer.toString();
        strArrContent = strstr.split("&");
        len=strArrContent.length;

    }
    @Override
    public void onBackPressed()
    {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }


    }


