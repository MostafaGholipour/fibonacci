package com.example.Smart.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListPersonMapDto {
    List<PersonMapDto> list;
}
