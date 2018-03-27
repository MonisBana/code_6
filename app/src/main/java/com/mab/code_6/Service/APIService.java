package com.mab.code_6.Service;

import com.mab.code_6.models.CropDetails;
import com.mab.code_6.models.FarmerDetails;
import com.mab.code_6.models.OrderDetails;
import com.mab.code_6.models.Truck;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by MonisBana on 3/19/2018.
 */

public interface APIService {
    @POST("truckLogin")
    @Headers({"Content-Type: application/json", "Cache-Control: max-age=640000"})
    Call<Truck> post(@Body Truck truck);

    @GET("getTrips/{order_id}")
    @Headers({"Content-Type: application/json", "Cache-Control: max-age=640000"})
    Call<OrderDetails> OrderDetails(@Path("order_id") String orderDetails);

    @GET("getTrips/{user_id}")
    @Headers({"Content-Type: application/json", "Cache-Control: max-age=640000"})
    Call<FarmerDetails> getUser(@Path("user_id") String UserId);
}
