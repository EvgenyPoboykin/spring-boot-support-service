# Start project with Docker



```shell
# create docker with postgrees
make db.container
# start project
make project.dev
```
Swagger url

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)


## build

```shell
make project.build
```

## Create db

```shell
make db.create
```

## Docker start

```shell
make container.start
```

## Docker stop

```shell
make container.stop
```