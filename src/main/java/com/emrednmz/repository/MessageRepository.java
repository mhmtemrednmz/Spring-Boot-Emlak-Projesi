package com.emrednmz.repository;

import com.emrednmz.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "select * from message where sender_id = :senderId",nativeQuery = true)
    List<Message> findBySender(Long senderId);

    @Query(value = "select * from message where recipient_id = :recipientId",nativeQuery = true)
    List<Message> findByRecipient(Long recipientId);
}
