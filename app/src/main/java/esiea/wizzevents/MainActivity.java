package esiea.wizzevents;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Button bLogout, bMap, bInterest;
    EditText etUsername, etAge, etMail;

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


    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bLogout:

                break;

            case R.id.bMap:

                break;

            case R.id.bInterest:

                break;
        }

    }



}
