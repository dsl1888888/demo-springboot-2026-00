## version  1


## stop and delete  a docker  with name
```

# 1️⃣ Stop any containers using the image
docker ps -a --filter ancestor=harbor.llx123456.space:2443/private/my-nginx-ssl -q | xargs -r docker stop

# 2️⃣ Remove those containers
docker ps -a --filter ancestor=harbor.llx123456.space:2443/private/my-nginx-ssl -q | xargs -r docker rm

# 3️⃣ Remove the image by REPOSITORY:TAG
docker rmi harbor.llx123456.space:2443/private/my-nginx-ssl:latest

# 4️⃣ Optional: force remove if Docker complains
docker rmi -f harbor.llx123456.space:2443/private/my-nginx-ssl:latest

# 5️⃣ Clean up dangling images, stopped containers, and unused networks
docker system prune -f

```


## Stop all  local docker

 ```

# 1️⃣ Stop all running containers
docker stop $(docker ps -q)

# 2️⃣ Remove all containers
docker rm $(docker ps -a -q)

# 3️⃣ Remove all images (force)
docker rmi -f $(docker images -q)

# 4️⃣ Remove all volumes
docker volume rm $(docker volume ls -q)

# 5️⃣ Remove all custom networks (keep bridge, host, none)
docker network rm $(docker network ls -q | grep -v "bridge\|host\|none")

# 6️⃣ Clean up unused Docker objects (optional extra)
docker system prune -a --volumes -f

 ```


 ## the basic step maintance 

```
<!-- docker build -t my-nginx-ssl:latest . -->

docker build -t my-nginx-ssl:latest -f dockerfile .

echo "Harbor12345" | docker login harbor.llx123456.space:2443 -u admin --password-stdin


docker tag my-nginx-ssl:latest  harbor.llx123456.space:2443/private/my-nginx-ssl:latest


docker push harbor.llx123456.space:2443/private/my-nginx-ssl:latest
docker push harbor.llx123456.space:2443/private/my-nginx-ssl:latest


docker run -d \
--name my-nginx-ssl \
-p 380:80 \
-p 3443:443 \
harbor.llx123456.space:2443/private/my-nginx-ssl:latest

```

Test
```
curl http://localhost:80           # no working
curl -k https://localhost:443      # good
curl  https://localhost:443
curl -k https://localhost:443      # good
curl https://www.llx123456.space -v
curl https://www.llx123456.space:3443 # good


https://www.llx123456.space:3443/


http://www.llx123456.space:380/
```


