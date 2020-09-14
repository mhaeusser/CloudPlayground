

### Start Server

- run SpringBootPrometheusfrom IntelliJ
or
- `mvn spring-boot:run`



#### Health

localhost:8080/health



#### Player

Delete all data: `curl -X DELETE "localhost:8080/deleteAll"`

Create a player: `curl -X PUT "localhost:8080/create?id=42"`

Delete a player: `curl -X DELETE "localhost:8080/delete?id=42"`

Save a score: `curl -X PUT "localhost:8080/score?id=42&score=15"`

List scores: `curl "localhost:8080/list"`

