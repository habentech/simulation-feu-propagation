# Étape 1: Utilisation d'une image Node.js pour builder l'application
FROM node:18 AS build

# Définir le dossier de travail
WORKDIR /app

# Copier package.json et installer les dépendances
COPY package.json package-lock.json ./
RUN npm install

# Copier le reste du projet et builder l'application
COPY . .
RUN npm run build

# Étape 2: Utilisation d'une image Nginx pour servir l'application
FROM nginx:alpine

# Copier les fichiers buildés dans Nginx
COPY --from=build /app/build /usr/share/nginx/html

# Exposer le port 80
EXPOSE 80

# Lancer Nginx
CMD ["nginx", "-g", "daemon off;"]
