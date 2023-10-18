package com.example.Smart.entity;

import com.example.Smart.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity
public class PersonMapEntry {
//    @ManyToOne
//    Customer customer;
    Long key;
    Long value;
    LocalTime time;

    public PersonMapEntry(Long key, Long value) {
        this.key = key;
        this.value = value;
        this.time=LocalTime.now().plusMinutes(10);
    }
    //    @ManyToOne
//    Person person;
}
