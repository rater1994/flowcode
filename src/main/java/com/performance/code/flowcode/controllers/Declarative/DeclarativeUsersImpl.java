package com.performance.code.flowcode.controllers.Declarative;

import com.performance.code.flowcode.Entity.Users;
import com.performance.code.flowcode.util.security.EncryptionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class DeclarativeUsersImpl {

//    public void encryptPasswordUsersDec(List<Users> usersList) {
//        EncryptionUtils encryptionUtils = new EncryptionUtils();
//        usersList
//                .forEach(u -> u.setPassword(encryptionUtils.encoder().encode(u.getPassword())));
//    }
//

//    public void encryptPasswordUsersDec(List<Users> usersList) {
//        EncryptionUtils encryptionUtils = new EncryptionUtils();
//        usersList
//                .forEach(u -> {
//                    if (!u.getPassword().startsWith("$")) {
//                        u.setPassword(encryptionUtils.encoder().encode(u.getPassword()));
//                    }
//                });
//    }


    public void encryptPasswordUsersDec(List<Users> usersList) {
        EncryptionUtils encryptionUtils = new EncryptionUtils();
        usersList.stream()
                .filter(users -> !users.getPassword().startsWith("$"))
                .forEach(users -> users.setPassword(encryptionUtils.encoder().encode(users.getPassword()))
        );
    }


    public List<Users> findFirstCharacters(List<Users> users, String firstCharacters) {
        return users.stream()
                .filter(u-> Boolean.parseBoolean(u.getFirstName().toLowerCase()) && u.getFirstName().contains(firstCharacters)).collect(Collectors.toList());
    }
}
