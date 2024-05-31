package com.lewis.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Person {

    private String firstName;
    private String lastName;
    private int age;

}
