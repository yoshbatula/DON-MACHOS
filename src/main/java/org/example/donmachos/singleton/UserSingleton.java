package org.example.donmachos.singleton;


public class UserSingleton {

    // 1. Static variable to hold the single instance of the User class
    private static UserSingleton instance;

    // 2. Instance variables for User properties
    private String EmailAddress;
    private String Username;
    private String Password;

    // 3. Private constructor to prevent instantiation from other classes
    private UserSingleton() {
        // Default constructor, can be initialized if needed
    }

    // 4. Public method to access the single instance of the User class
    public static UserSingleton getInstance() {
        if (instance == null) {
            // Lazy initialization: create the instance only when it's needed
            instance = new UserSingleton();
        }
        return instance;
    }

    // Getter and Setter methods for the User properties
    public String getEmailAddress() {
        return EmailAddress;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
