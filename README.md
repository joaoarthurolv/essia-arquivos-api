# Essia Arquivos REST API

## Visão geral

A API de gerenciamento de diretórios e arquivos *Essia Arquivos REST API* foi desenvolvida utilizando a **arquitetura hexagonal (ports and adapters)**, garantindo flexibilidade, 
separação de responsabilidades, desacoplamento e facilidade de manutenção. Com essa abordagem, o núcleo da aplicação permanece isolado dos detalhes de banco de dados e infraestrutura, facilitando mudanças de tecnologias no futuro.   
A API também segue os **princípios do padrão** RESTful, fornecendo uma interface simples e intuitiva para a manipulação dos diretórios e arquivos.  
Para facilitar o uso e a integração da API por outros desenvolvedores e outros sistemas, foi utilizada a documentação via **Swagger**.

## Versões
- Java: (OpenJDK-17)
- Spring Boot: 2.5.6
- JUnit: 5.9.0

## Como rodar o projeto 
Como este projeto depende de um banco de dados, ele possui dois containers. Um container para o banco de dados e um container para a API Rest em si.  
Para rodar o projeto, é necessário ter o ```maven```, o ```docker``` e o ```docker-compose``` instalados. Com isso, basta criar dois arquivos do tipo ```.env``` na raiz do projeto,
um arquivo para as variáveis de ambiente do container do banco de dados e um arquivo para as variáveis de ambiente do container da aplicação. 
Note que, no arquivo ```docker-compose.yml```, há a referência para estes arquivos com seus nomes.  
Caso deseje utilizar outro nome para os arquivos, lembre-se de mudar no arquivo ```docker-compose.yml``` também.  

Aqui está um exemplo do arquivo ```docker-variables-db.env```: 
```
POSTGRES_USER=root
POSTGRES_PASSWORD=root
POSTGRES_DB=postgres
```
Exemplo do arquivo ```docker-variables-spring-application.env```:
```
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/postgres
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=root
SPRING_JPA_HIBERNATE_DDL_AUTO=update
```  
Com estes arquivos configurados, é necessário seguir a documentação do projeto Angular disponível [aqui](https://github.com/joaoarthurolv/essia-arquivos-angular). Depois, é só retornar e seguir os seguintes passos:
 1. Abrir o terminal na raiz do projeto  
 2. Rodar o comando ```mvn package -DskipTests``` para criar o arquivo ```.jar``` da aplicação  
 3. Rodar o comando ```docker-compose up```.  

Os endpoints vão estar disponíveis na porta 8081 e serão visíveis no [Swagger](http://localhost:8081/swagger-ui/).  
A aplicação será visível na seguinte [página](http://localhost:4200/diretorios).