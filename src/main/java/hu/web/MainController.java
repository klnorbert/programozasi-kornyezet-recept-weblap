package hu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling main routes.
 */
@Controller
public class MainController {

    /**
     * Handles the "/login" route.
     *
     * @return the name of the login view
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Handles the "/" route.
     *
     * @return the name of the index view
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * Handles the "/recipes" route.
     *
     * @return the name of the recipes view
     */
    @GetMapping("/recipes")
    public String recipes() {
        return "recipes";
    }

}
