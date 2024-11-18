package org.example.donmachos;

 class User {
     private String EmailAddress;
     private String Username;
     private String Password;

     public User(String emailAddress, String username, String password) {
         EmailAddress = emailAddress;
         Username = username;
         Password = password;
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
 }
