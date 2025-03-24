package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewPostedTestActivity extends AppCompatActivity {

    Button mBackBtn;
    Button mAnswerBtn;
    Button mTheoryBtn;
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
        setContentView(R.layout.activity_view_posted_test);

        mBackBtn = findViewById(R.id.back_view_posted_test_btn);
        mAnswerBtn = findViewById(R.id.answer_view_posted_test_btn);
        mTheoryBtn = findViewById(R.id.theory_view_posted_test_btn);
        mSubject=findViewById(R.id.subject_view_posted_test_tv);
        mGrade=findViewById(R.id.grade_view_posted_test_tv);
        mTestteza=findViewById(R.id.testteza_view_posted_test_tv);
        mProfile=findViewById(R.id.profile_view_posted_test_tv);
        mChapter=findViewById(R.id.chapter_view_posted_test_tv);
        mTitle=findViewById(R.id.title_view_posted_test_tv);
        mPublisher=findViewById(R.id.publisher_view_posted_test_tv);
        mDescription=findViewById(R.id.description_view_posted_test_tv);
        mFileType=findViewById(R.id.file_type_view_posted_test_tv);
        mTestText=findViewById(R.id.test_view_posted_test_tv);
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

    }

    public void openPostedActivity(View v){
        setResult(RESULT_OK);
        finish();
    }

    public void openViewPostedAnswerActivity (View v){
        startActivityForResult(new Intent(ViewPostedTestActivity.this, ViewAnswerActivity.class), 1);
    }

    public void openViewPostedTheoryActivity (View v){
        startActivityForResult(new Intent(ViewPostedTestActivity.this, ViewTheoryActivity.class), 1);
    }
}
