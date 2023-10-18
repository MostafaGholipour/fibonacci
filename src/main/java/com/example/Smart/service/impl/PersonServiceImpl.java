package com.example.Smart.service.impl;

import com.example.Smart.dto.PersonDto;
import com.example.Smart.entity.Person;
import com.example.Smart.entity.PersonMapEntry;
import com.example.Smart.exception.InputeException;
import com.example.Smart.exception.NotFoundException;
import com.example.Smart.mapper.PersonMapper;
import com.example.Smart.repository.PersonRepository;
import com.example.Smart.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    PersonMapper personMapper=new PersonMapper();

    @Override
    public Long fibonacci(Long number) {

        if (number < 2) {
            return (long) number;
        }
        Long a = 0L, b = 1L, result = 0L;
        for (int i = 2; i <= number; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    @Override
    public void inputNumber(String userName, String inputNumber) {
        Optional<Person> person = repository.findByUsername(userName);
        if (person.isEmpty()) {
            throw new NotFoundException("Not Found Person!");
        }
        Long number;
        try {
            number = Long.parseLong(inputNumber);
        } catch (Exception e) {
            throw new InputeException("Input number must be int !");
        }
        Long fibonacci = fibonacci(number);
        PersonMapEntry personMapEntry = new PersonMapEntry(number,fibonacci);
        person.get().getList().add(personMapEntry);
        System.out.println(person);
    }

    @Override
    public void register(PersonDto personDto) {
        Person convert = personMapper.convert(personDto);
        repository.save(convert);
    }
}
