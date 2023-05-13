package hu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/games")
  public String games() {
    return "games";
  }

  @GetMapping("/matches")
  public String matches() {
    return "matches";
  }

}
