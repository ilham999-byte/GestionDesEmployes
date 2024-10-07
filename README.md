# GestionDesEmployes
Projet de Gestion des Employés

## Description

Ce projet implémente un système de gestion des employés d'une petite entreprise. La hiérarchie des employés est structurée comme suit :
- **Directeur Général**
  - **Manager**
    - **Développeur 1**
    - **Développeur 2**
  - **Développeur 3**

Le projet utilise Java et JDBC pour gérer la connexion à une base de données MySQL et effectuer des opérations CRUD (Créer, Lire, Mettre à jour, Supprimer).

## Technologies Utilisées
- Java
- JDBC
- MySQL
- Swing (pour l'interface graphique)

## Configuration de la Base de Données


### Fichier de Configuration
Créez un fichier `base.properties` dans la racine du projet avec le contenu suivant :

jdbc.driver=com.mysql.jdbc.Driver jdbc.url=jdbc:mysql://localhost/entreprise jdbc.username=root jdbc.password=root

shell
Copier le code

## Structure du Projet

ma.projet │ ├── connexion │ └── Connexion.java │ ├── beans │ ├── Personne.java │ ├── Manager.java │ └── Developpeur.java │ ├── dao │ └── IDao.java │ ├── service │ ├── ManagerService.java │ └── DeveloppeurService.java │ └── test └── Entreprise.java

shell
Copier le code

## Classes Principales

### `Connexion`
Gère la connexion à la base de données.

### `Personne`
Classe de base pour tous les employés.

### `Manager`
Étend `Personne` et contient une liste de développeurs qu'il gère.

### `Developpeur`
Étend `Personne` et représente un développeur.

### `IDao`
Interface définissant les méthodes CRUD.

### `ManagerService`
Implémente `IDao` pour gérer les opérations liées aux managers.

### `DeveloppeurService`
Implémente `IDao` pour gérer les opérations liées aux développeurs.

### `Entreprise`
Classe principale pour tester la création et l'affichage des employés dans la hiérarchie.

## Instructions pour Exécuter le Projet

1. Assurez-vous que la base de données est opérationnelle et que le fichier `base.properties` est configuré correctement.
2. Compilez le projet dans NetBeans ou votre IDE préféré.
3. Exécutez la classe `Entreprise` pour créer les employés et afficher la hiérarchie.

### Exemple d'Affichage
Lors de l'exécution, le programme affichera les noms et salaires des employés de haut en bas de la hiérarchie.

Directeur Général : RAMI, Salaire : 7000

Manager : SADDIK, Salaire : 5000
Développeur : AMALI, Salaire : 3000
Développeur : NOUARI, Salaire : 3500
Développeur : SEBIHI, Salaire : 3200
shell
Copier le code
