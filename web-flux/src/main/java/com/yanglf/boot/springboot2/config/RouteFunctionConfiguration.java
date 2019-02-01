package com.yanglf.boot.springboot2.config;

import com.yanglf.boot.springboot2.model.User;
import com.yanglf.boot.springboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * @author yanglf
 * @sine 2019.02.01
 * @descriptipon 路由器函数的配置
 * @see
 */
@Configuration
public class RouteFunctionConfiguration {
    /**
     * Servlet
     * 请求: ServletRequest/ HttpServletRequest
     * 响应: ServletResponse / HttpServletResponse
     * Spring 5.0 重新定义请求响应   既可以支持Servlet 规范，也可以支持自定义规范，比如：Netty
     * 请求: ServerRequest
     * 响应: ServerResponse
     * flux 0 -> n 个对象集合
     * mono 是  0 -> 1 个对象集合
     * Reactive flux、mono 是异步处理  （非阻塞）
     * 集合对象基本是同步处理   （阻塞）
     *
     * @return
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> userFindAll(UserRepository userRepository) {
        return RouterFunctions.route(RequestPredicates.GET("/user/find/all"),
                request -> {
                    Collection<User> userCollection = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(userCollection);
                    return ServerResponse.ok().body(userFlux, User.class);
                });
    }


}
