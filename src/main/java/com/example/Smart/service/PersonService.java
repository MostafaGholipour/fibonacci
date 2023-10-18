package com.example.Smart.service;

import com.example.Smart.dto.PersonDto;


public interface PersonService {
    Long fibonacci(Long number);
    void inputNumber(String userName,String number) ;
    void register(PersonDto personDto);
}
