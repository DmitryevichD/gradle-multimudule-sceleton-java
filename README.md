# Project describe the stucture of an application that containing business logic and API module

Common structure:

```
project
│   setting.gradle
│   build.gradle  
│
└───service-api
|   └─── main.java.ru.open.da.<service-package>
|        └─── api (package store beans that should use by an external service)
|        |    ...
|        └─── contract <package store contacts that bind the api and the app>
|        |    ...
|        └─── build.gradle
|
|
└───service-app
    └─── main.java.ru.open.da.<service-package>
         |    ...
         └─── build.gradle
```

## Pre requirements
* JDK 8 or later
* Docker

## How to run the project locally
- create local dev.env file and fill it (see `.env.example`)
- start docker-compose
```bash
./docker-start.sh
```
- publish service-api to maven local repository
```bash
./gradlew :service-api:publishToMavenLocal
```
- start application
```bash
./gradlew :service-app:bootRun
```
- start external client with API as dependency
```bash
cd client-with-api-example
./gradlew bootRun
```

