package com.performance.code.flowcode.controllers.Imperative;

import com.performance.code.flowcode.Entity.Users;
import com.performance.code.flowcode.util.security.EncryptionUtils;

import java.util.ArrayList;
import java.util.List;

public class ImperativeUsersImpl {

    public void encryptPasswordImperative(List<Users> users) {
        EncryptionUtils encryptionUtils = new EncryptionUtils();
        for (Users u : users) {
            if (!u.getPassword().startsWith("$"))
                u.setPassword(encryptionUtils.encoder().encode(u.getPassword()));
        }
    }

    public List<String> findFirstCharacters(List<Users> users, String firstCharacters) {
        List<String> emptyList = new ArrayList<>();
        for (Users u : users) {
            if (u.getFirstName().contains(firstCharacters)) {
                emptyList.add(u.getFirstName());
            }
        }
        return emptyList;
    }


}

