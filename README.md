# 📚 Projeto Aluno Online (CRUD - Create)

![Image](https://github.com/user-attachments/assets/cfcec220-e37c-4cac-9da2-dd52a9e646d0)
![Image](https://github.com/user-attachments/assets/f03b60ba-f73d-4a46-bede-140af010d072)
![Image](https://github.com/user-attachments/assets/d8345046-acca-4431-a181-04172f61658f)
![Image](https://github.com/user-attachments/assets/644a246e-c32d-4eb2-89f1-6d3c05f9e67c)


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
