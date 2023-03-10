# SPRINGBOOT API INTRODUCTIONS
## Requirements
- Youtube link -> https://www.youtube.com/watch?v=-mwpoE0x0JQ&ab_channel=Amigoscode
- Spring initializer -> https://start.spring.io/
- jdk - version 19
- Intellij
- Database -> Spring Data JPA i.e. PostgreSql(host: localhost, port: 5432)

## mvn commands
- mvn clean
- mvn clean compile
- mvn test

## Tomcat
- Tomcat port: 8080

## Solving plugin errors:
- Now lets say I had 10 such plugins which didn't get resolve and among them the first was 'org.apache.maven.plugins:maven-site-plugin' I went to '.m2/repository/org/apache/maven/plugins/' and deleted the directory 'maven-site-plugin' and did a maven reimport again. Guess what, particular missing plugin got dowloaded. And I just followed similar steps for other missing plugins and all got resolved.
- link -> https://stackoverflow.com/questions/20496239/maven-plugins-can-not-be-found-in-intellij

## NB : 
- While opening the project in IDEA such as Intellij IDEA, open the last 'demo' file, otherwise the app wont run accordingly.


## Killing a process in cmd:
- First determine process id occupied by that port i.e. port 8080 by running:<br>

      netstat -ano | findstr :8080
- Then kill the process

      netstat -ano | findstr :8080

## Layers 
- API layer - Controller (Contains GET, POST, PUT, DELETE)
- Service Layer - Business logic
- Data Access Layer - 

## API Layer
![SpringBootLayers](images/SpringBootLayers.PNG)

## Docker and postgresql
![SpringBootLayers](images/db-docker.PNG)


# Postgresql
- Download Postgresql DB latest version, install copy the password while installing.
- Copy "C:\Program Files\PostgreSQL\14\lib" and "C:\Program Files\PostgreSQL\14\bin" and paste them in environment variables path to enable psql command line.
- login in command in terminal(i.e. in any directory level i.e. "C:\Users\Wainaina") :

       psql -U postgres
- Password:

      1234
- Check/View all available databases

      postgres=# \l
- Create Database command:

      CREATE DATABASE martin;
- View all rows in db:

      postgres=# \du

## Docker commands:
- While in " C:\Users\Administrator\Desktop\SpringBoot\SpringBoot-3-API\springboot3\springboot3" directory,;
- Pres "ctrl" + "d" to exit
- Run docker in detach mode:

      docker-compose up -d
- Check if docker db pulled successfully:

      docker-compose ps
- Check container logs... i.e. 'postgres' container:

      docker logs postgres

## Docker commands to create database customer:
- While in " C:\Users\Administrator\Desktop\SpringBoot\SpringBoot-3-API\springboot3\springboot3" directory,;
- Check if docker db pulled successfully:

      docker-compose ps
- Execute shell commands within the docker container:

      docker exec -it postgres bash
- login :

       psql -U postgres
- Check/View all available databases

      postgres=# \l
- Create Database command:

      CREATE DATABASE customer;
- View all rows in db:

      postgres=# \du
- Connect to customer db

      \c customer
- view all relations

      \d
- view table relations

      \dt
- view all rows of customer

      select * from customer;