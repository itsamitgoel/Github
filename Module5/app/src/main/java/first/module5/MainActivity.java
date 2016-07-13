package first.module5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog pDialog;

    // URL to get contacts JSON
    private static String url = "http://web-erigolabs.rhcloud.com/groups-list/android-internship";

    // JSON Node names
    private static final String TAG_subscription_groupid = "subscription_groupid";
    private static final String TAG_subscription_groupname = "subscription_groupname";
    private static final String TAG_subscription_groupdesc ="subscription_groupdesc";
    private static final String TAG_subscription_groupcreationdate ="subscription_groupcreationdate";
    private static final String TAG_subscription_groupowner ="subscription_groupowner";
    private static final String TAG_is_public = "is_public";
    private static final String TAG_is_approved = "is_approved";
    private static final String TAG_is_subscribed = "is_subscribed";

    // contacts JSONArray

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactList = new ArrayList<HashMap<String, String>>();
       lv = (ListView)findViewById(R.id.listView);
        // Calling async task to get json
        new GetContacts().execute();




        // Listview on item click listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem
                Intent nextScreen = new Intent(getApplicationContext(), SingleRowActivity.class);
                HashMap<String,String> map1 =(HashMap<String,String>)lv.getItemAtPosition(position);
                String value1 = map1.get(TAG_subscription_groupid);
                String value2= map1.get(TAG_subscription_groupname);
                String value3 = map1.get(TAG_subscription_groupdesc);
                String value4 = map1.get(TAG_subscription_groupcreationdate);
                String value5 = map1.get(TAG_subscription_groupowner);
                String value6 = map1.get(TAG_is_public);
                String value7 = map1.get(TAG_is_approved);
                String value8 = map1.get(TAG_is_subscribed);


                //Sending data to another Activity
                nextScreen.putExtra(TAG_subscription_groupid,value1);
                nextScreen.putExtra(TAG_subscription_groupname,value2);
                nextScreen.putExtra(TAG_subscription_groupdesc,value3);
                nextScreen.putExtra(TAG_subscription_groupcreationdate,value4);
                nextScreen.putExtra(TAG_subscription_groupowner,value5);
                nextScreen.putExtra(TAG_is_public,value6);
                nextScreen.putExtra(TAG_is_approved,value7);
                nextScreen.putExtra(TAG_is_subscribed,value8);



                startActivity(nextScreen);
            }
        });

    }

    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONArray contacts = new JSONArray(jsonStr);


                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id = c.getString(TAG_subscription_groupid);
                        String name = c.getString(TAG_subscription_groupname);
                        String desc = c.getString(TAG_subscription_groupdesc);
                        String creationdate = c.getString(TAG_subscription_groupcreationdate);
                        String owner = c.getString(TAG_subscription_groupowner);
                        String publi = c.getString(TAG_is_public);
                        String approved = c.getString(TAG_is_approved);
                        String subscribed= c.getString(TAG_is_subscribed);


                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put(TAG_subscription_groupid, id);
                        contact.put(TAG_subscription_groupname, name);
                        contact.put(TAG_subscription_groupdesc, desc);
                        contact.put(TAG_subscription_groupcreationdate, creationdate);
                        contact.put(TAG_subscription_groupowner, owner);
                        contact.put(TAG_is_public, publi);
                        contact.put(TAG_is_approved, approved);
                        contact.put(TAG_is_subscribed, subscribed);


                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,contactList, R.layout.list_item,new String[] {
                    TAG_subscription_groupid,TAG_subscription_groupname,TAG_subscription_groupowner},new int[] {R.id.textView
            ,R.id.textView2,R.id.textView3}
             );

            lv.setAdapter(adapter);
        }

    }

}
