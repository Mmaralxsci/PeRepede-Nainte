package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewTestActivity extends AppCompatActivity {

    Button mBackBtn;
    Button mAnswerBtn;
    Button mTheoryBtn;
    Button mSaveBtn;
    TextView mSubject;
    TextView mGrade;
    TextView mTestteza;
    TextView mProfile;
    TextView mChapter;
    TextView mTitle;
    TextView mPublisher;
    TextView mDescription;
    TextView mFileType;
    TextView mTestText;
    public static TestPackage mTestPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test);

        mBackBtn = findViewById(R.id.back_view_test_btn);
        mAnswerBtn = findViewById(R.id.answer_view_test_btn);
        mTheoryBtn = findViewById(R.id.theory_view_test_btn);
        mSaveBtn = findViewById(R.id.save_view_test_btn);
        mSubject=findViewById(R.id.subject_view_test_tv);
        mGrade=findViewById(R.id.grade_view_test_tv);
        mTestteza=findViewById(R.id.testteza_view_test_tv);
        mProfile=findViewById(R.id.profile_view_test_tv);
        mChapter=findViewById(R.id.chapter_view_test_tv);
        mTitle=findViewById(R.id.title_view_test_tv);
        mPublisher=findViewById(R.id.publisher_view_test_tv);
        mDescription=findViewById(R.id.description_view_test_tv);
        mFileType=findViewById(R.id.file_type_view_test_tv);
        mTestText=findViewById(R.id.test_view_test_tv);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final TestPackage testPackage=new TestPackage(bundle.getString("subject"), bundle.getString("testteza"), bundle.getString("grade"), bundle.getString("profil"), bundle.getString("chapter"),
                bundle.getString("title"), bundle.getString("description"), bundle.getString("publisher"),
                bundle.getString("test"), bundle.getString("answer"), bundle.getString("theory"));
        mTestPackage=testPackage;

        mSubject.setText(testPackage.getSubject());
        mGrade.setText(testPackage.getGrade());
        mTestteza.setText(testPackage.getTestteza());
        mProfile.setText(testPackage.getProfile());
        mChapter.setText(testPackage.getChapter());
        mTitle.setText(testPackage.getTitle());
        mPublisher.setText(testPackage.getPublisher());
        mDescription.setText(testPackage.getDescription());
        mFileType.setText("Test");
        mTestText.setText(testPackage.getTestText());

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!LoginActivity.userList.get(UserSignInActivity.userIndex).savedTestPackage.contains(testPackage)){
                    UserPackage userPackage = new UserPackage(LoginActivity.userList.get(UserSignInActivity.userIndex).getEmail(),
                            LoginActivity.userList.get(UserSignInActivity.userIndex).getUsername(),
                            LoginActivity.userList.get(UserSignInActivity.userIndex).getPassword());
                    userPackage.savedTestPackage = LoginActivity.userList.get(UserSignInActivity.userIndex).getSavedTestPackage();
                    userPackage.postedTestPackage = LoginActivity.userList.get(UserSignInActivity.userIndex).getPostedTestPackage();
                    userPackage.savedTestPackage.add(testPackage);
                    LoginActivity.userList.set(UserSignInActivity.userIndex, userPackage);
                    return;
                }else{
                    Toast.makeText(ViewTestActivity.this, "Testul este deja salvat", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void openListActivity(View v){
        setResult(RESULT_OK);
        finish();
    }

    public void openViewAnswerActivity (View v){
        startActivityForResult(new Intent(ViewTestActivity.this, ViewAnswerActivity.class), 1);
    }

    public void openViewTheoryActivity (View v){
        startActivityForResult(new Intent(ViewTestActivity.this, ViewTheoryActivity.class), 1);
    }
}
