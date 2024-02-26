# API Agrix 
Foi desenvolvido uma API em Java que utiliza Spring Boot, Spring Web, Spring Security e Sprint Data JPA com integra a um bando de dados SQL
e gerencia fazendas e plantações. Na aplicação você cria um usuário com "username", "password", "role" que é persistido no banco de dados e 
encripitado pelo JWT efetua o login e dependendo da seu nível definido em "role" tem acesso a um CRUD onde você pode adicionar, remover, editar
ou deletar fazendas e suas devidas plantações.

## Tecnologias Utilizadas:
- Docker;
- MySQL;
- Spring Framework
- JUnit;
- GitHub Actions

## Comandos Úteis
Para rodar a aplicação em sua máquina clone o repositório:
```
bash
git clone git@github.com:nelsonhamada/java-spring-api-agrix.git
```

Entre no diretório clonado e instale as dependências:
```
cd java-spring-api-agrix
mvn install
```

Suba o container Docker:
```
docker-compose up -- build
```

Execute o arquivo AgrixAplication.java através de sua IDE.
A aplicação estará na porta 8080;
O Banco de dados estará na porta 3306;

>Nota: É necessário ter o Docker instalado em sua máquina e que as portas estejam livres para que ele consiga subir a aplicação
