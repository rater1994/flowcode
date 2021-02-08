package com.performance.code.flowcode.Controllers.Imperative;

import com.performance.code.flowcode.Entity.Users;
import com.performance.code.flowcode.Repository.UsersRepository;
import com.performance.code.flowcode.util.security.EncryptionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImperativeUsersImpl {

    private UsersRepository usersRepository;

    public ImperativeUsersImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void encryptPasswordImperative() {
        List<Users> users = usersRepository.findAll();

        EncryptionUtils encryptionUtils = new EncryptionUtils();
        for (Users u : users) {
            if (!u.getPassword().startsWith("$"))
                u.setPassword(encryptionUtils.encoder().encode(u.getPassword()));
//            usersRepository.save(u);
        }
    }


    public List<Users> findUsername(String firstCharacters) {
        List<Users> users = usersRepository.findAll();
        List<Users> emptyList = new ArrayList<>();
        for (Users user : users) {
            if (user.getUsername().contains(firstCharacters)) {
                emptyList.add(user);
            }
        }
        return emptyList;
    }

    public void changeFirstLetterUsers() {
        List<Users> allUsers = usersRepository.findAll();
        for (Users allUser : allUsers) {
            allUser.setFirstName(changeFirstLetterToUpper(allUser.getFirstName()));
            allUser.setLastName(changeFirstLetterToUpper(allUser.getLastName()));
            usersRepository.save(allUser);
        }
    }

    private String changeFirstLetterToUpper(String string) {
        return String.valueOf(string.charAt(0)).toUpperCase() + String.valueOf(string.substring(1));
    }

}