package esiea.wizzevents;

/**
 * Created by Jalil on 21/01/2016.
 */
public class User {
    String username, password, mail;
    int age,divertissement,solde,culture,sport;

    public User (String username, String password, String mail, int age, int divertissement, int solde, int culture, int sport){
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.age = age;
        this.divertissement = divertissement ;
        this.solde = solde ;
        this.culture = culture;
        this.sport = sport;
    }

    public User (String username, String password){
        this.username = username;
        this.password = password;
        this.mail = "";
        this.age = -1;
        this.divertissement = 0 ;
        this.solde = 0 ;
        this.culture = 0;
        this.sport = 0;
    }


}
