package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="cid", nullable = false)
    @JsonIgnore
    private Chat chat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="uid", nullable = false)
    @JsonIgnore
    private User user;

    private String txt;

    private String sent;

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

    public String getSent(){
        return sent;
    }
    public void setSent(String sent){
        this.sent = sent;
    }
}    
