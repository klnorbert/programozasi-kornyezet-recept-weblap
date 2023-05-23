package hu.web.dto;

/**
 * Data transfer object for user registration.
 */
public class UserRegistrationDto {

    private String username;
    private String email;
    private String password;

    /**
     * Constructs an empty UserRegistrationDto object.
     */
    public UserRegistrationDto() {

    }

    /**
     * Constructs a UserRegistrationDto object with the specified username, email, and password.
     *
     * @param username the username
     * @param email    the email
     * @param password the password
     */
    public UserRegistrationDto(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Returns the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
