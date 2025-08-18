# ForumHub 🗨️

A **REST API** built with **Spring Boot 3**, designed to manage discussion topics and users.  
This project was developed as part of the [Alura Spring Boot course](https://www.alura.com.br) challenge.

---

## 🚀 Features

- User authentication with **JWT**
- Login endpoint (`/auth/login`)
- Topic management:
  - Create new topics
  - List existing topics
  - Prevent duplicate topics (same title + message)
- API documentation with **Swagger UI**
- Database versioning with **Flyway**

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Security**
- **MySQL 8**
- **Flyway**
- **Swagger (OpenAPI 3)**
- **JWT (jjwt library)**

---

## 📂 Project Structure

src/main/java/com/erickcosta/forumhub/forum
│── ForumApplication.java # Main entry point
│
├── controller # REST Controllers
│ ├── AuthController.java
│ └── TopicoController.java
│
├── domain # Entities
│ ├── topico/Topico.java
│ └── usuario/Usuario.java
│
├── dto # Data Transfer Objects
│ ├── LoginRequest.java
│ ├── LoginResponse.java
│ ├── TopicoRequest.java
│ └── TopicoResponse.java
│
├── infra
│ ├── config/SwaggerConfig.java
│ └── security
│ ├── SecurityConfig.java
│ └── TokenService.java
│
├── repository
│ ├── TopicoRepository.java
│ └── UsuarioRepository.java
│
└── resources
├── application.properties
├── db/migration
│ ├── V1__create_table_topicos.sql
│ ├── V2__alter_table_topicos_add_status.sql
│ ├── V3__update_unique_constraint.sql
│ └── V4__create_table_usuarios.sql
└── static

yaml
Copy
Edit

---

## ⚙️ Requirements

- **Java 17**
- **Maven 3.9+**
- **MySQL 8**

---

## 🔧 Installation & Run

1. Clone the repository:
   ```bash
   git clone https://github.com/ErickTCosta/forumhub.git
   cd forumhub
Configure the database in your .env file:

env
Copy
Edit
DB_URL=jdbc:mysql://localhost:3306/forumhub
DB_USERNAME=your_user
DB_PASSWORD=your_password
JWT_SECRET=your_super_secret_key
Run MySQL and create the database:

sql
Copy
Edit
CREATE DATABASE forumhub CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
Run the application:

bash
Copy
Edit
./mvnw spring-boot:run
Access Swagger UI:

bash
Copy
Edit
http://localhost:8080/swagger-ui/index.html
📖 API Endpoints
🔐 Authentication
POST /auth/login → Returns JWT token

📝 Topics
POST /topicos → Create a new topic

GET /topicos → List all topics

🧑‍💻 Author
Developed by Erick Costa
🔗 LinkedIn
💻 GitHub

yaml
Copy
Edit

---

👉 Esse README já fica **profissional e pronto para o GitHub**.  
Quer que eu faça também a versão em **português**, para deixar no mesmo repositório em `README.pt-BR.md` e ter suporte a duas línguas?








Ask ChatGPT
