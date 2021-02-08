package com.performance.code.flowcode.TestsUsersMethods;

import com.performance.code.flowcode.Controllers.Declarative.DeclarativeUsersImpl;
import com.performance.code.flowcode.Entity.Users;
import com.performance.code.flowcode.Repository.UsersRepository;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

@SpringBootTest
public class DeclarativeUserTests {

    @Autowired
    DeclarativeUsersImpl declarativeUsersImpl;

    @Autowired
    UsersRepository usersRepository;

    @BeforeClass
    void setUp() {
    }

    @Test
    void contextLoads() {
    }

    @RepeatedTest(1)
    void testChangeFirstLetterDeclarativeUser() {
        declarativeUsersImpl.changeFirstLetterUserDeclarative();
    }

    @RepeatedTest(1)
    void testEncrypt() {
        declarativeUsersImpl.encryptPasswordUsersDec();
    }

    @RepeatedTest(1)
    void findUsernameDec() {
        declarativeUsersImpl.findUsernameDeclarative("yJXB1gyCG9");
    }

}
