package first.module4name;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 2015 on 03-Jul-16.
 */

class NameAdapter extends ArrayAdapter<Name> {

    Context context;
    int layoutResourceId;
    Name data[] = null;

    public NameAdapter(Context context, int layoutResourceId, Name[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        NameHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new NameHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);

            row.setTag(holder);
        }
        else
        {
            holder = (NameHolder)row.getTag();
        }

        Name name = data[position];
        holder.txtTitle.setText(name.title);
        holder.imgIcon.setImageResource(name.icon);

        return row;
    }

    static class NameHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
}
