package com.mycompany.app.controller;

import com.mycompany.app.model.ForecastResponse;
import com.mycompany.app.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecastController {

    @Autowired
    ForecastService forecastService;

    @GetMapping("forecast/event/{id}")
    public ResponseEntity getForecastForEvent(@PathVariable("id") Integer id)
    {
        try {
            return ResponseEntity.ok(forecastService.getForecast(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(e.getMessage());
        }

    }
}
