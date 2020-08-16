# Docker + Spring Boot
* docker build -t deploy-test:0.1 .
* docker run -d -p 8080:8080 --name deploy-test deploy-test:0.1

## Spring Boot active profiles
* docker build --build-arg PROFILE=dev -t deploy-dev:0.1 .
* docker run -d -p 8080:8080 --name deploy-dev deploy-dev:0.1

## Docker network + MySQL
* docker network ls
* docker network create testdb
* docker run -d --name db -e MYSQL_ROOT_PASSWORD=test1234 -p 3306:3306 --network testdb mysql
* docker build --build-arg PROFILE=dev --network testdb -t deploy-dev-db:0.1 .
* docker run -d -p 8080:8080 --name deploy-dev-db --network testdb deploy-dev-db:0.1