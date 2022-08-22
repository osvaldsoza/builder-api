# Rest API - Builders
## Tecnologias utilizadas
* SpringBoot
* Spring Data JPA
* Lombok
* Postgres
* Flyway
* Docker
* Docker Compose
* Dockerfile
* JDK 11
* RDS
* EC2

## Swagger AWS
http://ec2-54-233-172-151.sa-east-1.compute.amazonaws.com:8080/swagger-ui.html#/

## Aplicação e base de dados executados via docker
### Na raiz do projeto e digite:
**docker-compose up**
#
**docker network create builder-net**
#
**docker network connect builder-net postgres-builders-api**
#
**docker run -p 8080:8080 --rm --network builder-net soza77/builder:1.0**

## Swagger
http://localhost:8080/swagger-ui.html#/
