package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends AppCompatActivity {
    public static List<TestPackage> testList = new ArrayList<>();
    public static List<UserPackage> userList = new ArrayList<>();
    Button mLoginBtn;
    Button mRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginBtn = findViewById(R.id.login_login_btn);
        mRegisterBtn = findViewById(R.id.register_login_btn);
        userList.add(new UserPackage("admin@yahoo.com", "Administrator", "admin"));

        Toast.makeText(LoginActivity.this, "Bine ai venit!", Toast.LENGTH_LONG).show();
    }
    public void openUserSignInActivity(View v) {
        Intent intent = new Intent(LoginActivity.this,
                UserSignInActivity.class);
        startActivity(intent);
    }
    public void openRegisterActivity(View v) {
        Intent intent = new Intent(LoginActivity.this,
                RegisterActivity.class);
        startActivityForResult(intent, 1);
        Intent i = new Intent();
        Bundle bundle = i.getExtras();
    }

}
