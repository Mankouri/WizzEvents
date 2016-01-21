package esiea.wizzevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/* PST4 - CHESNAIS BERDAOUI GULL MANKOURI */

public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Button bLogout, bMap, bInterest;
    EditText etUsername, etAge, etMail;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText)findViewById(R.id.etUsername);
        etAge = (EditText)findViewById(R.id.etAge);
        etMail = (EditText)findViewById(R.id.etMail);

        bLogout = (Button)findViewById(R.id.bLogout);
        bLogout.setOnClickListener(this);

        bMap= (Button)findViewById(R.id.bMap);
        bMap.setOnClickListener(this);

        bInterest = (Button)findViewById(R.id.bInterest);
        bInterest.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);


    }

    @Override
    protected void onStart(){
        super.onStart();
        if (authenticate() == true){
            displayUserDetails();
        }else{
            startActivity(new Intent(MainActivity.this, Login.class));
        }
    }

    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();

    }

    private void displayUserDetails(){
        User user = userLocalStore.getLoggedInUser();
        etUsername.setText(user.username);
        etMail.setText(user.mail);
        etAge.setText(user.age + "");
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bLogout:

                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);

                startActivity(new Intent(this, Login.class));
                break;

            case R.id.bMap:

                break;

            case R.id.bInterest:

                break;
        }

    }



}
