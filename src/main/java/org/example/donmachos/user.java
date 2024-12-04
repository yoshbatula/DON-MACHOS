package org.example.donmachos;

 class User {
     private String EmailAddress;
     private String Username;
     private String Password;


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
