# API_conversion_devises
Cette API permet de convertir une somme d'argent d’une devise à une autre en utilisant des taux de change récupérés dynamiquement. Elle fait appel à l'API externe "Exchangerate-API" pour obtenir les taux de change. Elle est développée avec Spring Boot 3.3.12 et documentée grâce à Swagger/OpenAPI.

✅ Prérequis: • IDE recommandé : IntelliJ IDEA • Outils de test : Swagger UI ou Postman (optionnel) • Environnement : JDK 21 et Maven

🚀 Lancement du projet: 1. Cloner le dépôt : git clone https://github.com/jiofacktsapze/API_conversion_devises 2. Ajouter les propriétés dans application.properties : Exemple : exchangerate.api.key=VOTRE_CLE_API
exchangerate.api.url=https://v6.exchangerate-api.com/v6 3. Lancer l’application : ./mvnw spring-boot:run L’application sera disponible à l’adresse : ➤ http://localhost:8080

📚 Documentation Swagger: Une fois l’application démarrée, la documentation Swagger est disponible à : 👉 http://localhost:8080/swagger-ui.html Ou (si redirigé automatiquement) : 👉 http://localhost:8080/swagger-ui/index.html 

📦 Points de terminaison disponibles:
✅ Convertir une somme d'une devise à une autre
GET /api/convert
