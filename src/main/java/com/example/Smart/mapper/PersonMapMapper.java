package com.example.Smart.mapper;

import com.example.Smart.dto.PersonMapDto;
import com.example.Smart.entity.PersonMap;

public class PersonMapMapper {
    public PersonMapDto convert(PersonMap personMap){
        PersonMapDto dto=new PersonMapDto(personMap.getKey(),personMap.getValue());
        return dto;
    }
}
