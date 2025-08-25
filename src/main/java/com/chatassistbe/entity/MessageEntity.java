package com.chatassistbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity(name = "MESSAGE_TB")
@Table
@NoArgsConstructor
@AllArgsConstructor

public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CONVERSATION_ID")
    private ConversationEntity conversation;
    @Column
    private String content;
    @Enumerated(EnumType.STRING)
    private Role role;

    public MessageEntity(ConversationEntity conversation, String content, Role role) {
        this.conversation = conversation;
        this.content = content;
        this.role = role;
    }

    public void  test(){
        System.out.println(conversation.getId());
    }

    @Override
    public String toString() {
        return "\n\tMessageEntity{" +
                "id=" + id +
                ", conversation=" + conversation.getId() +
                ", content='" + content + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
