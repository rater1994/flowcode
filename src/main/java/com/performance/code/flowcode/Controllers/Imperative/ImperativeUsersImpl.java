package com.performance.code.flowcode.Controllers.Imperative;

import com.performance.code.flowcode.Entity.Users;
import com.performance.code.flowcode.Repository.UsersRepository;
import com.performance.code.flowcode.util.security.EncryptionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImperativeUsersImpl {

    private UsersRepository usersRepository;

    public ImperativeUsersImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

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

    public List<String> changeFirstLetterFromListImp() {
        List<Users> getAllUsers = usersRepository.findAll();
        List<String> allFirstNames = new ArrayList<>();

        for (Users users : getAllUsers) {
            List<Users> findFirstNames = usersRepository.findByLastName(users.getFirstName());

            usersRepository.saveAll(findFirstNames);
        }


        return allFirstNames;
    }

    private String changeFirstLetterToUpper(String string) {
        return String.valueOf(string.charAt(0)).toUpperCase() + String.valueOf(string.substring(1));
    }


}