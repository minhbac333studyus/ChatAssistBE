package com.chatassistbe.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name = "USER_TB")
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

}
