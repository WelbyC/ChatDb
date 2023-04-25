package com.example.backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="gmembers")
public class Gmember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cid", nullable = false)
    @JsonIgnore
    private Chat chat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid", nullable = false)
    @JsonIgnore
    private User user;


    
    public Gmember() {
    }

    public Gmember(Integer gid, Chat chat, User user) {
        this.gid = gid;
        this.chat = chat;
        this.user = user;
    }

    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    
}
