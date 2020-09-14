
REM timeout 2 > NUL

REM Delete all data
curl -X DELETE "localhost:8080/deleteAll"

REM Ready player one
curl -X PUT "localhost:8080/create?id=42"

REM Create another player
curl -X PUT "localhost:8080/create?id=1"

REM Save a score
curl -X PUT "localhost:8080/score?id=1&score=10"

REM Save a score
curl -X PUT "localhost:8080/score?id=1&score=20"

REM Save a score
curl -X PUT "localhost:8080/score?id=1&score=20"

REM Save a score
curl -X PUT "localhost:8080/score?id=1&score=15"

REM Save a score for a non-existent player
curl -X PUT "localhost:8080/score?id=12&score=15"

REM Delete player
curl -X DELETE "localhost:8080/delete?id=42"

REM Delete player again, must cause error message
curl -X DELETE "localhost:8080/delete?id=42"
