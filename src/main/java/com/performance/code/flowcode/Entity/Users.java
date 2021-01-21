package com.performance.code.flowcode.Entity;

import com.performance.code.flowcode.util.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @PodamExclude
    private Integer cnp;
    @Max(100)
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Date timestamp;

    @OneToMany
    List<Product> products;

    @Override
    public String toString() {
        return "Firt name: " + firstName +
                " \nLast name: " + lastName +
                "\nCNP: " + cnp +
                "\nAge: " + age +
                "\nGender: " + gender +
                "\nTimestamp: " + timestamp;
    }
}