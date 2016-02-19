package esiea.wizzevents;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Jalil on 08/02/2016.
 */
public class PrefActivity extends ActionBarActivity implements View.OnClickListener {
    Button buttonValidPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        buttonValidPref = (Button) findViewById(R.id.buttonValidPref);

        buttonValidPref.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonValidPref:
                PrefActivity.this.finish();
                break;
        }
    }
}
