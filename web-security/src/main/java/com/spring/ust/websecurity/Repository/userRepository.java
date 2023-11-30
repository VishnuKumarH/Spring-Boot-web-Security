package com.spring.ust.websecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ust.websecurity.Entity.User;

@Repository
public interface userRepository  extends JpaRepository<User,Long>{
    
}
