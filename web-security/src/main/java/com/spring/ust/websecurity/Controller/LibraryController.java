package com.spring.ust.websecurity.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ust.websecurity.Entity.Issue;
import com.spring.ust.websecurity.Entity.User;
import com.spring.ust.websecurity.Exception.UserNotSubscribedException;
import com.spring.ust.websecurity.Repository.IssueRepository;
import com.spring.ust.websecurity.Repository.userRepository;



@RestController
@RequestMapping("/api/v1")
public class LibraryController {
    
    @Autowired
    private userRepository ur;

    @Autowired
    private IssueRepository ir;


    @PostMapping("/issue-book")
    public ResponseEntity<Issue> issueBook(@RequestBody Issue issue){

        Optional<User> temp =ur.findById(issue.getUser().getId());

        User user = temp.get();

        if(temp.isEmpty()){
            return ResponseEntity.noContent().build();
            
        }

        if(user.getSubscribed()){
            throw new UserNotSubscribedException("user not subscribed");
        }
        ir.save(issue);
        return  ResponseEntity.ok(issue) ;

    }
      
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){

        ur.save(user);

        return ResponseEntity.ok(user);
    }
    
    @GetMapping("renew-user-subscription/{id}")
      public ResponseEntity<User> renewSubscription(@PathVariable Long id){

        Optional<User> temp = ur.findById(id);

       User  user =null;

        if(temp.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        user= temp.get();
        user.setSubscribed(true);
        ur.save(user);
        return ResponseEntity.ok(user) ;
        
    }

   
    

   }


    



    
