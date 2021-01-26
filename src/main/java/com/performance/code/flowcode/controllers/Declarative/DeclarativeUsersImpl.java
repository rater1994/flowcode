package com.performance.code.flowcode.controllers.Declarative;

import com.performance.code.flowcode.Entity.Users;
import com.performance.code.flowcode.util.security.EncryptionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class DeclarativeUsersImpl {


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
}