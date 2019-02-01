package com.yanglf.boot.springboot2.repository;

import com.yanglf.boot.springboot2.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yanglf
 * @sine 2019.02.01
 * @descriptipon
 * @see
 */
@Repository
public class UserRepository {

    private final Map<Integer, User> userMap=new ConcurrentHashMap<>();

    private AtomicInteger atomicInteger=new AtomicInteger();

    public  boolean save(User user){
        int id=atomicInteger.incrementAndGet();
        user.setId(id);
        return userMap.put(id,user)==null;
    }


    public  Collection<User>  findAll(){
        return userMap.values();
    }

}
