# 🚗 AutoManager API

API REST desenvolvida com Spring Boot para gerenciamento de clientes, documentos, endereços e telefones.

## 📌 Proposta da Atividade

O projeto tem como objetivo desenvolver uma API seguindo boas práticas de desenvolvimento backend, incluindo:

* Arquitetura em camadas (Controller, Service, Repository)
* Uso de DTOs para entrada de dados
* Validação com Bean Validation
* Tratamento global de exceções
* Relacionamentos entre entidades (JPA/Hibernate)

---

## 🧱 Estrutura do Projeto

* **controles** → Controllers (rotas da API)
* **service** → Regras de negócio
* **repositorios** → Acesso ao banco de dados
* **entidades** → Modelos JPA
* **dto** → Objetos de transferência de dados
* **exception** → Tratamento global de erros

---

## ⚙️ Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven
* MySQL (ou outro banco relacional)

---

## ▶️ Como Rodar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/HenryTito/AV1-WEB3.git
```

### 2. Configurar o banco de dados

Vá até:

```
src/main/resources/application.properties
```

Altere conforme seu banco (ele criará um automaticamente se não existir, basta apenas alterar a senha):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
```

---

### 3. Rodar a aplicação

#### ▶️ Como rodar

✔ Pela IDE (recomendado VS Code)
- Execute a classe AutomanagerApplication

✔ Pelo terminal (caso tenha Maven instalado)
mvn spring-boot:run

---

## 🌐 Endpoints Principais

### 👤 Cliente

| Método | Rota          |
| ------ | ------------- |
| POST   | /cliente      |
| GET    | /cliente      |
| GET    | /cliente/{id} |
| PUT    | /cliente/{id} |
| DELETE | /cliente/{id} |

---

### 📄 Documento

| Método | Rota                    |
| ------ | ----------------------- |
| POST   | /documentos/{clienteId} |
| GET    | /documentos/{id}        |
| PUT    | /documentos/{id}        |
| DELETE | /documentos/{id}        |

---

### 📍 Endereço (Endereço é OneToOne, e só pode ser atualizado. Logo, não existe sem cliente e SEMPRE pertence a um cliente)

| Método | Rota                   |
| ------ | ---------------------- |
| PUT    | /enderecos/{clienteId} |

---

### 📞 Telefone

| Método | Rota                   |
| ------ | ---------------------- |
| POST   | /telefones/{clienteId} |
| GET    | /telefones             |
| GET    | /telefones/{id}        |
| PUT    | /telefones/{id}        |
| DELETE | /telefones/{id}        |

---

## 📥 Exemplo de JSON (Cliente Completo)

```json
{
  "nome": "Henry",
  "nomeSocial": "Tito",
  "dataNascimento": "2000-01-01",
  "documentos": [
    {
      "tipo": "CPF",
      "numero": "12345678900"
    }
  ],
  "endereco": {
    "estado": "SP",
    "cidade": "São José dos Campos",
    "bairro": "Centro",
    "rua": "Rua A",
    "numero": "123",
    "codigoPostal": "12200000",
    "informacoesAdicionais": "Casa azul"
  },
  "telefones": [
    {
      "ddd": "12",
      "numero": "999999999"
    }
  ]
}
```

---
## 🔄 Formas de Cadastro de Dados

Você pode utilizar a API de duas formas:

### 1. Cadastro completo em uma única requisição

É possível criar um cliente já com:

documentos
endereço
telefones

Tudo direto na rota:

POST /cliente

Isso facilita quando você já possui todos os dados disponíveis.

---

###  2. Cadastro progressivo (recomendado para testes)

Você também pode:

Criar o cliente apenas com os dados básicos:

POST /cliente

Depois adicionar os dados separadamente:

📄 Documento → POST /documentos/{clienteId}

📍 Endereço → PUT /enderecos/{clienteId}

📞 Telefone → POST /telefones/{clienteId}

---

## ⚠️ Validação

Os campos são validados automaticamente. Exemplo:

* `tipo` do documento → obrigatório
* `numero` → obrigatório

Erros retornam no formato:

```json
{
  "campo": "mensagem de erro"
}
```

---

## 💥 Tratamento de Erros

A API possui um **GlobalExceptionHandler** que captura exceções e retorna respostas padronizadas.

Exemplo:

```json
{
  "Erro": "Cliente não encontrado"
}
```

---


## 📌 Observações

* A data de cadastro do cliente é gerada automaticamente no momento da criação
* O formato da data segue o padrão brasileiro (`dd/MM/yyyy HH:mm`)
* O projeto está estruturado para fácil evolução para microserviços

---

## 👨‍💻 Autor

Desenvolvido por **Henry Tito**
