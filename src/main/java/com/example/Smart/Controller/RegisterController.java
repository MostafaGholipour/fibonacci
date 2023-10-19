package com.example.Smart.Controller;

import com.example.Smart.dto.PersonDto;
import com.example.Smart.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/register")
public class RegisterController {
    private final PersonService personService;

    @PostMapping("/person")
    public void register(@RequestBody PersonDto personDto){
        personService.register(personDto);
    }

}
