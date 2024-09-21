
# Essia Arquivos REST API

## Visão geral

A API de gerenciamento de diretórios e arquivos *Essia Arquivos REST API* foi desenvolvida utilizando a **arquitetura hexagonal (ports and adapters)**,  garantindo flexibilidade, separação de responsabilidades, desacoplamento e facilidade de manutenção. Com essa abordagem, o núcleo da aplicação permanece isolado dos detalhes de banco de dados e infraestrutura, facilitando mudanças de tecnologias no futuro.  
A API também segue os **princípios do padrão** RESTful, fornecendo uma interface simples e intuitiva para a manipulação dos diretórios e arquivos.  Para facilitar o uso e a integração da API por outros desenvolvedores e outros sistemas, foi utilizada a documentação via **Swagger**.

## Versões
- Java: (OpenJDK-17)
- Spring Boot: 2.5.6
- JUnit: 5.9.0

## Configurações do banco de dados
| Variável de ambiente | Descrição              | Exemplo                                  |  
|----------------------|------------------------|------------------------------------------|  
| DATABASE_URL         | Host do banco do dados | jdbc:postgresql://localhost:5432/posgres |  
| DATABASE_USERNAME    | Username               | postgres                                 |  
| DATABASE_PASSWORD    | Password               | postgres                                 |