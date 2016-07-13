package first.module7;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 2015 on 08-Jul-16.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder>
{

     private Context mContext;
    ArrayList<HashMap<String, String>> dataList;





    // JSON Node names
    private static final String TAG_subscription_groupid = "subscription_groupid";
    private static final String TAG_subscription_groupname = "subscription_groupname";
    private static final String TAG_subscription_groupdesc ="subscription_groupdesc";
    private static final String TAG_subscription_groupcreationdate ="subscription_groupcreationdate";
    private static final String TAG_subscription_groupowner ="subscription_groupowner";
    private static final String TAG_is_public = "is_public";
    private static final String TAG_is_approved = "is_approved";
    private static final String TAG_is_subscribed = "is_subscribed";


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView id1,name,owner;


        public MyViewHolder(View view) {
            super(view);
            id1 = (TextView) view.findViewById(R.id.id1);
            name = (TextView) view.findViewById(R.id.name);
            owner = (TextView) view.findViewById(R.id.owner);

        }


    }


    public DataAdapter(Context mContext,  ArrayList<HashMap<String, String>> dataList) {

        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_groups, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final HashMap<String, String> map1 = (HashMap<String, String>) dataList.get(position);
        final String value1 = map1.get(TAG_subscription_groupid);
        final String value2 = map1.get(TAG_subscription_groupname);
        final String value5 = map1.get(TAG_subscription_groupowner);
        holder.id1.setText(value1);
        holder.name.setText(value2);
        holder.owner.setText(value5);
        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
             Intent nextScreen = new Intent(mContext,SingleRowActivity.class);
                String value1 = map1.get(TAG_subscription_groupid);
                String value2 = map1.get(TAG_subscription_groupname);
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


                v.getContext().startActivity(nextScreen);
            }
        });




    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }



}
