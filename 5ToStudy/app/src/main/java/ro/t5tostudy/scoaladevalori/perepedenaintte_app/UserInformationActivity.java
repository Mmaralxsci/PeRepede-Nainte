package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserInformationActivity extends AppCompatActivity {

    Button mBackBtn;
    TextView mUsername;
    TextView mEmail;
    TextView mPassword;
    ImageView mProfilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        mBackBtn = findViewById(R.id.back_user_information_btn);
        mUsername = findViewById(R.id.username_user_information_tv);
        mEmail = findViewById(R.id.email_user_information_tv);
        mPassword = findViewById(R.id.password_user_information_tv);
        mProfilePicture = findViewById(R.id.user_information_imgv);

        mUsername.setText(LoginActivity.userList.get(UserSignInActivity.userIndex).getUsername());
        mEmail.setText(LoginActivity.userList.get(UserSignInActivity.userIndex).getEmail());
        mPassword.setText(LoginActivity.userList.get(UserSignInActivity.userIndex).getPassword());
        mProfilePicture.setImageBitmap(BitmapFactory.decodeFile(ProfileActivity.picturePath));
    }

    public void openSettingsActivity(View v){
        setResult(RESULT_OK);
        finish();
    }
}
