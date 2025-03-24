package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserSignInActivity extends AppCompatActivity {

    EditText mEmailEt;
    EditText mPassEt;
    Button mLoginBtn;
    public static int userIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_in);

        mEmailEt = (EditText) findViewById(R.id.email_user_sign_in_et);
        mPassEt = (EditText) findViewById(R.id.password_user_sign_in_et);
        mLoginBtn = (Button) findViewById(R.id.login_user_sign_in_btn);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for(UserPackage userPackage : LoginActivity.userList){
                    if(userPackage.getEmail().equals(mEmailEt.getText().toString()) &&
                            userPackage.getPassword().equals(mPassEt.getText().toString())){
                            userIndex = LoginActivity.userList.indexOf(userPackage);
                            startActivityForResult(new Intent(UserSignInActivity.this, ProfileActivity.class),
                                    1);
                    }else {
                        Toast.makeText(UserSignInActivity.this, "Date gresite", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });
    }
}