package com.mab.code_6;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.mab.code_6.Service.APIService;
import com.mab.code_6.models.OrderDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "hii";
    Set<String> order_id;
    private RecyclerView.Adapter adapter;
    private RecyclerView mOrderList;
    ArrayList<OrderDetails> orderDetailsList = new ArrayList<>();
    OrderDetails orderDetails;
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOrderList = findViewById(R.id.ordersList);
        mOrderList.setHasFixedSize(true);
        mOrderList.setLayoutManager(new LinearLayoutManager(this));
        mOrderList.setItemAnimator(new DefaultItemAnimator());
        order_id = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getStringSet("order_id",null);
        final OrderDetails orderdetails =  new OrderDetails();
        final Iterator iterator = order_id.iterator();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl("http://192.168.0.103:8000/truck/")
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
                        populte(response.body(),i,order_id.size());
                        i++;
                        //Toast.makeText(MainActivity.this, response.body().getCropDetails().getName()+ "", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(MainActivity.this, response.code() + "", Toast.LENGTH_SHORT).show();
                        /*new Handler().postDelayed(new Runnable(){
                            @Override
                            public void run() {

                                orderdetails.setCropDetails(response.body().getCropDetails());
                                orderdetails.setTransportAmount(response.body().getTransportAmount());
                                orderDetailsList.add(orderdetails);
                                Log.d(TAG,orderdetails.getTransportAmount()+"");
                            }
                        }, 1200);*/
                        /*orderdetails.setFarmerId("5aac1483aaf3a919a4de8251");
                       orderdetails.setTransportId(response.body().getTransportId());
                       orderdetails.setStatus( response.body().getStatus());*/
                                /*response.body().getOrigin()
                                response.body().getDestination()
                                response.body().getId()
                                response.body().getMerchantId()
                                response.body().getCropDetails()
                                response.body().getFarmerAmount()
                                response.body().getMerchantOtp()
                                response.body().getFarmerOtp()
                                response.body().getV()*/
                    }
                }

                @Override
                public void onFailure(Call<OrderDetails> call, Throwable t) {
                    Log.e(TAG, "Unable to submit post to API.");

                }
            });
        }
    }
    private void populte(OrderDetails body, int i, int size){
        orderDetails = body;
        orderDetailsList.add(orderDetails);
        if(i <= size){
            Toast.makeText(this,"Hello", Toast.LENGTH_SHORT).show();
            adapter = new CustomAdapter(orderDetailsList);
            mOrderList.setAdapter(adapter);
        }
        //Toast.makeText(this,size+ "", Toast.LENGTH_SHORT).show();

    }
}
