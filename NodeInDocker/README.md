# Node in Docker

Simple example, taken from the book _kubernetes in action_.



How to run:

```script
docker build -t nodetest .
docker images
docker run --name node-container -p 8091:8080 -d nodetest
```

open http://localhost:8091/
