# SpringBootPrometheus 

Simple Spring Boot (_SSB_) app to test Docker and Prometheus.

### Starting the Server

##### IntelliJ or so

Run the SSBApplication class.

##### Maven

`mvn spring-boot:run`

##### Docker

```
docker build -t prom .
docker run --name prom-container2 -p 8080:8080 -d prom
```



### Endpoints

#### Health

http://localhost:8080/health

#### Player

See `curlRoundtrip.bat`.

Delete all data: `curl -X DELETE "localhost:8080/deleteAll"`

Create a player: `curl -X PUT "localhost:8080/create?id=42"`

Delete a player: `curl -X DELETE "localhost:8080/delete?id=42"`

Save a score: `curl -X PUT "localhost:8080/score?id=42&score=15"`

List scores: `curl "localhost:8080/list"`

