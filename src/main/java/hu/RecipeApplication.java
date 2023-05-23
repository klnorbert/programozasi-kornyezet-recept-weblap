package hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point of the Recipe Application.
 */
@SpringBootApplication
public class RecipeApplication {

    /**
     * The main method that starts the Recipe Application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(RecipeApplication.class, args);
    }

}
