package com.yanglf.mvc.repository;

import com.yanglf.mvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yanglf
 * @description
 * @since 2019/2/25
 **/
@Repository
public interface UserRepository  extends JpaRepository<User,Long> {


}
