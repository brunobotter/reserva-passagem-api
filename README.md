# Projeto de API REST de Reserva de Passagens 

## O projeto consiste em reservar ou cancelar passagens em um determinado onibus.

## Funcionalidades

- Cadastro de cliente
- Cadastro de funcionarios
- Cadastro de cidades
- Cadastro de ônibus
- Reservar passagem
- Cancelamento de passagem
- Login com CPF e Senha

## Tecnologias utilizadas

- Spring boot
- Spring Data Jpa
- Spring Security
- JJWT
- MYSQL
- hibernate-validator
- spring-context-support
- spring-boot-starter-mail

## Executar a aplicação

Primeiro é necessário iniciar seu banco de dados MySQL. É necessário criar as tabelas do banco. A API faz isso para você se na primeira execução você utilizar a seguinte propriedade spring.jpa.hibernate.ddl-auto=create a base é denominada 'reserva' e o banco por padrão é criado desde que o MYSQL tenha sido inicializado, os seguintes dados são utilizados:

### application.properties

```json
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/reserva?useTimezone=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=171191
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
spring.jpa.show-sql=false
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.protocol=smtp
spring.mail.username=<SEU EMAIL>
spring.mail.password=<SUA SENHA>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.quitwait=false 
```
## Funcionalidade do projeto
E necessario inserir o usuario admin diretamente no banco de dados.

## OBSERVAÇÂO: E necessario inserir o token ao header para as requisições.

## Endpoints

## Autorização

### Post
### http://localhost:8080/auth/login
### Gera o token para para adicionar ao header

## Usuario

### Get
### http://localhost:8080/api/usuario/id
### Role FUNCIONARIO ou ADMIN
### Busca um usuario por id

### Get
### http://localhost:8080/api/usuario
### Role FUNCIONARIO ou ADMIN
### Busca todos os usuario

### Delete
### http://localhost:8080/api/usuario/id
### Role ADMIN
### Deleta um usuario por id

### Post
### http://localhost:8080/api/usuario/adicionar_cliente
### Adiciona um usuario do tipo cliente

### Post
### http://localhost:8080/api/usuario/adicionar_funcionario
### Role ADMIN
### Adiciona um usuario do tipo Funcionario

### Put
### http://localhost:8080/api/usuario/id
### Role CLIENTE
### Atualiza um usuario por id

## Cidades

### GET
### http://localhost:8080/api/cidades/id
### Role ADMIN ou FUNCIONARIO
### Consulta uma cidade por id

### GET
### http://localhost:8080/api/cidades/
### Role ADMIN ou FUNCIONARIO
### lista todas as cidades

### DELETE
### http://localhost:8080/api/cidades/id
### Role ADMIN
### Deleta uma cidade

### POST
### http://localhost:8080/api/cidades/
### Role ADMIN ou FUNCIONARIO
### Adiciona uma cidade

### PUT
### http://localhost:8080/api/cidades/id
### Role ADMIN ou FUNCIONARIO
### Atualiza uma cidade

## Onibus

### GET
### http://localhost:8080/api/onibus/id
### Role ADMIN ou FUNCIONARIO
### Consulta um onibus por id

### GET
### http://localhost:8080/api/onibus/
### Role ADMIN ou FUNCIONARIO
### lista todos os onibus

### DELETE
### http://localhost:8080/api/onibus/id
### Role ADMIN 
### Deleta um onibus por id

### POST
### http://localhost:8080/api/onibus/id
### Role ADMIN ou FUNCIONARIO
### Adiciona um onibus

### PUT
### http://localhost:8080/api/onibus/id
### Role ADMIN ou FUNCIONARIO
### Atualiza um onibus por id

## Passagem

### GET
### http://localhost:8080/api/passagem/id
### Consulta uma passsagem por id

### GET
### http://localhost:8080/api/passagem/
### Role ADMIN ou FUNCIONARIO
### Lista todas as passagens

### POST
### http://localhost:8080/api/passagem/
### Role CLIENTE
### Reserva uma passagem

## Cancelamento

### GET
### http://localhost:8080/api/cancelamento/id
### Consulta cancelamento por Id

### GET
### http://localhost:8080/api/cancelamento/
### Role ADMIN ou FUNCIONARIO
### Lista todas os cancelamentos

### POST
### http://localhost:8080/api/cancelamento/
### Role ADMIN ou CLIENTE
### Cancelar uma passagem




