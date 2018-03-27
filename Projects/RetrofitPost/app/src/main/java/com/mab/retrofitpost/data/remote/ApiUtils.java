package com.mab.retrofitpost.data.remote;

/**
 * Created by MonisBana on 3/19/2018.
 */

public class ApiUtils {
    private ApiUtils() {};
    public static final String BASE_URL = "https://code6sihapi.herokuapp.com/truckCompany/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
