package com.performance.code.flowcode.TestsUsersMethods;

import com.performance.code.flowcode.Controllers.Imperative.ImperativeUsersImpl;
import com.performance.code.flowcode.Repository.UsersRepository;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SpringBootTest
class ImperativeUserTests {

    @Autowired
    ImperativeUsersImpl imperativeUsers;

    @Autowired
    UsersRepository usersRepository;

    @BeforeClass
    void setUp() {
    }

    @Test
    void contextLoads() {
    }


    @RepeatedTest(1)
    void testImperativeUser() {
        imperativeUsers.changeFirstLetterUsers();
    }

}
