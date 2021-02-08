package com.performance.code.flowcode.Entity;

import com.performance.code.flowcode.util.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamLongValue;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @PodamLongValue(minValue = 1, maxValue = 100)
    private Long id;

    private String firstName;
    private String lastName;

    private Integer cnp;
    @Max(100)
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date timestamp;
    private String username;
    private String password;
//    @Email
    private String email;

    @Override
    public String toString() {
        return "First name: " + firstName +
                " \nLast name: " + lastName +
                "\nCNP: " + cnp +
                "\nAge: " + age +
                "\nGender: " + gender +
                "\nTimestamp: " + timestamp +
                "\nEmail: " + email +
                "\nUsername: " + username +
                "\nPassword: " + password;
    }

    @OneToMany
    @PodamExclude
    List<Product> products;
}