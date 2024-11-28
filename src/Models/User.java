package Models;

import DAO.enums.Gender;

public class User {
    private long id=0;
    private String userName;
    private String phoneNumber;
    private String gmail;
    private String password;
    private Gender gender;
    private int user = 0;

    public User() {
        user++;
        id++;
    }

    public User( String password, String gmail, String phoneNumber, String userName , Gender gender) {
        this.id ++;
        this.password = password;
        this.gmail = gmail;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.gender=gender;
        this.user++;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User" +user+
                "\nid         : " + id +
                "\nuserName   : " + getUserName() +
                "\nphoneNumber: " + phoneNumber +
                "\ngmail      : " + gmail +
                "\npassword   : " + password+
                "\nGender     : "+ gender
                ;
    }
}
