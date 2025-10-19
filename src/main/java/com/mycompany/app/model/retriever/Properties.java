package com.mycompany.app.model.retriever;

public class Properties {

    private TimedForecastData[] timeseries;

    public TimedForecastData[] getTimeseries() {
        return timeseries;
    }

    public void setTimeseries(TimedForecastData[] timeseries) {
        this.timeseries = timeseries;
    }
}
