package com.example.backend.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface MessageRepository extends JpaRepository<Message,Integer>{
    @Query("Select m FROM Message m WHERE m.chat.cid = :cid ORDER BY m.sent ASC")
    List<Message> findAllByChat(@Param("cid") Integer cid);

}
