package com.example.backend.controller;

import java.util.List;
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
import com.example.backend.model.Message;
import com.example.backend.model.MessageRepository;
import com.example.backend.model.User;
import com.example.backend.model.UserRepository;



@Controller
@RequestMapping(path="/message")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository, ChatRepository chatRepository,
            UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewMessage (@RequestBody Message message){

        Message m = new Message();
        Optional<Chat> c = chatRepository.findById(message.getChat().getCid());
        Optional<User> u = userRepository.findById(message.getUser().getUid());
        m.setTxt(message.getTxt());
        if(c.isPresent() && u.isPresent()){
            m.setChat(c.get());
            m.setUser(u.get());
            messageRepository.save(m);
            return"It worked: \n"+"text:"+m.getTxt() + "\n cid: "+ 
            m.getChat().getCid()+ "\n uid: "+ m.getUser().getUid()+
            "\n mid: "+ m.getMid()+"\n timestamp: "+ m.getSent();
        }

        return "boop";
    }
    @GetMapping(path="/findByUser")
    public @ResponseBody Message getMessages(@RequestParam Integer mid){

        Optional<Message> message = messageRepository.findById(mid);
        
        return message.orElseThrow();
    }

    @GetMapping(path="/findByChat")
    public @ResponseBody List<Message> getMessagesByChat(@RequestParam Integer cid){
        

        List<Message> messages = messageRepository.findAllByChat(cid);
        
        return messages;
    }

}
