package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="chats")
public class Chat {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cid;
    
    private String chatname;

    public Chat() {
    }

    public Chat(Integer cid, String chatname) {
        this.cid = cid;
        this.chatname = chatname;
    }

    public Integer getCid(){
        return cid;
    }

    public void setCid(Integer cid){
        this.cid = cid;
    }

    public String getChatname(){
        return chatname;
    }

    public void setChatname(String chatname){
        this.chatname = chatname;
    }
}
