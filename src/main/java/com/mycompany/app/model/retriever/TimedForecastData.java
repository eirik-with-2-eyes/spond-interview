package com.mycompany.app.model.retriever;

import java.time.Instant;

public class TimedForecastData {

    private Instant time;
    private Data data;

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
