package com.example.demo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
public class WebSocketChatHandler extends AbstractWebSocketHandler {

    private int count = 0;

    // 텍스트 메시지 전송
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("handleTextMessage");

        String payload = message.getPayload();
        log.info("payload : " + payload);
        log.info("session : " + session.toString());
        TextMessage textMessage = new TextMessage(payload);
        session.sendMessage(textMessage);
    }

    // 웹 소켓 연결 후 1번 호출
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("count : " + ++count);
        log.info("afterConnectionEstablished");
        super.afterConnectionEstablished(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.info("handleMessage");
        log.info("message : " + message.getPayload());
        super.handleMessage(session, message);
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        log.info("handleBinaryMessage");
        super.handleBinaryMessage(session, message);
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        log.info("handlePongMessage");
        super.handlePongMessage(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("handleTransportError");
        super.handleTransportError(session, exception);
    }

    // 웹 소캣 연결 끊킨 후 1번 호출
   @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
       log.info("count : " + --count);
       log.info("afterConnectionClosed");
        super.afterConnectionClosed(session, status);
    }
}
