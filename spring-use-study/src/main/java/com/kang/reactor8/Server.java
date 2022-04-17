package com.kang.reactor8;

import com.kang.reactor8.handler.UserHandler;
import com.kang.reactor8.service.impl.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

public class Server {

    /**
     * 1. 创建handler对象
     */
    public RouterFunction<ServerResponse> routingFunction() {
        // 创建handler对象
        UserServiceImpl userService = new UserServiceImpl();
        UserHandler userHandler = new UserHandler(userService);
        // 设置路由
        return RouterFunctions.route(
                GET("/users/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::getUserById)
                .andRoute(GET("/users").and(accept(MediaType.APPLICATION_JSON)), userHandler::getAllUsers);
    }

    /*
     * 2.创建服务器完成适配
     */
    public void createReactorServer() {
        // 路由和handler适配
        RouterFunction<ServerResponse> route = routingFunction();
        HttpHandler httpHandler = RouterFunctions.toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        // 创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }

    /**
     * 3. 最终调用
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit!");
        System.in.read();
    }
}
