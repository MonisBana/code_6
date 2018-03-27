package com.mab.retrofitpost.data.remote;

import com.mab.retrofitpost.data.Truck;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by MonisBana on 3/19/2018.
 */

public interface APIService {
    @POST("truckLogin")
    @Headers({"Content-Type: application/json", "Cache-Control: max-age=640000"})
    Call<Truck> post(@Body Truck truck);
}
