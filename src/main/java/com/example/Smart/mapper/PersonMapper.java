package com.example.Smart.mapper;

import com.example.Smart.dto.PersonDto;
import com.example.Smart.entity.Person;
import com.example.Smart.entity.enums.UserRole;

public class PersonMapper {
    public Person convert(PersonDto personDto){
        Person person=new Person(personDto.getFirstName(),personDto.getLastName(),
                personDto.getUsername(), personDto.getPassword(), UserRole.CUSTOMER);
        return person;
    }
}
