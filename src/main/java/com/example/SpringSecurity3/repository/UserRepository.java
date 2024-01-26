package com.example.SpringSecurity3.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringSecurity3.entity.user.Role;
import com.example.SpringSecurity3.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
//        CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User findById(long id);
}
