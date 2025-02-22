# 🔥 Simulation de Propagation de Feu

Ce projet simule la propagation d'un feu de forêt à l'aide d'un **frontend React** et d'un **backend** (préciser la technologie du backend ici).

## 📌 Prérequis

Avant de commencer, assurez-vous d'avoir installé :
- [Node.js](https://nodejs.org/) (pour le frontend)
- [Docker](https://www.docker.com/) (pour exécuter avec des conteneurs)
- Backend dépendant de la technologie utilisée (ex: Java, Python, Node.js...)

---

## 🚀 Installation et exécution sans Docker

### 1️⃣ Cloner le projet
```sh
git clone https://github.com/hanineben/simulation-feu.git
cd simulation-feu
```

### 2️⃣ Lancer le backend

*(Si le backend est en Node.js, Spring Boot ou autre, ajoutez les étapes spécifiques ici.)*

### 3️⃣ Lancer le frontend
```sh
cd frontend
npm install  # Installer les dépendances
npm start    # Lancer l'application
```
➡️ **L'application sera disponible sur** `http://localhost:3000`

---

## 🐳 Exécution avec Docker

### 1️⃣ Construire et exécuter le **backend** avec Docker
*(Ajoutez ici les étapes pour dockeriser votre backend en fonction de sa technologie.)*

### 2️⃣ Construire et exécuter le **frontend** avec Docker

```sh
cd frontend
# Construire l'image Docker
docker build -t forest-simulation-frontend .

# Lancer le conteneur
docker run -d -p 3000:80 --name frontend-container forest-simulation-frontend
```
➡️ **L'application sera accessible sur** `http://localhost:3000`

---

## 📂 Structure du projet
```plaintext
📦 simulation-feu
 ┣ 📂 frontend (React)
 ┃ ┣ 📜 src/
 ┃ ┣ 📜 public/
 ┃ ┣ 📜 package.json
 ┃ ┗ 📜 Dockerfile
 ┣ 📂 backend (votre techno ici)
 ┃ ┣ 📜 src/
 ┃ ┣ 📜 Dockerfile
 ┗ 📜 README.md
```

## ✅ Améliorations futures
- [ ] Ajouter une interface plus interactive
- [ ] Optimiser les performances du backend

