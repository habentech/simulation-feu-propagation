# Utilise l'image officielle OpenJDK pour Java 17
FROM openjdk:17-jdk-slim

# Définit le répertoire de travail dans le conteneur
WORKDIR /app

# Copie le fichier JAR généré dans le conteneur
COPY target/forest-fire-simulation-0.0.1-SNAPSHOT.jar app.jar

# Expose le port de l'application Spring Boot
EXPOSE 8080

# Commande pour exécuter l'application
CMD ["java", "-jar", "app.jar"]
