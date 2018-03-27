package com.mab.mongodbcloud;

import com.mab.mongodbcloud.Class.User;

/**
 * Created by MonisBana on 3/1/2018.
 */

public class Common {
        private static String DB_NAME = "myfirstdb";
    private static String COLLECTION_NAME = "user";
    public static  String API_KEY = "RZ5Paihjly4ugMWatV4ONjdQp6LSGUB2";

    public static String getAddressSingle(User user) {
        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME);
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("/"+user.get_id().getOid()+"?apiKey="+API_KEY);
        return  stringBuilder.toString();
    }
    public static String getAddressAPI() {
        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME);
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return  stringBuilder.toString();
    }
}
