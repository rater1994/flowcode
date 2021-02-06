package com.performance.code.flowcode.Controllers.Declarative;

import com.performance.code.flowcode.Entity.Users;
import com.performance.code.flowcode.Repository.UsersRepository;
import com.performance.code.flowcode.util.security.EncryptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DeclarativeUsersImpl {

    private UsersRepository usersRepository;

    public DeclarativeUsersImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void encryptPasswordUsersDec(List<Users> usersList) {
        EncryptionUtils encryptionUtils = new EncryptionUtils();
        usersList.stream()
                .filter(users -> !users.getPassword().startsWith("$"))
                .forEach(users -> users.setPassword(encryptionUtils.encoder().encode(users.getPassword()))
                );
    }

    public List<Users> findUsername(List<Users> users, String userName) {
        return users.stream()
                .filter(users1 -> users1.getUsername().contains(userName))
                .collect(Collectors.toList());

    }

    public void changeFirstLetterUserDeclarative() {
        List<Users> allUsers = usersRepository.findAll();

        allUsers.stream()
                .forEach(user -> {
            user.setFirstName(changeFirstLetterToUpper(user.getFirstName()));
            user.setLastName(changeFirstLetterToUpper(user.getLastName()));
//            usersRepository.save(user);
        });
    }

    private String changeFirstLetterToUpper(String string) {
        return String.valueOf(string.charAt(0)).toUpperCase() + String.valueOf(string.substring(1));
    }
}
