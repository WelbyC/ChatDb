package com.example.backend.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.backend.model.Chat;
import com.example.backend.model.ChatRepository;



@Controller
@RequestMapping(path="/chat")
public class ChatController {
    @Autowired
    private ChatRepository chatRepository;

    @PostMapping(path="/add")
    public @ResponseBody Chat addNewChat (@RequestBody Chat chat){

        return chatRepository.save(chat);
    }
    @GetMapping(path="/find")
    public @ResponseBody Chat getChat(@RequestParam Integer cid){
        

        Optional<Chat> chat = chatRepository.findById(cid);
        
        return chat.orElseThrow();
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Chat> getAllChat(){
        
        return chatRepository.findAll();
    }




}


