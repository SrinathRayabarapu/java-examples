package com.user;

import java.util.Objects;

/**
 * Service class for user-related business operations.
 * 
 * <p>This class demonstrates service layer design with dependency injection,
 * commonly used in enterprise applications. It's also a good example for
 * unit testing with Mockito.</p>
 * 
 * <h3>Responsibilities:</h3>
 * <ul>
 *   <li>Validate user data before persistence</li>
 *   <li>Coordinate with repository for data access</li>
 *   <li>Throw appropriate exceptions for validation failures</li>
 * </ul>
 * 
 * <h3>Testing Notes:</h3>
 * <p>This service uses constructor injection, making it easy to mock
 * the {@link UserRepository} dependency in unit tests.</p>
 * 
 * @author Srinath.Rayabarapu
 * @see UserRepository
 * @see UserException
 */
public class UserService {

    /** Repository for user data persistence. */
    private UserRepository userRepository;

    /**
     * Constructs a UserService with the given repository.
     * 
     * <p>Constructor injection is preferred over field injection
     * as it makes dependencies explicit and facilitates testing.</p>
     *
     * @param userRepository the repository for user data operations
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Saves a user after validating required fields.
     * 
     * <p>Validation rules:</p>
     * <ul>
     *   <li>First name must not be null, empty, or blank</li>
     *   <li>Last name must not be null, empty, or blank</li>
     * </ul>
     *
     * @param user the user to save
     * @return the saved user
     * @throws UserException if validation fails or save operation fails
     */
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
