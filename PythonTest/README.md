# Docker Python Test


#### Plain Docker

Requires a Docker installation, see
https://docs.docker.com/engine/installation/

The following steps are taken from
https://docs.docker.com/get-started/

Try

~~~
docker run hello-world
docker image ls
docker container ls --all
~~~

then

~~~
cd PythonTest
docker build --tag=friendlyhello .
docker run -p 4000:80 friendlyhello
~~~

open http://localhost:4000

~~~
docker container ls
docker container stop <CONTAINER ID>
~~~

~~~
docker login
docker tag friendlyhello mhaeusser/pythontest:part2
docker image ls
docker push mhaeusser/pythontest:part2
~~~

Output: `The push refers to repository [docker.io/mhaeusser/pythontest]`

Web: <https://cloud.docker.com/u/mhaeusser/repository/docker/mhaeusser/pythontest>

~~~
docker run -p 4000:80 mhaeusser/pythontest:part2
~~~



Attach interactively:

~~~
docker run -i -t mhaeusser/pythontest:part2 /bin/bash
~~~



#### Services

~~~
cd Swarm
docker swarm init
docker stack deploy -c docker-compose.yml getstartedlab
docker service ls
docker service ps getstartedlab_web
docker swarm leave --force
~~~


