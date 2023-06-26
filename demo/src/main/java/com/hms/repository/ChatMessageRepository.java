package com.hms.repository;

import java.util.List;

import com.hms.entity.ChatMessage;
import com.hms.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;





public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findBySenderOrReceiver(Users sender, Users receiver);
    // Add any additional query methods if needed
}
