package com.syncrown.androidarchitechturepractice.mvc;

import android.annotation.SuppressLint;
import android.widget.Toast;

import com.syncrown.androidarchitechturepractice.model.CountriesService;
import com.syncrown.androidarchitechturepractice.model.Country;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CountriesController {

    private MVCActivity view;
    private CountriesService service;

    public CountriesController(MVCActivity view) {
        this.view = view;
        service = new CountriesService();
        fetchCountries();
    }

    @SuppressLint("CheckResult")
    private void fetchCountries() {
        service.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {
                    @Override
                    public void onSuccess(@NonNull List<Country> countries) {
                        List<String> countryNames = new ArrayList<>();
                        for (Country country : countries) {
                            countryNames.add(country.countryName.official);
                        }
                        view.setValues(countryNames);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.onError();
                    }
                });
    }

    public void onRefresh() {
        fetchCountries();
    }
}
