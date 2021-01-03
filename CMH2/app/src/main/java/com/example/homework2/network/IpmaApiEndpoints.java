package com.example.homework2.network;

import com.example.homework2.model.CityGroup;
import com.example.homework2.model.WeatherGroup;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IpmaApiEndpoints {
    @GET("open-data/distrits-islands.json")
    Call<CityGroup> getCityParent();

    @GET("open-data/forecast/meteorology/cities/daily/{localId}.json")
    Call<WeatherGroup> getWeatherParent(@Path("localId") int localId);

}
