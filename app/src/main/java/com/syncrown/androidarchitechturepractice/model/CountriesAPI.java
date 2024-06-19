package com.syncrown.androidarchitechturepractice.model;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

interface CountriesAPI {
    @GET("all")
    Single<List<Country>> getCountries();
}
