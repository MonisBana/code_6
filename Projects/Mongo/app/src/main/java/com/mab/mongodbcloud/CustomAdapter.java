package com.mab.mongodbcloud;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mab.mongodbcloud.Class.User;

import java.util.List;

/**
 * Created by MonisBana on 3/2/2018.
 */

public class CustomAdapter extends BaseAdapter{
    private Context mContext;
    private List<User> lstUsers;

    public CustomAdapter(Context mContext, List<User> lstUsers) {
        this.mContext = mContext;
        this.lstUsers = lstUsers;
    }

    @Override
    public int getCount() {
        return lstUsers.size();
    }

    @Override
    public Object getItem(int i) {
        return lstUsers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.row,null);
        TextView txtUser = view.findViewById(R.id.txtUser);
        txtUser.setText(lstUsers.get(i).getUser());
        return view;
    }
}
