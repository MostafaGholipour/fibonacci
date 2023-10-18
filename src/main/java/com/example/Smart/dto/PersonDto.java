package com.example.Smart.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    String firstName;
    String lastName;
    String username;
    String password;
    String email;
}
