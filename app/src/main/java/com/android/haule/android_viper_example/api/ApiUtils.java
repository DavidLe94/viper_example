package com.android.haule.android_viper_example.api;

/**
 * Created by Hau Le on 2018-10-09.
 */
public class ApiUtils {
    private static final String STAGE = "https://api.stackexchange.com/";
    private static final String DEV = "";
    private static final String PRODUCTION = "";

    public static ApiServices getApiService() {
        return RetrofitClient.getClient(STAGE).create(ApiServices.class);
    }
}
