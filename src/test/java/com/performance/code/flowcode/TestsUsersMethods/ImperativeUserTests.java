package com.performance.code.flowcode.TestsUsersMethods;

import com.performance.code.flowcode.Controllers.Imperative.ImperativeUsersImpl;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class ImperativeUserTests {

    @Autowired
    ImperativeUsersImpl imperativeUsers;

    @BeforeClass
    public void setUp() {
    }

    @Test
    void contextLoads() {
    }


    @RepeatedTest(1)
    void testImperativeUser() {
        imperativeUsers.changeFirstLetterFromListImp();
    }


}
