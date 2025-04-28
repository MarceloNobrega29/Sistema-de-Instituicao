# 📚 Projeto Aluno Online (CRUD - Create)


![Image](https://github.com/user-attachments/assets/8dfe8548-c825-4cf1-9ec2-78d09f12a740)
![Image](https://github.com/user-attachments/assets/45d0700a-2e23-4285-93f5-ef55b55048b5)
![Image](https://github.com/user-attachments/assets/ef50bd64-99c4-44e2-82ee-c19c7c95c600)
![Image](https://github.com/user-attachments/assets/344aa25b-9a71-4e49-a3fc-787af2a60825)
![Image](https://github.com/user-attachments/assets/cc9f4448-cc09-4426-a520-46ea5251f9e3)
![Image](https://github.com/user-attachments/assets/be1d97d7-f7e3-4b2e-926e-8f89f9ddd4d7)

Este repositório contém uma API RESTful para gerenciamento de alunos, desenvolvida em **Spring Boot** com operações CRUD. Nesta versão, está implementado o endpoint de criação de alunos (`createAluno`).

## 🛠 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL** (ou outro banco de dados configurável)
- **Maven** (gerenciamento de dependências)
- **Insomnia/Postman** (testes de API)
- **CloudBeaver** (gerenciamento do banco de dados)

## 📌 Endpoints Implementados

### 🔹 Criar Aluno (`POST /alunos`)
Cria um novo alunoModel no banco de dados.

### 🔎 Buscar Aluno por ID (GET /alunos/{id})
Retorna um alunoModel específico pelo ID.

### ✏️ Atualizar Aluno (PUT /alunos/{id})
Atualiza os dados de um alunoModel existente.

### 🗑️ Deletar Aluno (DELETE /alunos/{id})
Remove um alunoModel do sistema.

#### Request (Postman):

**Método:** POST  
**URL:** `http://localhost:8080/alunos`  

**Método:** PUT  
**URL:** `http://localhost:8080/alunos/:id`

**Método:** GET  
**URL:** `http://localhost:8080/alunos/:id`

**Método:** DELETE  
**URL:** `http://localhost:8080/alunos/:id`

# 🚀 Como Executar o Projeto

## Pré-requisitos:

- **JDK 17**

- **Maven 3.8+**

- **Docker (para o CloudBeaver)**

# Clone o repositório:

- git clone https://github.com/seu-usuario/alunoModel-online.git

# Configure o banco de dados:

- Edite src/main/resources/application.properties:

### properties
#### Copy
#### spring.datasource.url=jdbc:postgresql://localhost:5432/postgres_aluno_online_p3b
#### spring.datasource.username=seu-user
#### spring.datasource.password=sua-senha 
