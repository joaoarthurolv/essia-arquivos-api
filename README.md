
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
Para rodar o projeto, é necessário ter o ```docker``` e o ```docker-compose``` instalados. Com isso, basta criar dois arquivos do tipo ```.env```,
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
Com estes arquivos configurados, basta abrir o terminal na raiz do projeto e rodar o comando ```docker-compose up```.  
Os endpoints vão estar disponíveis na porta 8081 e serão visíveis no [Swagger](http://localhost:8081/swagger-ui/). 