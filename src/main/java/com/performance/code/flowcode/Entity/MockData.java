package com.performance.code.flowcode.Entity;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamIntValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class MockData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PodamIntValue(maxValue = 1000)
    private int pricemock;
}
