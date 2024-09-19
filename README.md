# Essia Arquivos REST API

## Visão geral

Esta é uma REST API criada para consumir os dados do banco de arquivos. Com essa API nós conseguiremos
coletar e mostrar os dados do de diretórios e arquivos para os usuários.

### Versões
- Java: (OpenJDK-17)
- Spring Boot: 2.5.6
- JUnit: 5.9.0

### Configurações do banco de dados
| Variável de ambiente | Descrição              | Exemplo                                  |
|----------------------|------------------------|------------------------------------------|
| DATABASE_URL         | Host do banco do dados | jdbc:postgresql://localhost:5432/posgres |
| DATABASE_USERNAME    | Username               | postgres                                 |
| DATABASE_PASSWORD    | Password               | postgres                                 |