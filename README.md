### 📦 Inventário - Sistema com Docker (Java + React + MySQL)

Este projeto é composto por três serviços:
- 🧠 **Back-end**: Java + Spring Boot
- 🌐 **Front-end**: React (Vite)
- 🐬 **Banco de dados**: MySQL

Tudo empacotado com **Docker** via `docker-compose`.

---

### 🚀 Como rodar o projeto

#### 1. Clone ou baixe este repositório

```bash
git clone https://github.com/seu-usuario/inventario.git
cd inventario
```

#### 2. Estrutura esperada

```
inventario/
├── backend/               # Projeto Java (com pom.xml)
├── frontend/              # Projeto React (com package.json)
├── mysql/                 # Pasta opcional para dados do MySQL
├── docker-compose.yml     # Orquestrador
```

#### 3. Iniciar os containers

```bash
docker-compose up --build
```

> Na primeira vez pode demorar um pouco enquanto as imagens são baixadas e os projetos compilados.

---

### 🌐 Acessos

- **Front-end**: [http://localhost:5173](http://localhost:5173)  
- **Back-end (API)**: [http://localhost:8080/inventario](http://localhost:8080/inventario)  
- **MySQL**:
  - Host: `localhost`
  - Porta: `3306`
  - Usuário: `root`
  - Senha: `root`
  - Banco: `inventario`

---

### 🐓 Parar os containers

```bash
docker-compose down
```

---

### 🗃 Requisitos

- Docker
- Docker Compose
