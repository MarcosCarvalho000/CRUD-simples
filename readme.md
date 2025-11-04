# CRUD - Aplicação Exemplo (Spring Boot)

Projeto exemplo de CRUD usando Spring Boot, JPA e banco em memória H2.

## Visão geral
Aplicação simples para gerenciar tarefas (entidade `Crud`) com endpoints REST.

## Requisitos
- Java 21
- Maven (ou usar o wrapper `mvnw` / `mvnw.cmd`)

## Como executar
1. Usando o wrapper (Linux/macOS):
   ./mvnw spring-boot:run
2. Usando o wrapper (Windows):
   mvnw.cmd spring-boot:run
3. Build:
   ./mvnw clean package
   java -jar target/crud-0.0.1-SNAPSHOT.jar

## Testes
Executar:
./mvnw test

## Endpoints
Base: /crud

- GET /crud/listar — listar todas as tarefas  
- GET /crud/listar/{id} — obter tarefa por id  
- POST /crud/adicionar — criar tarefa (body: string com conteúdo)  
- PUT /crud/atualizar/{id} — atualizar tarefa (body: string com conteúdo)  
- DELETE /crud/deletar/{id} — deletar tarefa

## Banco de dados
H2 em memória configurado em [src/main/resources/application.properties](src/main/resources/application.properties). Console H2 habilitado.

## Estrutura principal
- Aplicação: [src/main/java/dev/crud/CrudApplication.java](src/main/java/dev/crud/CrudApplication.java)  
- Controller: [`dev.crud.controller.CrudController`](src/main/java/dev/crud/controller/CrudController.java)  
- Serviço: [`dev.crud.services.CrudServices`](src/main/java/dev/crud/services/CrudServices.java)  
- Modelo: [`dev.crud.models.Crud`](src/main/java/dev/crud/models/Crud.java)  
- Repositório: [`dev.crud.repository.CrudRepository`](src/main/java/dev/crud/repository/CrudRepository.java)  
- Configuração Maven: [pom.xml](pom.xml)  
- Scripts wrapper: [mvnw](mvnw), [mvnw.cmd](mvnw.cmd), [.mvn/wrapper/maven-wrapper.properties](.mvn/wrapper/maven-wrapper.properties)

## Observações
- Endpoints recebem e retornam valores simples (strings/JSON) conforme implementado em [`dev.crud.controller.CrudController`](src/main/java/dev/crud/controller/CrudController.java) e [`dev.crud.services.CrudServices`](src/main/java/dev/crud/services/CrudServices.java).
- Ajustes futuros: validar entradas, usar DTOs, tratar erros com respostas HTTP apropriadas.
