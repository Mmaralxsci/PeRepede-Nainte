package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText mEmail;
    EditText mUsername;
    EditText mPassword;
    EditText mPasswordCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmail = findViewById(R.id.email_register_et);
        mUsername = findViewById(R.id.username_register_et);
        mPassword = findViewById(R.id.new_password_register_et);
        mPasswordCheck = findViewById(R.id.check_new_password_register_et);


    }

    public void CreateUser(View view) {
        if(mEmail.getText().toString().trim().equals("") ||
                mUsername.getText().toString().trim().equals("") ||
                mPassword.getText().toString().trim().equals("") ||
                mPasswordCheck.getText().toString().trim().equals("")) {
            Toast.makeText(RegisterActivity.this, "Toate campurile sunt obligatorii!",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if(! mPassword.getText().toString().equals(mPasswordCheck.getText().toString())) {
            Toast.makeText(RegisterActivity.this, "Parolele sunt diferite!",
                    Toast.LENGTH_LONG).show();
            return;
        }

        LoginActivity.userList.add(
                new UserPackage(mEmail.getText().toString(), mUsername.getText().toString(), mPassword.getText().toString()));
        setResult(RESULT_OK);
        Toast.makeText(RegisterActivity.this,
                "Contul a fost creat cu succes!",
                Toast.LENGTH_LONG).show();
        finish();
    }
}




