package com.example.Auth_App_Backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.CloseableThreadContext;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;
    @Column(name = "user_email", unique = true)
    private String email;
    @Column(name = "user_name", length = 100)
    private String name;
    private String password;
    private String image;
    private boolean enable = true;
    private Instant createAt = Instant.now();
    private Instant updatedAt = Instant.now();

    private Provider provider = Provider.LOCAL;

    private Set<Role> roles = new HashSet<>();


}
