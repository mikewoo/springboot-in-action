package com.mikewoo.study.router;

import com.mikewoo.study.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * User 路由处理类
 *
 * @auther Phantom Gui
 * @date 2018/7/3 9:50
 */
@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> routeUser(UserHandler userHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/users")
                                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN))
                    , userHandler::findUser);
    }
}
