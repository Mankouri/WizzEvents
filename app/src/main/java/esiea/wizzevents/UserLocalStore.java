package esiea.wizzevents;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jalil on 21/01/2016.
 */
public class UserLocalStore {
    public static final String SP_NAME = "detailUtilisateur";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void  storeUserData (User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();

        spEditor.putString("username",user.username);
        spEditor.putString("password",user.password);
        spEditor.putString("mail",user.mail);
        spEditor.putInt("age",user.age);

        spEditor.putInt("divertissement",user.divertissement);
        spEditor.putInt("solde",user.solde);
        spEditor.putInt("culture",user.culture);
        spEditor.putInt("sport",user.sport);

        spEditor.commit();
    }

    public User getLoggedInUser(){
        String username = userLocalDatabase.getString("username","");
        String password = userLocalDatabase.getString("password","");
        String mail = userLocalDatabase.getString("mail","");
        int age = userLocalDatabase.getInt("age",-1);

        int divertissement = userLocalDatabase.getInt("divertissement",0);
        int solde = userLocalDatabase.getInt("solde",0);
        int culture = userLocalDatabase.getInt("culture",0);
        int sport = userLocalDatabase.getInt("sport",0);

        User storedUser = new User(username,password,mail,age,divertissement,solde,culture,sport);

        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public Boolean getUserLoggedIn(){

        if(userLocalDatabase.getBoolean("loggedIn",false) == true ){
            return true;
        }else{
            return false;
        }

    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();

    }
}
