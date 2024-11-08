
# Entrega do desafio DummyJSON Client - Java 8 e Spring Boot 2.x.x

## Descrição da Entrega

Este projeto é a entrega do desafio proposto em: https://github.com/WendellTufano/code-challenge-migration

## O que foi realizado
- Atualização do `pom.xml` para usar Java 17+ e Spring Boot 3.2.5;
- Substituição `RestTemplate` por `WebClient`
- Substituição dos testes unitários feitos com `JUnit 4` e `Mockito` por testes de integração utilizando `@SpringBootTest`.
- Refatoração de código;
- Compatibilidade dos testes unitários e de mutanção após a migração;
- URL da API dummyjson parametrizada por ambiente(prod e local) no projeto;
- Adicionada URI `/health` para HealthCheck;
- Aplicação conternizada e disponibilizada do dockerhub: https://hub.docker.com/repository/docker/lipesmile/dummy-json-client/general
- Adicionada depedências para auxiliar no refactor, migração e também compatibilidade com macOS.

## Passos para Executar o Projeto

### Pré-requisitos

- **Java 17**
- **Maven 3.8.x**

### Executar a Aplicação

1. Clone o repositório:
    ```bash
    git clone https://github.com/lipesmile/code-challenge-migration.git
    cd dummyjson-client
    ```

2. Compile e execute o projeto:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
    
2.1 Executar o projeto com profile local
   Neste profile o projeto é executado na porta 9090

    mvn clean install
    mvn spring-boot:run -Dspring-boot.run.profiles=local
    
Obs.: Verificar se a porta 8080 ou 9090 não estão sendo usadas    


3. Acesse o serviço:
   
    O serviço estará disponível em `http://localhost:8080`
   
    No profile local `http://localhost:9090`

5. URIs da aplicação

   Trazer todos os produtos: `http://localhost:8080/api/products`
   
   Trazer um id especifico: `http://localhost:8080/api/products/1`

   Health check: `http://localhost:8080/health`

Obs.: Se estiver no profile local, trocar a porta de 8080 por 9090


   
### Executar Testes
Para executar os testes unitários:

```bash
mvn clean test
```

## Executando via Container
O container do projeto pode ser baixado do dockerhub: https://hub.docker.com/r/lipesmile/dummy-json-client


No container tanto 'prod' como 'local' executam na mesma porta 8080, por isso, são acessados pelo browser igualmente:

`http://localhost:8080`

Obs.: Verificar se a porta 8080 não está sendo usada


### Usando docker

1. Faça o pull da imagem

```bash
docker pull lipesmile/dummy-json-client:v1.0
```

2. Execute o run passando o ambiente 'prod' ou 'local'

Prod:

```bash
docker run --env ENV=prod -d -p 8080:8080 lipesmile/dummy-json-client:v1.0
```

Local:

```bash
docker run --env ENV=local -d -p 8080:9090 lipesmile/dummy-json-client:v1.0
```

3. Verifique se a imagem está rodando

```bash
docker ps
```

### Usando podman
1. Faça o pull da imagem do dockerhub

```bash
podman pull docker.io/lipesmile/dummy-json-client:v1.0
```

2. Execute o run passando o ambiente 'prod' ou 'local'

Prod:
```bash
podman run --env ENV=prod -d -p 8080:8080 docker.io/lipesmile/dummy-json-client:v1.0
```

Local:
```bash
podman run --env ENV=local -d -p 8080:9090 docker.io/lipesmile/dummy-json-client:v1.0
```

3. Verifique se a imagem está rodando
```bash
podman ps
```
