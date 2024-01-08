package com.user;

import java.util.Objects;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){

        if(Objects.isNull(user.getFirstName()) || user.getFirstName().isBlank() || user.getFirstName().isEmpty()){
            throw new UserException("User First name is either null or blank/empty!");
        }

        if(Objects.isNull(user.getLastName()) || user.getLastName().isBlank() || user.getLastName().isEmpty()){
            throw new UserException("User Last name is either null or blank/empty!");
        }

        boolean isSaved = userRepository.save(user);

        if(!isSaved){
            throw new UserException("Unable to create User!");
        }

        return user;
    }

}
