package com.mab.code_6;


import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mab.code_6.Service.APIService;
import com.mab.code_6.models.FarmerDetails;
import com.mab.code_6.models.OrderDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Monis Bana on 12/15/2017.
 */

public class Tab1 extends Fragment {
    TextView FarmerName,Address,District,State,Contact;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View  v = inflater.inflate(R.layout.tab1,container,false);
        Bundle bundle = getArguments();
        /*String Farmer_otp = bundle.getString("MerchantId");
        String Origin = bundle.getString("Origin");
        Log.d("Hii","Horaha hai");*/
        perform(v);
        return v;
    }
    public void perform(View v) {
        String Farmer_id = "5aac1483aaf3a919a4de8251";
        FarmerName = v.findViewById(R.id.farmerNameVal);
        Address = v.findViewById(R.id.farmerAddressVal);
        District = v.findViewById(R.id.farmerDistrictVal);
        State = v.findViewById(R.id.farmerStateVal);
        Contact = v.findViewById(R.id.farmerContactVal);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.42.20:8000/truck/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        APIService mAPIService = retrofit.create(APIService.class);
        Call<FarmerDetails> call  = mAPIService.getUser(Farmer_id);
        call.enqueue(new Callback<FarmerDetails>() {
            @Override
            public void onResponse(Call<FarmerDetails> call, Response<FarmerDetails> response) {
               /* FarmerName.setText(response.body().getName());
                Address.setText(response.body().getAddr());
                District.setText(response.body().getDistrict());
                State.setText(response.body().getState());
                Contact.setText(response.body().getMobile());*/
            }

            @Override
            public void onFailure(Call<FarmerDetails> call, Throwable t) {

            }
        });
    }
}
