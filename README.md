# Rest API - Builders
## Tecnologias utilizadas
* SpringBoot
* Spring Data JPA
* Lombok
* Postgres
* Flyway
* Docker
* Docker Compose
* JDK 11
* AWS RDS
* AWS EC2

# Aplicação e base de dados executados via docker
### Raiz do projeto e digite:
**docker-compose up**
#
**docker network create builder-net**
**docker network connect builder-net postgres-builders-api**
**docker run -p 8080:8080 --rm --network builder-net soza77/builder:1.0**

Com isso a base,**builder**, será iniciada, com a tabela **clientes**, com alguns registros iniciais.

## Swagger
http://localhost:8080/swagger-ui.html#/
