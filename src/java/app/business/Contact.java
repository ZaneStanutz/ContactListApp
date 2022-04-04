
package app.business;

import java.io.Serializable;


public class Contact implements Serializable {
    
    private String email; //varchar(50)
    private String firstName; // varchar(50)
    private String lastName; // varchar(50)
    private String phoneNumber; // varchar(15)
    
    public Contact() {
        
        email = ""; 
        firstName = "";
        lastName = "";
        phoneNumber = "";
        
    }
    
    public Contact(String firstName, String lastName, String email, String phoneNumber) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        
    }
    
    
    // setters
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    
    // getters
    
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
} // class