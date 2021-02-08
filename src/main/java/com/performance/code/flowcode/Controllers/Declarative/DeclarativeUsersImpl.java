package com.performance.code.flowcode.Controllers.Declarative;

import com.performance.code.flowcode.Entity.Users;
import com.performance.code.flowcode.Repository.UsersRepository;
import com.performance.code.flowcode.util.security.EncryptionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeclarativeUsersImpl {

    private UsersRepository usersRepository;
    private EncryptionUtils encryptionUtils = new EncryptionUtils();

    public DeclarativeUsersImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public void encryptPasswordUsersDec() {
        List<Users> usersList = usersRepository.findAll();
        usersList.stream()
                .filter(users -> !users.getPassword().startsWith("$"))
                .forEach(users -> {
                    users.setPassword(encryptionUtils.encoder().encode(users.getPassword()));
//                    usersRepository.save(users);
                });
    }


    public List<Users> findUsernameDeclarative(String userName) {
        List<Users> users = usersRepository.findAll();
        return users.stream()
                .filter(user -> user.getUsername().contains(userName))
                .collect(Collectors.toList());
    }


    public void changeFirstLetterUserDeclarative() {
        List<Users> allUsers = usersRepository.findAll();
        List<Users> emptyList = new ArrayList<>();
        allUsers
                .forEach(user -> {
                    user.setFirstName(changeFirstLetterToUpper(user.getFirstName()));
                    user.setLastName(changeFirstLetterToUpper(user.getLastName()));
                    emptyList.add(user);
//            usersRepository.save(user);
                });
    }

    private String changeFirstLetterToUpper(String string) {
        return String.valueOf(string.charAt(0)).toUpperCase() + String.valueOf(string.substring(1));
    }
}
