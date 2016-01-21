package esiea.wizzevents;

/**
 * Created by Jalil on 21/01/2016.
 */
public class User {
    String username, password, mail;
    int age;

    public User (String username, String password, String mail, int age){
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.age = age;
    }

    public User (String username, String password){
        this.username = username;
        this.password = password;
        this.mail = "";
        this.age = -1;
    }


}
