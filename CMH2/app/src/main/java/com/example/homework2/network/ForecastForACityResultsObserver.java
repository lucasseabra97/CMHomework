package com.example.homework2.network;

import com.example.homework2.model.Weather;

import java.util.List;

public interface ForecastForACityResultsObserver {
    public void receiveForecastList(List<Weather> forecast);
    public void onFailure(Throwable cause);
}
