package com.example.Smart.entity;

import com.example.Smart.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class PersonMap extends BaseEntity<Long> {

    //    @ManyToOne
//    Customer customer;
    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;
    @JoinColumn(name = "key_value")
    Long key;
    Long value;
    LocalTime time;

    public PersonMap(Long key, Long value) {
        this.key = key;
        this.value = value;
        this.time = LocalTime.now().plusMinutes(1);
    }
    //    @ManyToOne
//    Person person;
}
