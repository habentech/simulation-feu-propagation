# 🔥 Backend - Simulation de Propagation de Feu

Ce projet représente le backend d'une simulation de propagation de feu de forêt, développé avec **Spring Boot**.

## 📌 Prérequis

Avant de commencer, assurez-vous d'avoir installé :
- [Java 17](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/) (si vous souhaitez exécuter avec des conteneurs)

---

## 🚀 Installation et exécution sans Docker

### 1️⃣ Cloner le projet
```sh
git clone https://github.com/hanineben/forest-fire-simulation-backend.git
cd forest-fire-simulation-backend
```

### 2️⃣ Construire et exécuter l'application
```sh
mvn clean package
java -jar target/forest-fire-simulation-0.0.1-SNAPSHOT.jar
```
➡️ **Le serveur sera disponible sur** `http://localhost:8080`

---

## 🐳 Exécution avec Docker

### 1️⃣ Construire l’image Docker
```sh
docker build -t hanineben/forest-fire-backend .
```

### 2️⃣ Lancer le conteneur
```sh
docker run -d -p 8080:8080 --name backend-container hanineben/forest-fire-backend
```
➡️ **L'API sera accessible sur** `http://localhost:8080`

---

## 🛠 API Endpoints

| Méthode | Endpoint             | Description |
|---------|----------------------|-------------|
| `POST`  | `/simulation/initialize` | Initialise la simulation |
| `POST`  | `/simulation/step`       | Exécute une étape de simulation |
| `GET`   | `/simulation/status`     | Vérifie si la simulation est terminée |
| `GET`   | `/simulation/grid`       | Récupère l'état actuel de la grille |

---

## ✅ Améliorations futures
- [ ] Intégrer une base de données pour stocker l'historique des simulations
- [ ] Ajouter un système de configuration dynamique des paramètres de simulation


