package com.example.backend.model;


import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Integer mid;

    @ManyToOne(optional = false)
    @JoinColumn(name="cid", nullable = false)
    private Chat chat;

    @ManyToOne(optional = false)
    @JoinColumn(name="uid", nullable = false)
    private User user;

    private String txt;
    @CreationTimestamp
    @Column(name="sent", updatable = false)
    private Timestamp sent;
  
    public Message() {
    }

    public Message(Integer mid, Chat chat, User user, String txt, Timestamp sent){
        this.mid = mid;
        this.chat = chat;
        this.user = user;
        this.txt = txt;
        this.sent = sent;
    }

    public Integer getMid(){
        return mid;
    }
    public void setMid(Integer mid){
        this.mid = mid;
    }

    public String getTxt(){
        return txt;
    }
    public void setTxt(String txt){
        this.txt = txt;
    }

    public Chat getChat() {
        return chat;
    }

    public User getUser() {
        return user;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getSent() {
        return sent;
    }

    public void setSent(Timestamp sent) {
        this.sent = sent;
    }

  
}    
