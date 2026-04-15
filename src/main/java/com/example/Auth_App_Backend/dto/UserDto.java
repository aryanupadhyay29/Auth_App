package com.example.Auth_App_Backend.dto;

import com.example.Auth_App_Backend.entity.Provider;

import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private UUID id;

    private String email;

    private String name;
    private String password;
    private String image;
    private boolean enable = true;
    private Instant createAt = Instant.now();
    private Instant updatedAt = Instant.now();

    private Provider provider = Provider.LOCAL;
    private Set<RoleDto> roles = new HashSet<>();
}
