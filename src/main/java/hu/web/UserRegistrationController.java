package hu.web;

import hu.service.UserService;
import hu.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for handling user registration.
 */
@Controller
@RequestMapping("/signup")
public class UserRegistrationController {

    private UserService userService;

    /**
     * Constructs a new UserRegistrationController with the specified UserService.
     *
     * @param userService the UserService to be used
     */
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Provides a model attribute for user registration.
     *
     * @return a new instance of UserRegistrationDto
     */
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    /**
     * Handles the GET request for showing the user registration form.
     *
     * @return the name of the signup view
     */
    @GetMapping
    public String showSignupForm() {
        return "signup";
    }

    /**
     * Handles the POST request for registering a new user account.
     *
     * @param registrationDto the UserRegistrationDto containing the user registration data
     * @return a redirect to the signup view with a success parameter if the registration is successful
     */
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/signup?success";
    }
}
