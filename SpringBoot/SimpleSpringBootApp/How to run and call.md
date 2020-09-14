

### Start Server

- run SSBApplication from IntelliJ
or
- `mvn spring-boot:run`





#### Health

localhost:8080/health





#### Player

Create a player: `curl -X PUT "localhost:8080/create?id=42"`

Delete a player: `curl -X DELETE "localhost:8080/delete?id=42"`
