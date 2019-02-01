package com.yanglf.boot.springboot2.controller;

import com.yanglf.boot.springboot2.model.User;
import com.yanglf.boot.springboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanglf
 * @sine 2019.02.01
 * @descriptipon
 * @see
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public User saveUser(String name){
        User user=new User();
        user.setUserName(name);
        if(userRepository.save(user)){
            System.out.printf("保存用户:%s \n",user);
        }
        return user;
    }

}
