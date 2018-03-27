package com.mab.code_6;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mab.code_6.Service.APIService;
import com.mab.code_6.models.FarmerDetails;
import com.mab.code_6.models.OrderDetails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.mab.code_6.R.id.action_add;
import static com.mab.code_6.R.menu.main_menu;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "hii";
    Set<String> order_id;
    private RecyclerView.Adapter adapter;
    private RecyclerView mOrderList;
    ArrayList<OrderDetails> orderDetailsList = new ArrayList<>();
    OrderDetails orderDetails;
    int i=1;
    static View.OnClickListener myOnClickListener;
    ArrayList<String> origin = new ArrayList<String>();
    ArrayList<String> destination = new ArrayList<String>();
    HashSet<String> OriginLatLng,DestinationLatLng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOrderList = findViewById(R.id.ordersList);
        mOrderList.setHasFixedSize(true);
        mOrderList.setLayoutManager(new LinearLayoutManager(this));
        mOrderList.setItemAnimator(new DefaultItemAnimator());
        myOnClickListener = new MyOnClickListener(this);
        order_id = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getStringSet("order_id",null);
        final OrderDetails orderdetails =  new OrderDetails();
        final Iterator iterator = order_id.iterator();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl("http://192.168.42.20:8000/truck/")
                    .addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.build();
            APIService mAPIService = retrofit.create(APIService.class);
        while (iterator.hasNext()){
            String abc = (String) iterator.next();
            Call<OrderDetails> call  = mAPIService.OrderDetails(abc);
            call.enqueue(new Callback<OrderDetails>() {
                @Override
                public void onResponse(Call<OrderDetails> call, final Response<OrderDetails> response) {
                    if (response.isSuccessful()) {
                        origin.add(response.body().getOrigin());
                        destination.add(response.body().getDestination());
                        populte(response.body(),i,order_id.size());
                        i++;
                    }
                }

                @Override
                public void onFailure(Call<OrderDetails> call, Throwable t) {
                    Log.e(TAG, "Unable to submit post to API.");

                }
            });
        }
        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
        String Originresult = null;
        String Destinationresult = null;
        OriginLatLng = new HashSet<>();
        DestinationLatLng = new HashSet<>();
        for(int i=0;i<origin.size();i++) {
            List addressList = null;
            try {
                addressList = geocoder.getFromLocationName(origin.get(i), 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = (Address) addressList.get(0);
            StringBuilder sb = new StringBuilder();
            sb.append(address.getLatitude()).append("\n");
            sb.append(address.getLongitude()).append("\n");
            Originresult = sb.toString();
            OriginLatLng.add(Originresult);
        }
        for(int i=0;i<destination.size();i++) {
            List addressList = null;
            try {
                addressList = geocoder.getFromLocationName(destination.get(i), 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = (Address) addressList.get(0);
            StringBuilder sb = new StringBuilder();
            sb.append(address.getLatitude()).append("\n");
            sb.append(address.getLongitude()).append("\n");
            Destinationresult = sb.toString();
            DestinationLatLng.add(Destinationresult);
        }
    }
    private void populte(OrderDetails body, int i, int size){
        orderDetails = body;
        orderDetailsList.add(orderDetails);
        if(i <= size){
            //Toast.makeText(this,"Hello", Toast.LENGTH_SHORT).show();
            adapter = new CustomAdapter(orderDetailsList);
            mOrderList.setAdapter(adapter);
        }
        //Toast.makeText(this,size+ "", Toast.LENGTH_SHORT).show();

    }
    private class MyOnClickListener implements View.OnClickListener {
        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            int pos = (int) v.getTag();
            String Farmer_id = orderDetailsList.get(pos).getFarmerId();
            String Farmer_otp = orderDetailsList.get(pos).getFarmerOtp();
            String Merchant_id = orderDetailsList.get(pos).getMerchantId();
            String Merchant_otp = orderDetailsList.get(pos).getMerchantOtp();
            String Origin = orderDetailsList.get(pos).getOrigin();
            String Destination = orderDetailsList.get(pos).getDestination();
            /*Bundle bundle = new Bundle();
            bundle.putString("FarmerId", Farmer_id);
            bundle.putString("MerchantId",Merchant_id);
            bundle.putString("FarmerOtp",Farmer_otp);
            bundle.putString("MerchantOtp",Merchant_otp);
            bundle.putString("Origin",Origin);
            bundle.putString("Destination",Destination);*/
            Intent intent = new Intent(MainActivity.this, TabActivity.class);
            //intent.putExtras(bundle);
            startActivity(intent);
            /* Tab1 tab1 = new Tab1();
             tab1.setArguments(bundle);
             Tab2 tab2 = new Tab2();
             tab2.setArguments(bundle);*/
            //startActivity(new Intent(MainActivity.this,Tab1.class));
        }
    } @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(main_menu,menu);
        menu.findItem(R.id.action_maps).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_maps){
            Intent intent =  new Intent(MainActivity.this,Splash.class);
            intent.putExtra("OriginLatLng",OriginLatLng);
            intent.putExtra("DestinationLatLng",DestinationLatLng);
            intent.putExtra("Priority",0);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
