package esiea.wizzevents;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
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
            AlertDialog show = new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.quit)
                    .setMessage(R.string.notification)
                    .setPositiveButton(R.string.yesContinu, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Stop the activity
                            startActivity(new Intent(MainActivity.this, Login.class));
                        }

                    })
                    .setNegativeButton(R.string.noStopAll, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Stop the activity
                            MainActivity.this.finish();
                        }

                    })
                    .show();
            /*  startActivity(new Intent(MainActivity.this, Login.class)); */
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
                startActivity(new Intent(this, MapActivity.class));
                break;

            case R.id.bInterest:
                startActivity(new Intent(this, PrefActivity.class));
                break;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //Ask the user if they want to quit
            AlertDialog show = new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.logout)
                    .setMessage(R.string.really_logout)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //On se déconnecte
                            userLocalStore.clearUserData();
                            userLocalStore.setUserLoggedIn(false);
                            MainActivity.this.finish();
                            startActivity(new Intent(MainActivity.this, Login.class));

                        }

                    })
                    .setNegativeButton(R.string.no, null)
                    .show();

            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
