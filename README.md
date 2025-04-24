RecordLog-Back

Back-end du projet RecordLog, une bibliothèque musicale en ligne permettant la gestion d’albums, artistes et utilisateurs.
Base de données

    Le projet utilise une base de données PostgreSQL exécutée dans un conteneur Docker.

    L'administration de la base de données a été effectué avec DBeaver.

Authentification Keycloak

    Une authentification centralisée a été mise en place grâce à Keycloak, accessible via le port 8082.

    Un realm spécifique au projet a été configuré, avec un seul utilisateur autorisé pour les tests.

    L’authentification protège l’accès aux ressources sensibles du back-end.
<p align="center">
  <img src="https://github.com/user-attachments/assets/6921a09a-a75f-4b5c-ab78-1911ae3f3194" />
</p>

Accès aux logs

    L’application est connectée à une stack ELK (Elasticsearch – Logstash – Kibana) pour la visualisation des logs.

    Interface de visualisation disponible à l’adresse : http://localhost:8081

    Pour consulter les logs du back-end :

        Ouvrir Kibana

        Naviguer dans l’onglet Discover

        Sélectionner les index liés à l’application
  <p align="center">
    <img src="https://github.com/user-attachments/assets/c5d8e42f-fa9a-48ce-ad08-fdc1d8b44837" />
  </p>
