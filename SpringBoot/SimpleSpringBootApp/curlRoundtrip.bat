
REM Delete all data
curl -X DELETE "localhost:8080/deleteAll"

REM Ready player one
curl -X PUT "localhost:8080/create?id=42"

REM Create another player
curl -X PUT "localhost:8080/create?id=1"



REM Delete player
curl -X DELETE "localhost:8080/delete?id=42"

REM Delete player again, must cause error message
curl -X DELETE "localhost:8080/delete?id=42"
