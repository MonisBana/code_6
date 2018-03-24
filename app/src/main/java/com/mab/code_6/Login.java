package com.mab.code_6;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mab.code_6.Service.APIService;
import com.mab.code_6.models.Trip;
import com.mab.code_6.models.Truck;

import java.util.HashSet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    private static final String TAG ="hi" ;
    private EditText truckno,password;
    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        truckno = (EditText) findViewById(R.id.truckno);
        password = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        truckno.setText("MH052320");
        password.setText("nee1997");

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashSet<String> order_id = new HashSet<>();
                order_id.add("5ab3f224e1cb560bd87ccf6c");
                order_id.add("5ab3f429e1cb560bd87ccf72");
                order_id.add("5ab3f45ee1cb560bd87ccf75");
                order_id.add("5ab3f4c5e1cb560bd87ccf78");
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putStringSet("order_id",order_id).apply();
                startActivity(new Intent(Login.this, MainActivity.class));
                String Truckno = truckno.getText().toString().trim();
                String Password = password.getText().toString().trim();
                if(!TextUtils.isEmpty(Truckno) && !TextUtils.isEmpty(Password)) {
                    //Toast.makeText(MainActivity.this, Truckno+"", Toast.LENGTH_SHORT).show();
                    com.mab.code_6.models.Response respons = new com.mab.code_6.models.Response();
                    respons.setTrucknum(Truckno);
                    respons.setPassword(Password);
                    Truck truck = new Truck(true,respons);
                    //sendPost(truck);
                }
            }
        });
    }

    private void sendPost(Truck truck) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.0.103:8000/truckCompany/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        APIService mAPIService = retrofit.create(APIService.class);
        Call<Truck> call = mAPIService.post(truck);
        call.enqueue(new Callback<Truck>() {
            @Override
            public void onResponse(Call<Truck> call, Response<Truck> response) {
                if (response.isSuccessful()) {
                    if (response.body().getMessage().equals(true)) {
                        Toast.makeText(Login.this, response.body().getResponse().getTrip() + "", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(Login.this, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(Login.this, MainActivity.class));
                    }
                    else {
                        Toast.makeText(Login.this, response.code() + "", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Truck> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
            }
        });

    }
    }