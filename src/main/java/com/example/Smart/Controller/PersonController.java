package com.example.Smart.Controller;

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

    @GetMapping("/inputNumber/{userName}/{userName}")
    public void inputNumber(@PathVariable String userName, @PathVariable String number) {
        personService.inputNumber(userName, number);
    }


}
