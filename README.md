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

| Method | Endpoint | role |
| --- | --- | --- |
| GET | /api/cats | ROLE_EMPLOYEE |
| GET | /api/cats/{id} | ROLE_EMPLOYEE |
| POST | /api/cats | ROLE_MANAGER |
| PUT | /api/cats/{id} | ROLE_MANAGER |
| DELETE | /api/cats/{id} | ROLE_ADMIN |

## Users

## Endpoints

| username | password | role |
| --- | --- | --- |
| ana | test123 | ROLE_EMPLOYEE |
| topson | test123 | ROLE_EMPLOYEE, ROLE_MANAGER |
| notail | test123 | ROLE_EMPLOYEE, ROLE_MANAGER, ROLE_ADMIN |

## repositories folder

There are two files:

- CatDao.java (using EntityManager)
- CatRepository (using JpaRepository)

Inject the one you want into CatServiceImpl.java

```java
@Service
public class CatServiceImpl implements CatService{
    
    private final CatRepository catRepository; // replace with CatDao if you want

    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    // some other methods
}
```

## Run

```
mvn spring-boot:run
```