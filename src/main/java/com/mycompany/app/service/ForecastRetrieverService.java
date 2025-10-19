package com.mycompany.app.service;

import com.mycompany.app.model.ForecastResponse;
import com.mycompany.app.model.retriever.Details;
import com.mycompany.app.model.retriever.ForecastRetrieverResponse;
import com.mycompany.app.model.retriever.TimedForecastData;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;

@Service
public class ForecastRetrieverService {

    private final RestClient restClient;

    public ForecastRetrieverService(RestClient.Builder clientBuilder)
    {
        this.restClient = clientBuilder
                .baseUrl("https://api.met.no/weatherapi/locationforecast/2.0")
                .build();
    }

    @Cacheable("forecasts")
    public ForecastResponse retrieveForecast(Double lat, Double lon, Instant time)
    {
        ForecastRetrieverResponse retrieverResponse = retrieveForecast(lat, lon);
        ForecastResponse response = new ForecastResponse();
        for(TimedForecastData data : retrieverResponse.getProperties().getTimeseries())
        {
            if(data.getTime().isAfter(time))
            {
                Details details = data.getData().getInstant().getDetails();
                response.setAirTemperature(details.getAirTemperature());
                response.setWindSpeed(details.getWindSpeed());
                break;
            }
        }
        return response;
    }

    private ForecastRetrieverResponse retrieveForecast(double lat, double lon)
    {
        ForecastRetrieverResponse resp = restClient.get().uri(UriComponentsBuilder.fromPath("/compact")
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .toUriString()).retrieve().body(ForecastRetrieverResponse.class);
        //TODO handle bad responses
        return resp;
    }


}
