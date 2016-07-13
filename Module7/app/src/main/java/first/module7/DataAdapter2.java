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
public class DataAdapter2 extends RecyclerView.Adapter<DataAdapter2.MyViewHolder>
{

    private Context mContext;
    ArrayList<HashMap<String, String>> dataList2;





    // JSON Node names
    private static final String TAG_issue_name = "issue_name";
    private static final String TAG_issue_category = "issue_category";
    private static final String TAG_reported_by = "reported_by";
    private static final String TAG_reported_time = "reported_time";
    private static final String TAG_subscription_groupname = "subscription_groupname";


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView by,groupname;


        public MyViewHolder(View view) {
            super(view);
            by = (TextView) view.findViewById(R.id.by);
            groupname = (TextView) view.findViewById(R.id.groupname);

        }


    }


    public DataAdapter2(Context mContext,  ArrayList<HashMap<String, String>> dataList2) {

        this.mContext = mContext;
        this.dataList2 = dataList2;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_issues, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final HashMap<String, String> map1 = (HashMap<String, String>) dataList2.get(position);
        final String value1 = map1.get(TAG_reported_by);
        final String value5 = map1.get(TAG_subscription_groupname);;
        holder.by.setText(value1);
        holder.groupname.setText(value5);

        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(mContext,SingleRowActivity2.class);
                String value1 = map1.get(TAG_issue_name);
                String value2 = map1.get(TAG_issue_category);
                String value3 = map1.get(TAG_reported_by);
                String value4 = map1.get(TAG_reported_time);
                String value5 = map1.get(TAG_subscription_groupname);

                //Sending data to another Activity
                nextScreen.putExtra(TAG_issue_name,value1);
                nextScreen.putExtra(TAG_issue_category,value2);
                nextScreen.putExtra(TAG_reported_by,value3);
                nextScreen.putExtra(TAG_reported_time,value4);
                nextScreen.putExtra(TAG_subscription_groupname,value5);


                v.getContext().startActivity(nextScreen);
            }
        });




    }
    @Override
    public int getItemCount() {
        return dataList2.size();
    }



}
