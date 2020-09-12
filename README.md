# spring-boot-websocket
spring-boot-websocket을 이용한 채팅 프로그래밍

- 순수 Websocket을 썻을 경우 Websocket에 연결된 Client들에게 BroadCast을 보내려면 클라의 Session 아이디를 조회해 서버에서 처리해 줘야한다.  ( stomp를 사용할 경우 pub/sub으로 쉽게 처리 가능 )
