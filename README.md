# Docker + Spring Boot Practice

## Docker Command Example

### Step 1 simple build and run
* docker build -t deploy-test:0.1 .
* docker run -d -p 8080:8080 --name deploy-test deploy-test:0.1

### Step 2 use variable (spring active profiles)
* 빌드 시점에 환경 고정
```docker
1. docker build --build-arg PROFILE=dev -t deploy-dev:0.1 .
2. docker run -d -p 8080:8080 --name deploy-dev deploy-dev:0.1
```

* run 시점에 환경 설정
```docker
1. docker build -t deploy_run_test:0.1 .
2. docker run -e "JAVA_TOOL_OPTIONS=-Dspring.profiles.active=dev" -d -p 8080:8080 --name deploy-run-test deploy-run-test:0.1
```

### Step 3 docker container network
* docker network ls
* docker network create test_network
* docker run -d --name db -e MYSQL_ROOT_PASSWORD=test1234 -p 3306:3306 --network test_network mysql
    * docker exec -it {CONTAINER_ID} /bin/bash
    * mysql -u root -p 
    * create database testdb;
* docker build --network test_network -t deploy-test-network:0.1 .
* docker run -e "JAVA_TOOL_OPTIONS=-Dspring.profiles.active=dev" -d -p 8080:8080 --name deploy-test-network deploy-test-network:0.1

## Docker Network
docker container 간에 접근을 위해서 container 실행시 ```--link``` 옵션을 사용해야 했다.<br>
하지만, ```--link```는 곧 사라질 예정이기 때문에 ```network```를 사용하는 것을 권장하고 있다.
* https://docs.docker.com/network/links/

### Docker Network 종류
* Default Bridge Network (테스트 환경 적합)
* User-Defined Bridge Network (상용 환경 적합)
* Overlay Network (docker swarm에서 사용됨)
