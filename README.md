# E-commerce Microservices & React

> **Aviso:** Este é um projeto de estudo e aprendizado, desenvolvido com o objetivo de aprofundar conhecimentos em arquitetura de microsserviços com Java (Spring Boot) e integração com um front-end moderno em React.

## Sobre o Projeto

Este projeto é um sistema de e-commerce construído sob a arquitetura de microsserviços. O back-end foi inspirado nos conceitos do livro *"Back-End Java: Microsserviços, Spring Boot e Spring Cloud"*, focado em criar APIs RESTful independentes, resilientes e escaláveis.

Para complementar o aprendizado de arquitetura completa (Full Stack), foi adicionada uma camada de Front-end isolada utilizando **React** e **Vite**, consumindo os microsserviços através de requisições HTTP. Todo o ecossistema é orquestrado localmente utilizando **Docker**.

## 🏗️ Arquitetura e Estrutura

O repositório segue a abordagem de **Monorepo**, separando claramente as responsabilidades:

- `/backend`: Contém os microsserviços em Java (`user-api`, `product-api`, `shopping-api`) e módulos compartilhados.
- `/frontend`: Aplicação SPA (Single Page Application) desenvolvida em React para a interface do utilizador.
- `docker-compose.yaml`: Arquivo de infraestrutura responsável por levantar o banco de dados e o ambiente do front-end em contêineres.

## 🚀 Tecnologias Utilizadas

**Back-end:**
- Java
- Spring Boot 
- Spring Data JPA / Hibernate
- PostgreSQL 
- Flyway 
- Maven

**Front-end:**
- React
- Vite
- JavaScript / TypeScript
