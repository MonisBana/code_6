package com.mab.code_6;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Monis Bana on 12/15/2017.
 */

public class Tab1 extends Fragment {
    String[] values=new String[]{"India", "java", "c++","Ad.Java", "Linux", "Unix"};
    ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View  v = inflater.inflate(R.layout.tab1,container,false);
        perform(v);
        return v;
    }
    public void perform(View v) {
        lv = (ListView) v.findViewById(R.id.farmerList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(TabActivity.mBuyListener);
    }
}
