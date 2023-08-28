# Board

email address : didalgus@gmail.com  
repository : https://github.com/didalgus/board_springboot2.7_mysql
blog address : https://didalgus.github.io/

## Introduction
Board REST Service  
restful API 방식으로 게시물을 조회하고 생성, 삭제합니다.  
API 목록은 [Swagger](http://localhost:8080/swagger-ui/index.html) 에서 확인할 수 있습니다. 

추후, User 가입&로그인, 게시판 File Upload 기능 추가예정입니다. (작성일 : 2023-05-29)

## Development Tools
- Apple MacBook M1 Pro (Ventura 13.3.1)
- IntelliJ IDEA 2023.1.2  

## Development Environment
- JAVA 17
- MySQL 5.7 
- Docker 23.0.5 (Docker Desktop 4.19.0)
- IntelliJ IDEA 2023.2 

## Application Version
- SpringBoot 2.7.13 (SpringFramework 5.3.27)
- Swagger3 (http://localhost:8080/swagger-ui/index.html)
- MyBatis 3.5.7

# Docker 

맥용 Docker Desktop 설치가 필요합니다.  
https://docs.docker.com/desktop/install/mac-install/  

소스내 `docker` 디렉토리로 이동 후 아래 명령어로 compose 구동합니다.  
-d 옵션은 background 구동합니다. 

```bash
docker-compose up -d 
```

compose 중지는 아래 명령로 실행합니다.
```bash
docker-compose down
```

docker-compose 설명   
개발환경이 MacBook M1 인지라 docker/docker-compose.yml 설정에 아래 옵션을 추가하였습니다.  
```
platform: linux/amd64 
```

MySQL 컨테이너 접속 CLI 명령어  
```bash
docker exec -it mysql_5_7 bash
```
참고 Url https://github.com/docker-library/docs/tree/master/mysql  

MySQL 접속 명령어   
```bash
bash-4.2# mysql -udemo -pdem0Passw*rd demo  
```


## Logs  
```bash
$ tail -f ~/logs/spring.log
```

## IntelliJ http 
IntelliJ IDEA 2023.2 버전 [Dynamic variables](https://www.jetbrains.com/help/idea/2023.2/exploring-http-syntax.html#dynamic-variables) 구문을 사용하였습니다.  

ex)
* $random.alphabetic(length): generates a sequence of uppercase and lowercase letters of length length (must be greater than 0). 
* $random.alphanumeric(length): generates a sequence of uppercase and lowercase letters, digits, and underscores of length length (must be greater than 0). 

sample  
```
### 게시판 등록
POST /board/create HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "title" : "title{{$randomInt}}",
  "content" : "{{$random.alphanumeric(10)}}",
  "regType" : "User",
  "regName" : "name{{$random.alphabetic(3)}}"
}
```

## APIs 
- 글 조회 : GET http://localhost:8080/board/{seq}
- 글 입력 : POST http://localhost:8080/board/create
- 글 목록 : GET http://localhost:8080/board/list 

