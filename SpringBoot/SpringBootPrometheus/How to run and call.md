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
docker run --name prom-container2 -p 7070:8080 -d prom
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



### Prometheus

After adding to pom.xml these artifactId's: spring-boot-starter-actuator, micrometer-core, micrometer-registry-prometheus:

http://localhost:7070/actuator/

http://localhost:7070/actuator/info

http://localhost:7070/actuator/health

But not http://localhost:7070/actuator/prometheus (404)



As described on https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-endpoints (2.2. Exposing Endpoints), all endpoints except for _info_  and _health_ must be explicitly exposed in the application.properties:

```
management.endpoints.web.exposure.include=health,info,prometheus,metrics
```

This exposes http://localhost:7070/actuator/metrics, but Prometheus looks for http://ex655:9090/metrics...



Prometheus not working after upgrading to Spring Boot Version 2: https://github.com/prometheus/client_java/issues/452

	I can't generallly recommend micrometer, it does some things which don't make sense in Prometheus instrumentation terms. Generally I'm not a fan of instrumentation facades, they tend to lose you the benefits of the monitoring system you're using due to having to be be lowest-common-denominator, often encourage anti-patterns, are less performant, and have different resultant metrics depending on the output system.
	
	Micrometer is better than most, but I'd generally recommend using a Prometheus client directly and converting to other monitoring systems as needed by handling registry output. Prometheus clients are designed not to lock you in.

