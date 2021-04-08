package com.example.demo.Dao;


import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserDAO extends JpaRepository<User,Long> {
    /*
     * 在这里继承JpaRepository
     * JPA的优点之一
     */
}
