# A simple crud rest api using spring data jpa, mysql, spring security

## Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Connection

Database: demo
Tables: cats, members and roles

```
spring.datasource.url=jdbc:mysql://localhost:3306/demo
spring.datasource.username=yourusename
spring.datasource.password=yourpassword
```

## A simple entity

```java
public class Cat {
    private long id;
    private String name;
    private int age;
}
```

## Endpoints

| Method | Endpoint |
| --- | --- |
| GET | /api/cats |
| GET | /api/cats/{id} |
| POST | /api/cats |
| PUT | /api/cats/{id} |
| DELETE | /api/cats/{id} |

## Run

```
mvn spring-boot:run
```