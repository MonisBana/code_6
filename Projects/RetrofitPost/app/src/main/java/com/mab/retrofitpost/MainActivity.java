package com.mab.retrofitpost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mab.retrofitpost.data.Truck;
import com.mab.retrofitpost.data.remote.APIService;
import com.mab.retrofitpost.data.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "hi" ;
    private TextView mResponseTv;
    private APIService mAPIService;
    private  Button loginBtn;
    private EditText truckno,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        truckno = (EditText) findViewById(R.id.et_truckno);
        password = (EditText) findViewById(R.id.et_password);
        loginBtn = (Button) findViewById(R.id.btn_login);
        mResponseTv = (TextView) findViewById(R.id.tv_response);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Truckno = truckno.getText().toString().trim();
                String Password = password.getText().toString().trim();
                if(!TextUtils.isEmpty(Truckno) && !TextUtils.isEmpty(Password)) {
                    //Toast.makeText(MainActivity.this, Truckno+"", Toast.LENGTH_SHORT).show();
                    Truck truck = new Truck();
                    truck.setTrucknum(Truckno);
                    truck.setPassword(Password);
                    sendPost(truck);
                }
            }
        });
    }

    private void sendPost(Truck truck) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://code6sihapi.herokuapp.com/truckCompany/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        //http://localhost:8000/
        APIService mAPIService = retrofit.create(APIService.class);
        Call<Truck> call = mAPIService.post(truck);
        call.enqueue(new Callback<Truck>() {
            @Override
            public void onResponse(Call<Truck> call, Response<Truck> response) {
                Toast.makeText(MainActivity.this,response.code()+ "", Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    startActivity(new Intent(MainActivity.this,Login.class));
                    Toast.makeText(MainActivity.this, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                    showResponse(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Truck> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
        
    }
    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }
}
