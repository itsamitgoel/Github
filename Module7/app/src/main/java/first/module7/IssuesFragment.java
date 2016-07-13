package first.module7;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 2015 on 07-Jul-16.
 */

public class IssuesFragment extends Fragment {

    private ProgressDialog pDialog;
    private DataAdapter2 adapter;
    private RecyclerView recyclerView2;

    // URL to get contacts JSON
    private static String url = "http://web-erigolabs.rhcloud.com/issues-list/android-internship";

    // JSON Node names
    private static final String TAG_issue_name = "issue_name";
    private static final String TAG_issue_category = "issue_category";
    private static final String TAG_reported_by = "reported_by";
    private static final String TAG_reported_time = "reported_time";
    private static final String TAG_subscription_groupname = "subscription_groupname";

    ArrayList<HashMap<String, String>> dataList2 = new ArrayList<HashMap<String, String>>();
    public IssuesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new GetContacts().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_issues, container, false);
    }


    /**
     * Async task class to get json by making HTTP call
     * */
    class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(getActivity());
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

                        String name = c.getString(TAG_issue_name);
                        String category = c.getString(TAG_issue_category);
                        String by = c.getString(TAG_reported_by);
                        String time = c.getString(TAG_reported_time);
                        String groupname = c.getString(TAG_subscription_groupname);



                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put(TAG_issue_name, name);
                        contact.put(TAG_issue_category, category);
                        contact.put(TAG_reported_by, by);
                        contact.put(TAG_reported_time, time);
                        contact.put(TAG_subscription_groupname,groupname);


                        // adding contact to contact list
                        dataList2.add(contact);
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
            recyclerView2 = (RecyclerView) getActivity().findViewById(R.id.recycler_view2);
            adapter = new DataAdapter2(getActivity(), dataList2);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            recyclerView2.setLayoutManager(mLayoutManager);
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
            recyclerView2.setAdapter(adapter);



        }

    }

}






