package com.user;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class UserRepositoryImpl implements UserRepository {

    private Map<String, User> tempDatabase = new HashMap<>();

    @Override
    public boolean save(User user) {

        if (tempDatabase.containsKey(user.getId())){
            throw new UserException("User with same Id present!");
        }

        tempDatabase.put(user.getId(), user);
        log.info("User created successfully!");

        return true;
    }
}
