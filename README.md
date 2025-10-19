# spond-interview

# Run app
Download the source code and then run:
`mvn clean install`

Hopefully all goes well with that, then run:
`mvn spring-boot:run`

This will spin up the application. This service assumes that some other service is populating a database 
with events. The App.java file populates an in-memory database with fake data. Eight events are created with
ids 1 through 8. To test the endpoint you can just use a curl command:
`curl http://localhost:8080/forecast/event/{id}`

If you would like to test specific coordinates or anything else, you can modify the App.java file to change
the data that is loaded into the database upon app start.

# Code improvements
It is definitely worth it to add unit tests to make sure the code stays maintainable.
Also the code needs to have better handling of error responses from the Location Forecast API.

More work needs to be put into selecting which data in the timeseries list is used from the API response. 
Right now it just uses the forecast from the earliest time that overlaps with the event time, but perhaps it should be the forecast
from the middle of the event.

# Production Evnironment
Right now this service is using an in memory database and cache. In production it should be deployed with a dedicated
database service (Postgres or MySQL) and caching service (Redis).