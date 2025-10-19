package com.mycompany.app.service;

import com.mycompany.app.model.Event;
import com.mycompany.app.model.ForecastResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class ForecastService {

    @Autowired
    private ForecastRetrieverService forecastRetrieverService;

    @Autowired
    private EventDao eventDao;

    public ForecastResponse getForecast(int id) throws Exception {
        Optional<Event> eventOpt = eventDao.findById(id);
        if(eventOpt.isEmpty())
            throw new Exception("Event does not exist");
        Event event = eventOpt.get();
        if(event.getStartTime() == null)
            throw new Exception("Event does not have a time set");
        if(event.getEndTime() != null && event.getEndTime().isBefore(Instant.now()))
            throw new Exception("Event is over");
        if(event.getStartTime().isAfter(Instant.now().plus(7, ChronoUnit.DAYS)))
            throw new Exception("Event is more than 7 days away");
        if(event.getLat() == null || event.getLon() == null)
            throw new Exception("Event does not have location set");
        return forecastRetrieverService.retrieveForecast(event.getLat(), event.getLon(), event.getStartTime());
    }

}
