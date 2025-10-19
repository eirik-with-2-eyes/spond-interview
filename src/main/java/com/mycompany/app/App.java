package com.mycompany.app;

import com.mycompany.app.model.Event;
import com.mycompany.app.service.EventDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(App.class, args);
        EventDao dao = context.getBean(EventDao.class);
        Instant now = Instant.now();
        Event event = new Event();
        event.setId(1);
        event.setLat(53.0);
        event.setLon(47.0);
        event.setStartTime(now);
        event.setEndTime(now.plus(1, ChronoUnit.HOURS));
        dao.save(event);

        Event ev2 = new Event();
        ev2.setId(2);
        ev2.setLat(67.0);
        ev2.setLon(56.0);
        ev2.setStartTime(now.plus(10, ChronoUnit.DAYS));
        ev2.setEndTime(now.plus(10, ChronoUnit.DAYS));
        dao.save(ev2);

        Event ev3 = new Event();
        ev3.setId(3);
        ev3.setLat(34.4);
        ev3.setLon(45.7);
        ev3.setStartTime(now.plus(5, ChronoUnit.DAYS));
        ev3.setEndTime(now.plus(5, ChronoUnit.DAYS).plus(1, ChronoUnit.HOURS));
        dao.save(ev3);

        Event ev4 = new Event();
        ev4.setId(4);
        ev4.setStartTime(now.plus(2, ChronoUnit.HOURS));
        ev4.setEndTime(now.plus(4, ChronoUnit.HOURS));
        dao.save(ev4);

        Event ev5 = new Event();
        ev5.setId(5);
        ev5.setLon(45.0);
        ev5.setStartTime(now.plus(4, ChronoUnit.HOURS));
        ev5.setEndTime(now.plus(6, ChronoUnit.HOURS));
        dao.save(ev5);

        Event ev6 = new Event();
        ev6.setId(6);
        ev6.setLon(23.5);
        ev6.setLat(24.9);
        dao.save(ev6);

        Event ev7 = new Event();
        ev7.setId(7);
        ev7.setLat(13.5);
        ev7.setLon(90.0);
        ev7.setStartTime(now);
        ev7.setEndTime(now.plus(1, ChronoUnit.HOURS));
        dao.save(ev7);

        Event ev8 = new Event();
        ev8.setId(8);
        ev8.setLat(10.2);
        ev8.setLon(68.2);
        ev8.setStartTime(now.minus(8, ChronoUnit.HOURS));
        ev8.setEndTime(now.minus(6, ChronoUnit.HOURS));
        dao.save(ev8);



    }
}
