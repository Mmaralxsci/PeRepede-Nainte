package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewPostedTheoryActivity extends AppCompatActivity {

    Button mTestBtn;
    TextView mSubject;
    TextView mGrade;
    TextView mTestteza;
    TextView mProfil;
    TextView mChapter;
    TextView mTitle;
    TextView mPublisher;
    TextView mDescription;
    TextView mTheory;
    TextView mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_posted_theory);

        mTestBtn=findViewById(R.id.test_view_posted_theory_btn);
        mSubject=findViewById(R.id.subject_view_posted_theory_tv);
        mGrade=findViewById(R.id.grade_view_posted_theory_tv);
        mTestteza=findViewById(R.id.testteza_view_posted_theory_tv);
        mProfil=findViewById(R.id.profile_view_posted_theory_tv);
        mChapter=findViewById(R.id.chapter_view_posted_theory_tv);
        mTitle=findViewById(R.id.title_view_posted_theory_tv);
        mPublisher=findViewById(R.id.publisher_view_posted_theory_tv);
        mDescription=findViewById(R.id.description_view_posted_theory_tv);
        mTheory=findViewById(R.id.test_view_posted_theory_tv);
        mType=findViewById(R.id.file_type_view_posted_theory_tv);


        mSubject.setText(ViewPostedTestActivity.mTestPackage.getSubject());
        mGrade.setText(ViewPostedTestActivity.mTestPackage.getGrade());
        mTestteza.setText(ViewPostedTestActivity.mTestPackage.getTestteza());
        mProfil.setText(ViewPostedTestActivity.mTestPackage.getProfile());
        mChapter.setText(ViewPostedTestActivity.mTestPackage.getChapter());
        mTitle.setText(ViewPostedTestActivity.mTestPackage.getTitle());
        mPublisher.setText(ViewPostedTestActivity.mTestPackage.getPublisher());
        mDescription.setText(ViewPostedTestActivity.mTestPackage.getDescription());
        mTheory.setText(ViewPostedTestActivity.mTestPackage.getTheoryText());
        mType.setText("Teorie");
    }

    public void openViewPostedTestActivity(View v){
        finish();
    }
}
