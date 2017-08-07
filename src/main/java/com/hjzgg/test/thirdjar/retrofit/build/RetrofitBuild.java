package com.hjzgg.test.thirdjar.retrofit.build;


import com.hjzgg.test.thirdjar.retrofit.url.UrlConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuild {

    public static <T> T build(final Class<T> type) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstants.LOCALHOST_BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(type);
    }
}
