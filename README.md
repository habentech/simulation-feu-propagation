# Simulation de Propagation de Feu

Ce projet est une simulation de la propagation du feu dans une forêt, développé avec un backend en **Spring Boot** et un frontend en **React**. Il permet d'initialiser une grille représentant la forêt, 
de simuler la propagation du feu au fil du temps et de visualiser les états successifs de la simulation.

---

## 📁 Structure du projet

```
/simulation-feu-propagation
│── backend/       # Backend Spring Boot
│── frontend/      # Frontend React
│── README.md
```

## 🚀 Prérequis

Avant de lancer le projet, assurez-vous d'avoir installé :
- [Docker](https://www.docker.com/)
- [Git](https://git-scm.com/)
- [Node.js & npm](https://nodejs.org/)
- [Java 17](https://adoptium.net/)

---

## ⚙️ Installation & Exécution

### 1️⃣ Cloner le projet
```sh
git clone https://github.com/habentech/simulation-feu-propagation.git
cd simulation-feu-propagation
```

### 2️⃣ Démarrer le backend (Spring Boot)
```sh
cd backend
mvn clean package
java -jar target/forest-fire-simulation-0.0.1-SNAPSHOT.jar
```

### 3️⃣ Démarrer le frontend (React)
```sh
cd frontend
npm install
npm start
```

### 4️⃣ Accéder à l'application
- **Backend API** : `http://localhost:8080`
- **Frontend** : `http://localhost:3000`

---
# 🔥 Simulation de Propagation de Feu

Ce projet simule la propagation d'un feu de forêt avec un **frontend React** et un **backend Spring Boot**, tous deux dockerisés.

## 📌 Prérequis

Avant de commencer, assurez-vous d'avoir installé :
- [Docker](https://www.docker.com/) (pour exécuter avec des conteneurs)

## 🚀 Exécution avec Docker Hub

Les images Docker sont disponibles sur Docker Hub :

### 1️⃣ Récupérer les images Docker
```sh
docker pull hanineben/forest-fire-backend
docker pull hanineben/forest-fire-frontend
```

### 2️⃣ Lancer les conteneurs
#### Backend (Spring Boot)
```sh
docker run -d -p 8080:8080 --name backend-container hanineben/forest-fire-backend
```
➡️ **Le backend est accessible sur** `http://localhost:8080`

#### Frontend (React)
```sh
docker run -d -p 3000:80 --name frontend-container hanineben/forest-fire-frontend
```
➡️ **Le frontend est accessible sur** `http://localhost:3000`

## 📂 Structure du projet
```plaintext
📦 simulation-feu-propagation
 ┣ 📂 frontend (React)
 ┃ ┣ 📜 src/
 ┃ ┣ 📜 public/
 ┃ ┣ 📜 package.json
 ┃ ┣ 📜 package.json
 ┃ ┗ 📜 Dockerfile
 ┣ 📂 backend (Spring Boot)
 ┃ ┣ 📜 src/
 ┃ ┣ 📜 Dockerfile
 ┗ 📜 README.md
```

---

## 📌 API Endpoints

### Backend (Spring Boot)
| Méthode  | Endpoint              | Description                          |
|----------|----------------------|----------------------------------|
| `POST`   | `/simulation/initialize` | Initialise la simulation          |
| `POST`   | `/simulation/step`    | Exécute une étape de la simulation |
| `GET`    | `/simulation/status`  | Vérifie si la simulation est terminée |
| `GET`    | `/simulation/grid`    | Récupère l'état actuel de la grille |

---

## ✨ Fonctionnalités
✅ Initialisation d'une grille de forêt
✅ Propagation du feu au fil du temps
✅ Visualisation interactive avec React
✅ Conteneurisation avec Docker

---

## 📜 Licence
Ce projet est sous licence MIT.

---

🎯 *Développé avec passion par HanineBen.* 🚀

