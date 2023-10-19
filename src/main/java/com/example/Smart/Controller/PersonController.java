package com.example.Smart.Controller;

import com.example.Smart.dto.ListPersonMapDto;
import com.example.Smart.dto.PersonMapDto;
import com.example.Smart.entity.Person;
import com.example.Smart.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class PersonController {
    Person person;

    private final PersonService personService;

    @GetMapping("/inputNumber/{userName}/{number}")
    public PersonMapDto inputNumber(@PathVariable String userName, @PathVariable String number) {
        return personService.inputNumber(userName, number);
    }
    @GetMapping("/history/{username}")
    ListPersonMapDto history(@PathVariable String username){
       return personService.history(username);
    }



}
