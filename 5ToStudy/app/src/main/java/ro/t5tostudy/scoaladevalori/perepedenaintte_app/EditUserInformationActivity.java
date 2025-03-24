package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditUserInformationActivity extends AppCompatActivity {

    TextView mUsername;
    TextView mPassword;
    EditText mUsernameEt;
    EditText mPasswordEt;
    EditText mPasswordCheckEt;
    Button mSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_information);

        mUsername = findViewById(R.id.username_edit_user_information_tv);
        mPassword = findViewById(R.id.password_edit_user_information_tv);
        mUsernameEt = findViewById(R.id.username_edit_user_information_et);
        mPasswordEt = findViewById(R.id.password_edit_user_information_et);
        mPasswordCheckEt = findViewById(R.id.check_password_edit_user_information_et);
        mSaveBtn = findViewById(R.id.edit_edit_user_information_btn);

        mUsername.setText("Nume curent: " + LoginActivity.userList.get(UserSignInActivity.userIndex).getUsername());
        mPassword.setText("Parola curenta: " + LoginActivity.userList.get(UserSignInActivity.userIndex).getPassword());
        mUsernameEt.setText(LoginActivity.userList.get(UserSignInActivity.userIndex).getUsername());

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPasswordEt.getText().toString().equals(mPasswordCheckEt.getText().toString())){
                    LoginActivity.userList.get(UserSignInActivity.userIndex).username = mUsernameEt.getText().toString();
                    LoginActivity.userList.get(UserSignInActivity.userIndex).password = mPasswordEt.getText().toString();
                    setResult(RESULT_OK);
                    finish();
                }else{
                    Toast.makeText(EditUserInformationActivity.this, "Parolele sunt diferite", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
