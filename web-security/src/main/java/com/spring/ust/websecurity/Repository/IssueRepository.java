package com.spring.ust.websecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ust.websecurity.Entity.Issue;


@Repository
public interface IssueRepository  extends JpaRepository<Issue,Long>{
    
}
