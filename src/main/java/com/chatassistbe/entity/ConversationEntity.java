package com.chatassistbe.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name = "CONVERSATION_TB")
@Table
@NoArgsConstructor
@AllArgsConstructor
public class ConversationEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne

    @JoinColumn(name = "USER_ID")
    private UserEntity user;

}
