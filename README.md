# 📚 Projeto Aluno Online (CRUD - Create)
![Image](https://github.com/user-attachments/assets/69fb8277-904a-4f24-b51f-100573c49eea)
![Image](https://github.com/user-attachments/assets/bd21a889-422b-48ad-9068-ac26a35a7671)

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
Cria um novo aluno no banco de dados.

### 🔎 Buscar Aluno por ID (GET /alunos/{id})
Retorna um aluno específico pelo ID.

### ✏️ Atualizar Aluno (PUT /alunos/{id})
Atualiza os dados de um aluno existente.

### 🗑️ Deletar Aluno (DELETE /alunos/{id})
Remove um aluno do sistema.

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

- git clone https://github.com/seu-usuario/aluno-online.git

# Configure o banco de dados:

- Edite src/main/resources/application.properties:

### properties
#### Copy
#### spring.datasource.url=jdbc:postgresql://localhost:5432/postgres_aluno_online_p3b
#### spring.datasource.username=seu-user
#### spring.datasource.password=sua-senha 
