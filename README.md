# GeekJob             

### Description  

Fonction : Cette application permet de gerer des candidatures à des concours. Un système d’information qui permet d’enregistrer une liste de concours par les recruteurs, et permet aux candidats de créer une demande de candidature aux concours qui lui sont accessibles à partir de son espace personnel. Le processus de candidature se déroule en plusieurs phases : Transmis par le candidat, En traitement, puis Accepté ou Refusé par le recruteur. Les candidatures peuvent ensuite etre archivées. La création d’une candidature passe par le renseignement d’une fiche d’information du candidat qui doit inclure l’import de son fichier de CV. L’interface des utilisateurs permet de suivre l'évolution du statut de la canidature.  


### Installation  

Pour compiler et utiliser l'application, il vous faut :
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [Xamp](https://www.apachefriends.org/fr/index.html)

Les étapes pour installer GeekJobs :
    • Clonez le dépot GitHub sur votre ordinateur
    • Lancer un serveur Web local avec Xamp et assurez vous d'avoir des ports d'accés ouverts 
    • Créez votre base de donnée (GeekJobDataBase) sur votre SGBD (nous avons utilisé MySQL) 
    • Exécuter le fichier de requète de création et d'insertion des tables (GeekJobDataBase.sql)
    • Parametrez le fichier src/main/resources/application.properties en vous assurant d'avoir un port ouvert pour l'application, la bonne URL pour la Base de Donnée, ainsi que le **username et password** associés à la base.


### Utilisation 

Pour lancer cette application Spring Boot depuis votre ordinateur local vous pouvez executer la méthode 'main' qui se trouve dans la classe '/src/main/java/com/GeekJob/concoursDEV/ConcoursDevApplication.java' depuis votre IDE. Rendez vous à l'adresse http://localhost:9020/ et inscrivez vous en tant que candidat en mettant un email, un mot de passe en en cliquant sur le bouton **s'inscrire**. Vous pouvez vous connecter en tant qu'administrateur avec les accés **admin@GeekJob.com, 1234**.

Les applications Spring Boot peuvent aussi être lancées en ligne de commande avec [le plugin Spring Boot Maven](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins.html#build-tool-plugins-maven-plugin) ou être déployées sur [OpenShift](https://docs.openshift.com/container-platform/3.9/cli_reference/get_started_cli.html).

### Developement  

Ce projet à été initialisé dans le cadre de la formation de Concepteur / Developpeur Informatique de l'AFPA Paris en 2020 encadrée par Marc Lambert, Duc-Anh Pham et Constant Matsima. Pour le develppement nous avons utilisé les ressources suivantes:
    • Draw IO
    • Eclipse IDE
    • JEE
    • Xamp
    • phpMyAdmin
    • mySql
    • Spring Boot

### Auteurs  

[Voici l'équipe du projet :](https://github.com/maximej/GestionCandidature/contributors)
- [Maragatham](https://github.com/MaragathamJAYARAM)
- [Gueny](hhttps://github.com/little-devop)
- [MaximeJ](https://github.com/maximej)


### License  

Ce projet est sous licence MIT : voir le fichier LICENSE.md pour plus d'informations
