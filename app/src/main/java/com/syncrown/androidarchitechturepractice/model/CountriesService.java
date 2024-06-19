package com.syncrown.androidarchitechturepractice.model;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesService {

    public static final String BASE_URL = "https://restcountries.com/v3.1/";

    private CountriesAPI api;

    public CountriesService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        api = retrofit.create(CountriesAPI.class);
    }

    public Single<List<Country>> getCountries() {
        return api.getCountries();
    }
}
