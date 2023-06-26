package com.hms.controller;

import java.util.List;

import com.hms.Service.ChatService;
import com.hms.entity.ChatMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@Controller
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/{userId}")
    public String getChat(@PathVariable("userId") Long userId, Model model) {
        List<ChatMessage> messages = chatService.getChatMessages(userId);
        model.addAttribute("messages", messages);
        return "chat";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("senderId") Long senderId, @RequestParam("receiverId") Long receiverId,
                              @RequestParam("content") String content) {
        chatService.sendMessage(senderId, receiverId, content);
        return "redirect:/chat/" + senderId;
    }
}
