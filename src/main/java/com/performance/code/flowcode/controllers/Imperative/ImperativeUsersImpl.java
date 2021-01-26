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

    public List<Users> findUsername(List<Users> users, String firstCharacters) {
        List<Users> emptyList = new ArrayList<>();
        for (Users u : users) {
            if (u.getUsername().contains(firstCharacters)) {
                emptyList.add(u);
            }
        }
        return emptyList;
    }
}