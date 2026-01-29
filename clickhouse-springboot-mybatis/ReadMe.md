
```
docker run -d \
  --name clickhouse \
  -p 8123:8123 \
  -p 9000:9000 \
  --ulimit nofile=262144:262144 \
  -e CLICKHOUSE_DB=demo \
  -e CLICKHOUSE_USER=admin \
  -e CLICKHOUSE_PASSWORD=StrongPass123 \
  -e CLICKHOUSE_DEFAULT_ACCESS_MANAGEMENT=1 \
  -v clickhouse_data:/var/lib/clickhouse \
  --restart unless-stopped \
  clickhouse/clickhouse-server:25.1

```


```
docker run -d --name clickhouse -p 8123:8123 -p 9000:9000 --ulimit nofile=262144:262144 -e CLICKHOUSE_DB=demo -e CLICKHOUSE_USER=admin -e CLICKHOUSE_PASSWORD=StrongPass123 -e CLICKHOUSE_DEFAULT_ACCESS_MANAGEMENT=1 -v clickhouse_data:/var/lib/clickhouse --restart unless-stopped clickhouse/clickhouse-server:25.1

```

```
Access Swagger UI: http://localhost:8080/swagger-ui/index.html
Access OpenAPI Docs: http://localhost:8080/v3/api-docs

```