package com.example.javajwtdemo.repo;

import com.example.javajwtdemo.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokeRepo extends JpaRepository<Token,Integer> {
    @Query("""
            select t from Token t inner  join User u on t.user.usersID = u.usersID
            where u.usersID = :userId and(t.expired= false or t.revoked= false )
            """)
    List<Token> findAllValidTokensByUser(int userId);
    Optional<Token> findByToken(String token);
}
