package com.performance.code.flowcode.TestsProductsMethods;

import com.performance.code.flowcode.Controllers.Imperative.ImperativeProductImpl;
import com.performance.code.flowcode.Controllers.Imperative.ImperativeUsersImpl;
import com.performance.code.flowcode.Entity.Product;
import com.performance.code.flowcode.Repository.UsersRepository;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

@SpringBootTest

public class ImperativeProductsTests {
    @Autowired
    ImperativeProductImpl imperativeProduct;

    @Autowired
    UsersRepository usersRepository;

    @BeforeClass
    void setUp() {
    }

    @Test
    void contextLoads() {
    }

    @RepeatedTest(1)
    void testFilterProducts() {
        imperativeProduct.findPriceByCategory("CategoryExample", 0.0, 500.0);
    }

}
