package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void openProfileActivity(View v){
        setResult(RESULT_OK);
        finish();
    }

    public void btnSettings_onClick(View view){

        Intent intent= new Intent(SettingsActivity.this,EditUserInformationActivity.class);
        startActivityForResult(intent, 1);

    }
    public void btnRead_onclick (View view){

        Intent intent= new Intent(SettingsActivity.this,UserInformationActivity.class);
        startActivityForResult(intent, 1);
    }
}

