package com.mab.employeemysql;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by MonisBana on 3/4/2018.
 */

public class CustomAdapter extends CursorAdapter {
    Context context;
    Cursor cursor;
    LayoutInflater layoutInflater;
    public CustomAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        this.cursor = cursor;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView id = view.findViewById(R.id.idVal);
        id.setText(cursor.getString(0));
        TextView name = view.findViewById(R.id.nameVal);
        name.setText(cursor.getString(1));
        TextView dept = view.findViewById(R.id.deptVal);
        dept.setText(cursor.getString(2));
        Toast.makeText(context,cursor.getString(1) +"", Toast.LENGTH_SHORT).show();
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view =  layoutInflater.inflate(R.layout.row,parent,false);
        return view;
    }
}