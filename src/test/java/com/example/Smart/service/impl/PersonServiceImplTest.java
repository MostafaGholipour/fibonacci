package com.example.Smart.service.impl;

import com.example.Smart.service.PersonService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;
@Component
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonServiceImplTest {
    @Autowired
    PersonService personService;

    @Test
    void fibonacci() {
        assertEquals(233L,personService.fibonacci(13L));
    }
    @Test
    void fibonacci1() {
        assertEquals(1L,personService.fibonacci(1L));
    }
    @Test
    void history() {
        personService.history("M");
    }
    @Test
    void inputNumber(){
        personService.inputNumber("M","7");
    }
}