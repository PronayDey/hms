package com.hms.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.hms.entity.ChatMessage;
import com.hms.entity.User;
import com.hms.entity.Users;
import com.hms.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private  ChatMessageRepository chatMessageRepository;
    @Autowired
    private  UserService userService;



    @Override
    public List<ChatMessage> getChatMessages(Long userId) {
        Users user = userService.getUserById(userId);
        return chatMessageRepository.findBySenderOrReceiver(user, user);
    }

    @Override
    public void sendMessage(Long senderId, Long receiverId, String content) {
        Users sender = userService.getUserById(senderId);
        Users receiver = userService.getUserById(receiverId);

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setReceiver( receiver);
        chatMessage.setSender( sender);
        chatMessage.setContent(content);
        chatMessage.setTimestamp(LocalDateTime.now());

        chatMessageRepository.save(chatMessage);
    }
}
