package com.example.perlakitamas.helloworld;

import android.support.v7.widget.RecyclerView;

import com.crashlytics.android.Crashlytics;
import com.example.perlakitamas.helloworld.weather.bean.WeatherData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsPresenter {

    private DetailsActivity.PlaceholderFragment fragment;
    private WeatherData weatherData;

    private static String city;
    private static DetailsPresenter instance = null;

    private DetailsPresenter() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .build();

        OpenWeatherApi openWeatherApi = retrofit.create(OpenWeatherApi.class);

        openWeatherApi.getWeatherData(city).enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                weatherData = response.body();
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Crashlytics.logException(t);

                // TODO show error message
            }
        });
    }

    public static DetailsPresenter getInstance(String city) {
        if(instance == null || DetailsPresenter.city != city) {
            DetailsPresenter.city = city;

            instance = new DetailsPresenter();
        }
        return instance;
    }

    public void attachView(DetailsScreen screen) {
        this.screen = screen;
    }

    public void detachView() {
        this.screen = null;
    }

    public WeatherData attach(DetailsActivity.PlaceholderFragment fragment) {
        if(weatherData == null) {
            this.fragment = fragment;
        }

        return weatherData;
    }
}
