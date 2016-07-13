package first.module4name;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name name_data[] = new Name[]
                {
                        new Name(R.drawable.img1, "Peter"),
                        new Name(R.drawable.img2, "Bill"),
                        new Name(R.drawable.img3, "Gary"),
                };

        NameAdapter adapter = new NameAdapter(this,
                R.layout.listview_item_row, name_data);


        listView1 = (ListView) findViewById(R.id.listView1);


        listView1.setAdapter(adapter);
    }
}