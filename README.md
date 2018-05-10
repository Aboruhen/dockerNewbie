https://github.com/fabric8io/docker-maven-plugin

http://dmp.fabric8.io/

#Load and run mysql server in docker on port 3306
docker run --name my-mysql -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -p 3306:3306 -d mysql

#Build docker image based on Dockerfile
docker build -t test-spring-boot .
docker build -t java_club_home2 ./../ -f Dockerfile

#Connect two different docker containers use --link and use env variable
docker run --name new4 -p 8080:8080 --link my-mysql:mysql-host -e DATABASE_HOST=mysql-host new4
