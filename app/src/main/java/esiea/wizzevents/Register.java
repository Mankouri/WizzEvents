package esiea.wizzevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Register extends ActionBarActivity implements View.OnClickListener {

    Button bRegister;
    EditText etUsername, etPassword, etAge, etMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword =(EditText)findViewById(R.id.etPassword);
        etAge = (EditText)findViewById(R.id.etAge);
        etMail = (EditText)findViewById(R.id.etMail);
        bRegister = (Button)findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bRegister:
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String mail = etMail.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());

                User user = new User(username,password,mail,age);

                registerUser(user);
                break;
        }

    }

    private void registerUser(User user){
        ServeurRequests serveurRequests = new ServeurRequests(this);
        serveurRequests.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }


}
