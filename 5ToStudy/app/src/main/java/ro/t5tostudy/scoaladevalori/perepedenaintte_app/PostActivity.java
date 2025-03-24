package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

public class PostActivity extends AppCompatActivity {

    Button mProfileBtn;
    Button mPostBtn;
    ToggleButton mTesttezaBtn;
    EditText mSubject;
    EditText mGrade;
    EditText mProfile;
    EditText mChapter;
    EditText mTitle;
    EditText mDescription;
    EditText mTestText;
    EditText mAnswerText;
    EditText mTheoryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mProfileBtn = findViewById(R.id.back_post_btn);
        mPostBtn = findViewById(R.id.post_post_btn);
        mTesttezaBtn = findViewById(R.id.testteza_post_tgl);
        mSubject = findViewById(R.id.subject_post_et);
        mGrade = findViewById(R.id.grade_post_et);
        mProfile = findViewById(R.id.profile_post_et);
        mChapter = findViewById(R.id.chapter_post_et);
        mTitle = findViewById(R.id.title_post_et);
        mDescription = findViewById(R.id.description_post_et);
        mTestText = findViewById(R.id.test_post_et);
        mAnswerText = findViewById(R.id.answer_post_et);
        mTheoryText = findViewById(R.id.theory_post_et);

        mTesttezaBtn.setChecked(false);
        mPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TestPackage testPackage = new TestPackage();
                testPackage.subject = mSubject.getText().toString();
                mTesttezaBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked) {
                            testPackage.testteza = mTesttezaBtn.getTextOn().toString();
                        }
                        else {
                            testPackage.testteza = mTesttezaBtn.getTextOff().toString();
                        }
                    }
                });
                testPackage.grade = mGrade.getText().toString();
                testPackage.profile = mProfile.getText().toString();
                testPackage.chapter = mChapter.getText().toString();
                testPackage.title = mTitle.getText().toString();
                testPackage.description = mDescription.getText().toString();
                testPackage.publisher = LoginActivity.userList.get(UserSignInActivity.userIndex).getUsername();
                testPackage.testText = mTestText.getText().toString();
                testPackage.answerText = mAnswerText.getText().toString();
                testPackage.theoryText = mTheoryText.getText().toString();

                LoginActivity.testList.add(testPackage);

                UserPackage userPackage = new UserPackage(LoginActivity.userList.get(UserSignInActivity.userIndex).getEmail(),
                        LoginActivity.userList.get(UserSignInActivity.userIndex).getUsername(),
                        LoginActivity.userList.get(UserSignInActivity.userIndex).getPassword());
                userPackage.savedTestPackage = LoginActivity.userList.get(UserSignInActivity.userIndex).getSavedTestPackage();
                userPackage.postedTestPackage = LoginActivity.userList.get(UserSignInActivity.userIndex).getPostedTestPackage();
                userPackage.postedTestPackage.add(testPackage);
                LoginActivity.userList.set(UserSignInActivity.userIndex, userPackage);

                setResult(RESULT_OK);
                ProfileActivity.resultCode = true;
                finish();
            }
        });
    }

    public void openProfileActivity(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
}

