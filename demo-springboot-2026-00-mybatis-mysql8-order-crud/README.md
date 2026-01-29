

docker run mysql

for windows
```
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_INITDB_SKIP_TZINFO=1 -e MYSQL_CHARACTER_SET_SERVER=utf8mb4 -e MYSQL_COLLATION_SERVER=utf8mb4_unicode_ci -v D:/docker_data/mysql_data:/var/lib/mysql -p 3306:3306 -d --restart always mysql:8.0

```


for linux
```
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_INITDB_SKIP_TZINFO=1 -e MYSQL_CHARACTER_SET_SERVER=utf8mb4 -e MYSQL_COLLATION_SERVER=utf8mb4_unicode_ci -v /docker_data/mysql_data:/var/lib/mysql -p 3306:3306 -d --restart always mysql:8.0

```