https://github.com/fabric8io/docker-maven-plugin

http://dmp.fabric8.io/

docker run --name my-mysql -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -p 3306:3306 -d mysql

docker build -t test-spring-boot .

docker run --name new4 -p 8080:8080 --link my-mysql:mysql-host -e DATABASE_HOST=mysql-host new4

docker build -t java_club_home2 ./../ -f Dockerfile
