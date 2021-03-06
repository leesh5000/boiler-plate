# boiler-plate

boiler-plate 는 대부분의 웹 어플리케이션의 기본 기능인 회원가입, 로그인, 로그아웃을 기능을 가지 프로젝트입니다.

## 개발 전 배경지식

### 1. Json Web Token

우선 jwt는 선택적 서명 및 선택적 암호화를 사용하여 데이터를 만들기 위한 인터넷 표준 중 하나이다. jwt가 유저 인증 방식 중, 토큰 방식의 구현체로서 사용되기 적합하기 때문에 **"유저 인증을 위한 토큰 방식을, jwt 기술을 사용하여 구현"** 하는 것이다.

그렇다면 토큰 방식이 아닌 다른 유저 인증 방식에는 무엇이 있을까? 

1. cookie : 쿠키는 http의 cookie 헤더를 사용하여 유저 인증을 하는 방식이다. 이 쿠키는 http의 기본 원칙인 무상태성을 지키기위해 웹 브라우저에 전송되며 매 요청마다 http 헤더를 통해 전달된다. 쿠키 정보는 항상 네트워크에 전송되므로 추가 트래픽을 유발한다. 또한, 탈튀, 조작 가능성이 있기 때문에 보안에 취약하다.
2. session : 세션 방식도 마찬가지로 http cookie를 사용한다. 하지만, 세션이 쿠키와 다른 점은 쿠키 방식은 인증 정보가 각 브라우저의 별도 쿠키 저장소에 저장되는 반면에 세션 방식은 서버에 저장된다. 즉, 서버에서는 인증 정보를 저장하고 웹 브라우저의 쿠키 정보에서는 이 인증 정보에 대응되는 세션 ID를 저장하는 방식이다. 세션 ID는 유의미한 정보를 가지고 있지 않기 때문에 유출에 상대적으로 안전하며, 유출됐다하더라도 서버에서 주기적으로 세션 ID를 초기화하여 유출된 세션 ID를 못 쓰게 만들 수가 있다. 하지만, 서버에서 따로 세션 저장소를 두어야하는 점과 확장성이 좋지 않다는 단점이 있다.
```
세션의 단점 : 시나리오

세션은 서버에 저장되므로, 요청이 많아지면 서버에 과부하가 걸릴 수 있다.
-> 과부하를 줄이기 위해 서버를 여러대 둔다.
-> 서버마다 세션 정보를 동기화하는 데에 따른 추가 오버헤드가 발생한다.
```
3. token : 서버에서 유저 인증 정보가 담긴 토큰을 발행하고 어떠한 유저 정보도 기억하지 않는다. 이렇게 함으로써 서버는 무상태를 유지할 수 있고 이로인해 확장성이 좋아진다. 또한, 인증 정보는 클라이언트가 보유해야하므로 서버는 토큰을 저장하는데에 따른 오버헤드가 없다. 하지만, 토큰이 클라이언트에 저장되기 때문에 유출에 대한 위험이 존재한다.

위와 같이 서로 다른 유저 인증 방식이 존재하며 각자 장단점이 있다. 사실 토큰 방식도 유출에 대한 위험이 존재하기 때문에 이를 해결하려는 여러가지 방법들이 존재한다. 예를들어, 인증 토큰은 만료 시간을 짧게 하고 인증 토큰의 재발급을 위한 유효기간이 더 긴 refresh token을 더 안전한 곳에 저장하는 등이 그것이다.

하지만 본 프로젝트에서는 문제의 단순화를 위해 가장 기본적인 토큰 방식을 사용하여 유저 인증/인가를 진행한다.

## 사용된 기술

### 1. Frontend
- 언어 : Javascript
- 라이브러리 : react, react-redux, redux-saga

### 2. backend
- 언어 : Java 11
- 프레임워크 : SpringBoot (spring security, spring data jpa, spring web)
- 데이터베이스 : H2

## 프로젝트 Init

```
/* project root */
cd boiler-plate-master

/* run backend */
cd backend && ./gradlew bootjar && cd build/libs && java -jar backend-0.0.1-SNAPSHOT.jar

/* run frontend */
cd frontend && yarn install && yarn start

```

