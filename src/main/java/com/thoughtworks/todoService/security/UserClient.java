package com.thoughtworks.todoService.security;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name="token", url = "user-service:8082")
//@FeignClient(name="token", url = "localhost:8082")
public interface UserClient {

    @GetMapping("/users/authToken")
    Map<String,Long> getUser(@RequestHeader("Authorization") String authorization);

}
