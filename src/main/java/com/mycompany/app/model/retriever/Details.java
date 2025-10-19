package com.mycompany.app.model.retriever;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Details {

    @JsonProperty("wind_speed")
    private Double windSpeed;

    @JsonProperty("air_temperature")
    private Double airTemperature;

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(Double airTemperature) {
        this.airTemperature = airTemperature;
    }
}
