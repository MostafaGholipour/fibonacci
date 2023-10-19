package com.example.Smart.service.impl;

import com.example.Smart.dto.ListPersonMapDto;
import com.example.Smart.dto.PersonDto;
import com.example.Smart.dto.PersonMapDto;
import com.example.Smart.entity.Person;
import com.example.Smart.entity.PersonMap;
import com.example.Smart.exception.InputeException;
import com.example.Smart.exception.NotFoundException;
import com.example.Smart.mapper.PersonMapMapper;
import com.example.Smart.mapper.PersonMapper;
import com.example.Smart.repository.PersonRepository;
import com.example.Smart.service.PersonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    private final PasswordEncoder passwordEncoder;
    PersonMapper personMapper = new PersonMapper();
    PersonMapMapper personMapMapper = new PersonMapMapper();


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

    @Transactional
    @Override
    public PersonMapDto inputNumber(String userName, String inputNumber) {
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
        PersonMap personMap = new PersonMap(number, fibonacci);

        List<PersonMap> list = person.get().getList();
        list.add(personMap);
        System.out.println(person);
        System.out.println("-----------------");

        person.get().setList(list);
        update(person.get());

        System.out.println(repository.findByUsername(userName));

        return personMapMapper.convert(personMap);
    }

    @Transactional
    @Override
    public void register(PersonDto personDto) {
        Person person =
                personMapper.convert(personDto);
        person.setPassword(passwordEncoder.encode(personDto.getPassword()));
        repository.save(person);
    }

    @Transactional
    @Override
    @Scheduled(fixedDelay = 6000)
    public void timer(String username) {

        Optional<Person> person = repository.findByUsername(username);
        if (person.isEmpty()) {
            throw new NotFoundException("not Found Person!");
        }
        List<PersonMap> list = person.get().getList();
        for (PersonMap entry : list) {
            if (entry.getTime().isBefore(LocalTime.now())) {
                list.remove(entry);
                repository.save(person.get());
            }
        }
    }

    @Override
    public ListPersonMapDto history(String username) {
        Optional<Person> person = repository.findByUsername(username);
        System.out.println(person);
        System.out.println("-------------");
        if (person.isEmpty()) {
            throw new NotFoundException("not Found Person!");
        }
        List<PersonMapDto> personMapDtoList = new ArrayList<>();

        List<PersonMap> list = person.get().getList();
        for (PersonMap p : list) {
            PersonMapDto convert = personMapMapper.convert(p);
            personMapDtoList.add(convert);
            System.out.println(convert);
        }
        System.out.println(person);
        return new ListPersonMapDto(personMapDtoList);
    }

    @Override
    public void update(Person person) {
        repository.save(person);
    }
}
