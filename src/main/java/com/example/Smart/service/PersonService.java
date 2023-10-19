package com.example.Smart.service;

import com.example.Smart.dto.ListPersonMapDto;
import com.example.Smart.dto.PersonDto;
import com.example.Smart.dto.PersonMapDto;
import com.example.Smart.entity.Person;


public interface PersonService {
    Long fibonacci(Long number);
    PersonMapDto inputNumber(String userName, String number) ;
    void register(PersonDto personDto);
    void timer(String username);
    ListPersonMapDto history(String username);
    void update(Person person);
}
