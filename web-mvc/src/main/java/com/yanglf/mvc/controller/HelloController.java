package com.yanglf.mvc.controller;

import com.yanglf.mvc.model.User;
import com.yanglf.mvc.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author yanglf
 * @sine 2019.02.01
 * @descriptipon
 * @see
 */
@RestController
@Slf4j(topic = "service")
public class HelloController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/save")
    public  String save(String userName){
        userRepository.save(User.builder()
                .userName(userName)
                .password(UUID.randomUUID().toString().replace("-",""))
                .createTime(new Date())
                .build());
        return "ok";
    }


    @RequestMapping("query")
    @Cacheable(value = "user",key = "'user_'.concat(#root.args[0])")
    public List<User>  query(int uuId){
        log.info("query:"+uuId);
        List<User> userList = userRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime"));
        log.info("userList:{}",userList);
        return userList;
    }


}
