package com.hms.Service;

import com.hms.entity.ChatMessage;

import java.util.List;



public interface ChatService {
    List<ChatMessage> getChatMessages(Long userId);
    void sendMessage(Long senderId, Long receiverId, String content);
}

