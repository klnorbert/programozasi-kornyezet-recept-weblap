package hu.service;

import hu.model.User;
import hu.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  User save(UserRegistrationDto registrationDto);

}
