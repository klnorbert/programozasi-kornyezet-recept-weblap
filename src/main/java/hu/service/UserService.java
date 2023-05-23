package hu.service;

import hu.model.User;
import hu.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Service interface for managing users.
 */
public interface UserService extends UserDetailsService {

    /**
     * Saves a new user.
     *
     * @param registrationDto the user registration data
     * @return the saved user
     */
    User save(UserRegistrationDto registrationDto);

}
