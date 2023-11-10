# Football Tournament Management System

## Introduction

Ce projet consiste en un système de gestion de tournoi de football construit avec Spring Boot. Il permet de gérer les équipes, les joueurs, les arbitres, les stades et les matchs d'un tournoi.

## Fonctionnalités

- Récupérer tous les matchs, équipes, joueurs, stades et arbitres
- Enregistrer un nouvel arbitre, stade, match, joueur et équipe
- Modifier et supprimer un arbitre, match, stade, équipe et joueur
- Récupérer toutes les équipes d'un pays donné
- Récupérer les matchs programmés à une date donnée
- Récupérer le stade d'un match par son ID
- Récupérer les joueurs d'une équipe par nom
- Récupérer les équipes d'un match par son ID
- Récupérer les joueurs d'un poste et équipe donnés
- Supprimer les matchs dont la date est passée

## Technologies

- Java 11
- Spring Boot
- Spring MVC
- Spring Data JPA
- MySQL
- Maven

## Utilisation

L'application expose une API REST. Voici quelques exemples d'endpoints :

- GET /matchs
- GET /equipes?pays=Maroc
- GET /matches?date=28/02/2021
- GET /stades/match/3

- etc.

Consultez cette [vidéo de démonstration](https://youtu.be/VIDEO_ID) pour voir l'application en action.

Le modèle de données est le suivant :

![image](https://github.com/MarwanEA/Spring_football_tourney_manager/assets/23003724/c29fec3d-de99-45f2-89ec-5b818b76890e)


## Installation

1. Cloner le dépôt
2. Configurer vos informations de BDD dans `application.properties`
3. Exécuter l'application
4. Appeler les endpoints via Postman/cURL

