<div align="center">

![](https://img.shields.io/badge/Status-Em%20Desenvolvimento-orange)
</div>

<div align="center">

# POC - API CRUD com Springboot usando generics Java
![](https://img.shields.io/badge/Autor-Wesley%20Oliveira%20Santos-brightgreen)
![](https://img.shields.io/badge/Language-java-brightgreen)
![](https://img.shields.io/badge/Framework-springboot-brightgreen)
![](https://img.shields.io/badge/docs-swagger-brightgreen)

</div> 

## Fundamentos teóricos

> Springboot: O Spring Boot é um projeto da Spring que veio para facilitar o processo de configuração e publicação de nossas aplicações. A intenção é ter o seu projeto rodando o mais rápido possível e sem complicação.

> Swagger: Swagger é uma linguagem de descrição de interface para descrever APIs RESTful expressas usando JSON. O Swagger é usado junto com um conjunto de ferramentas de software de código aberto para projetar, construir, documentar e usar serviços da Web RESTful.

> Swagger: Swagger é uma linguagem de descrição de interface para descrever APIs RESTful expressas usando JSON. O Swagger é usado junto com um conjunto de ferramentas de software de código aberto para projetar, construir, documentar e usar serviços da Web RESTful.

> Java: Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems. Em 2008 o Java foi adquirido pela empresa Oracle Corporation.

> Generics: Os genéricos são um recurso de programação genérica que foi incluída na linguagem de programação Java em 2004 na versão J2SE 5.0. Eles foram projetados para estender o sistema de tipos do Java para permitir que "um tipo ou método opere em objetos de vários tipos, fornecendo segurança do tipo em tempo de compilação".

## License
![GitHub](https://img.shields.io/github/license/wesleyosantos91/poc-api-first)

## Tecnologias
- Java 11
- Spring Boot 2.2.6.RELEASE
  - spring-boot-starter-web
  - spring-boot-starter-data-jpa
  - spring-boot-devtools
- Flywaydb
- Lombok
- Mysql
- Swagger
  - springfox-swagger2
  - springfox-swagger-ui
- Tomcat (Embedded no Spring Boot)
- Git

## Execução

- Scripts
  ### Executar docker-compose
  - 1° comando: ``` cd src/main/docker/```
  - 2° comando: ```docker-compose -f docker-compose.yml up```
  ### Executar a aplicação
  -  ```./mvnw clean compile spring-boot:run```
  ### Executar testes
  -  ```./mvnw clean compile verify sonar:sonar```

# Utilização

## Swagger
http://localhost:8080/swagger-ui.html
    
