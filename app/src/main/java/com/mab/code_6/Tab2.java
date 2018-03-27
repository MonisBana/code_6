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

public class Tab2 extends Fragment {
    String[] values=new String[]{"python", "c", "c++","Java", "Linux", "Windows"};
    ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab2,container,false);
        perform(v);
        return v;
    }
    public void perform(View v) {
        Bundle bundle =  getArguments();
        if(bundle != null){
            String Merchant_id = getArguments().getString("FarmerOtp");
            String Merchant_otp = getArguments().getString("MerchantOtp");
            String Destination = getArguments().getString("Destination");
        }
    }
}
