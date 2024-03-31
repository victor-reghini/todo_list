<h1 align="center">
  TODO LIST API
</h1>


Simple TODO List API (CRUD) to reinforce the basics of back-end programming

This project was executed using [this video](https://youtu.be/IjProDV001o).

## Used technologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## How to run this application

- Clone git repository:

```
$ git clone https://github.com/victor-reghini/todo_list.git
```
- Build project:
```
$ ./mvnw clean package
```
- Run application:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

The API can be accessed on [localhost:8080](http://localhost:8080).

The Swagger documentation can be accessed on [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Used tool for the requests bellow: [httpie](https://httpie.io)

- Create TODO
```
$ http POST :8080/todos name="Todo 1" description="Desc Todo 1" priority=1

[
  {
    "description": "Desc Todo 1",
    "id": 1,
    "name": "Todo 1",
    "priority": 1,
    "done": false
  }
]
```

- List All TODOs
```
$ http GET :8080/todos

[
  {
    "description": "Desc Todo 1",
    "id": 1,
    "name": "Todo 1",
    "priority": 1,
    "done": false
  }
]
```

- Update TODO
```
$ http PUT :8080/todos/1 name="Todo 1 Up" description="Desc Todo 1 Up" priority=2 done=true

[
  {
    "description": "Desc Todo 1 Up",
    "id": 1,
    "name": "Todo 1 Up",
    "priority": 2,
    "done": true
  }
]
```

- Delete TODO
```
http DELETE :8080/todos/1

[ ]
```