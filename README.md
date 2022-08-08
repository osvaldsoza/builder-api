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
* AWS RDS
* AWS EC2

# Opcao 1 AWS: 
## A aplicação encontra-se no EC2 AWS e base de dados está RDS. Verificar a collection, Builder.postman_collection.json, que encontra-se no diretorio do projeto

# Opcao 2 Docker: 
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
