# 📚 Sistema de Gestão Acadêmica - API REST

API REST desenvolvida com **Spring Boot**, responsável por gerenciar Professores, Alunos, Disciplinas e Matrículas em um sistema acadêmico.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Swagger
- Maven
- Insomnia/Postman
- CloudBeaver

---

## 📌 Principais Funcionalidades

- Cadastro e gerenciamento de **professores**, **alunos** e **disciplinas**
- Controle de **matrículas**, incluindo trancamento e atualização de notas
- Emissão de **histórico escolar**
- Documentação automática da API com **Swagger**

---

## 📡 Testando a API

- **Importe a collection no Insomnia:** 
[insomnia_collection](../../../../Downloads/insomnia_collection)
- **Importe a collection no Postman:**
  [postman_collection.json](postman_collection.json)

---

## 🧩 Endpoints Principais

### 👨‍🏫 Professores

| Método | Endpoint                    | Descrição                         |
|--------|-----------------------------|-----------------------------------|
| GET    | `/professores`             | Listar todos os professores       |
| GET    | `/professores/{id}`        | Buscar professor por ID           |
| POST   | `/professores`             | Cadastrar novo professor          |
| PUT    | `/professores/{id}`        | Atualizar dados do professor      |
| DELETE | `/professores/{id}`        | Remover professor                 |

### 📘 Disciplinas

| Método | Endpoint                             | Descrição                                |
|--------|--------------------------------------|------------------------------------------|
| GET    | `/disciplinas`                      | Listar todas as disciplinas              |
| GET    | `/disciplinas/{id}`                 | Buscar disciplina por ID                 |
| GET    | `/disciplinas/professor/{id}`       | Disciplinas associadas a um professor    |
| POST   | `/disciplinas`                      | Criar nova disciplina                    |
| PUT    | `/disciplinas/{id}`                 | Atualizar disciplina                     |
| DELETE | `/disciplinas/{id}`                 | Excluir disciplina                       |

### 🎓 Alunos

| Método | Endpoint               | Descrição                    |
|--------|------------------------|------------------------------|
| GET    | `/alunos`             | Listar todos os alunos       |
| GET    | `/alunos/{id}`        | Buscar aluno por ID          |
| POST   | `/alunos`             | Cadastrar novo aluno         |
| PUT    | `/alunos/{id}`        | Atualizar aluno              |
| DELETE | `/alunos/{id}`        | Remover aluno                |

### 📝 Matrículas

| Método | Endpoint                                 | Descrição                          |
|--------|------------------------------------------|------------------------------------|
| POST   | `/matriculas`                           | Criar matrícula                    |
| PATCH  | `/matriculas/trancar/{id}`              | Trancar matrícula                  |
| PATCH  | `/matriculas/atualizar-notas/{id}`      | Atualizar notas                    |
| GET    | `/matriculas/emitir-historico/{id}`     | Emitir histórico do aluno          |

---

## 📦 Estrutura de Dados (Modelos)

- **ProfessorModel**: `id`, `nome`, `cpf`, `email`
- **AlunoModel**: `id`, `nome`, `cpf`, `email`
- **DisciplinaModel**: `id`, `nome`, `cargaHoraria`, `professor`
- **MatriculaAlunoModel**: `id`, `nota1`, `nota2`, `status`, `disciplina`, `aluno`

---

## 💾 Backup do Banco de Dados

**Este projeto inclui um arquivo de backup do banco de dados PostgreSQL chamado `backup_postgres_aluno_online_p3b.sql`, que contém:**

- 🏗️ Criação das tabelas
- 📥 Inserção dos dados iniciais
- 🔑 Chaves primárias e estrangeiras
- 🔄 Sequências para IDs auto incrementais

### 🚀 Como restaurar o banco de dados

**Para importar o banco de dados usando o arquivo de backup, siga estes passos:**

- ✅ Certifique-se que o PostgreSQL está rodando e você tem um banco vazio com o nome `postgres_aluno_online_p3b`.
- 🖥️ Execute o comando (no terminal ou via ferramenta de administração como CloudBeaver):

```bash
psql -U postgres -d postgres_aluno_online_p3b -f backup_postgres_aluno_online_p3b.sql
```
---

## 🧪 Documentação

A documentação da API está disponível via **Swagger UI** ao rodar o projeto:

http://localhost:8080/swagger-ui/index.html


---

## MIT License - Copyright (c) 2025 Marcelo Nóbrega