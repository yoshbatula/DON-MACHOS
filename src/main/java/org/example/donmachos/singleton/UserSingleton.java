package org.example.donmachos.singleton;


public class UserSingleton {

    private static UserSingleton instance;

    private String EmailAddress;
    private String Username;
    private String Password;

    private UserSingleton() {

    }

    public static UserSingleton getInstance() {
        if (instance == null) {

            instance = new UserSingleton();
        }
        return instance;
    }

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
