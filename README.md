# 📚 Projeto Aluno Online (CRUD)

![Image](https://github.com/user-attachments/assets/8485df5e-37fa-40d4-ae24-c4668d9ec443)

![Image](https://github.com/user-attachments/assets/6add6363-5967-4c3a-8eb8-79c76c4ae446)

![Image](https://github.com/user-attachments/assets/5cfd4e39-a71a-4203-b4bb-33459a192c48)



Este repositório contém uma API RESTful para gerenciamento de alunos, desenvolvida em **Spring Boot** com operações CRUD.

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
