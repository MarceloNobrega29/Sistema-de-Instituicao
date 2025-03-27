# 📚 Projeto Aluno Online (CRUD)
![Image](https://github.com/user-attachments/assets/69fb8277-904a-4f24-b51f-100573c49eea)
![Image](https://github.com/user-attachments/assets/bd21a889-422b-48ad-9068-ac26a35a7671)

Este repositório contém uma API RESTful para gerenciamento de alunos, desenvolvida em **Spring Boot** com operações CRUD. 
## 🛠 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.4.3**
- **Spring Data JPA**
- **Lombok**
- **PostgreSQL** 
- **Maven** (gerenciamento de dependências)
- **Postman** (testes de API)
- **CloudBeaver** (gerenciamento do banco de dados via docker)

## 📌 Endpoints Implementados

### 🔹 Criar Aluno (`POST /alunos`)
Cria um novo aluno no banco de dados.

### 🔎 Buscar Aluno por ID (GET /alunos/{id})
Retorna um aluno específico pelo ID.

### 🔎 Buscar Aluno pelo Nome 
Retorna alguns alunos especificos pelo Nome.

### ✏️ Atualizar Aluno (PUT /alunos/{id})
Atualiza os dados de um aluno existente.

### 🗑️ Deletar Aluno (DELETE /alunos/{id})
Remove um aluno do sistema.

#### Request (Postman):

**Método:** POST  

**URL:** `http://localhost:8080/alunos`  

**Método:** PUT  

**URL:** `http://localhost:8080/alunos/:id`

**Método:** GET ID

**URL:** `http://localhost:8080/alunos/:id`

**Método:** GET NOME

**URL:** `http://localhost:8080/alunos?nome=`

**Método:** DELETE  

**URL:** `http://localhost:8080/alunos/:id`
#
# 🚀 Como Executar o Projeto

## Pré-requisitos:

- **JDK 17**

- **Maven 3.8+**
  
- **Posteman (Request e JSON)**
  
- **Docker (para o CloudBeaver)**

# Clone o repositório:

- git clone https://github.com/MarceloNobrega29/Sistema-de-Instituicao.git

# Configure o banco de dados:

- Edite src/main/resources/application.properties:

### properties
#### Copy
#### spring.datasource.url=jdbc:postgresql://localhost:5432/postgres_aluno_online_p3b
#### spring.datasource.username=seu-user
#### spring.datasource.password=sua-senha 
