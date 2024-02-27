# API Agrix 
Foi desenvolvido uma API em Java que utiliza Spring Boot, Spring Web, Spring Security e Sprint Data JPA com integra a um bando de dados SQL
e gerencia fazendas e plantações. Na aplicação você cria um usuário com "username", "password", "role" que é persistido no banco de dados e 
encripitado pelo JWT efetua o login e dependendo da seu nível definido em "role" tem acesso a um CRUD onde você pode adicionar, remover, editar
ou deletar fazendas e suas devidas plantações. A aplicação utiliza do sistema de integração contínua para otimização dos testes e maior segurança do código.

## Tecnologias Utilizadas:
- Docker;
- MySQL;
- Postgres(Deploy no fly.io)
- Spring Framework
- JUnit;
- Continuous Integration, Continuous Delivery (CI/CD) com GitHub actions

  >Nota: Na branch "deploy" algumas configurações estão diferentes em application.properties e nos arquivos Docker devido à necessidade de adaptar a aplicação
  para utilizar o Postgres, pois a plataforma Fly.io não tem suporte para MySQL.

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
