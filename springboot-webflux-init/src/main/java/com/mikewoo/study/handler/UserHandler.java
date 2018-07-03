package com.mikewoo.study.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * User 处理器类
 *
 * @auther Phantom Gui
 * @date 2018/7/3 9:24
 */
@Component
public class UserHandler {

    public Mono<ServerResponse> findUser(ServerRequest request) {
        Optional<String> username = request.queryParam("username");

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject("Hello, " + username.get()));
    }
}
