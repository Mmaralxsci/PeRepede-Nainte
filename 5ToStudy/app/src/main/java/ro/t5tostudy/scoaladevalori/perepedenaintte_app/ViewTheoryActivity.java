package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewTheoryActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_view_theory);

        mTestBtn=findViewById(R.id.test_view_theory_btn);
        mSubject=findViewById(R.id.subject_view_theory_tv);
        mGrade=findViewById(R.id.grade_view_theory_tv);
        mTestteza=findViewById(R.id.testteza_view_theory_tv);
        mProfil=findViewById(R.id.profile_view_theory_tv);
        mChapter=findViewById(R.id.chapter_view_theory_tv);
        mTitle=findViewById(R.id.title_view_theory_tv);
        mPublisher=findViewById(R.id.publisher_view_theory_tv);
        mDescription=findViewById(R.id.description_view_theory_tv);
        mTheory=findViewById(R.id.test_view_theory_tv);
        mType=findViewById(R.id.file_type_view_theory_tv);


        mSubject.setText(ViewTestActivity.mTestPackage.getSubject());
        mGrade.setText(ViewTestActivity.mTestPackage.getGrade());
        mTestteza.setText(ViewTestActivity.mTestPackage.getTestteza());
        mProfil.setText(ViewTestActivity.mTestPackage.getProfile());
        mChapter.setText(ViewTestActivity.mTestPackage.getChapter());
        mTitle.setText(ViewTestActivity.mTestPackage.getTitle());
        mPublisher.setText(ViewTestActivity.mTestPackage.getPublisher());
        mDescription.setText(ViewTestActivity.mTestPackage.getDescription());
        mTheory.setText(ViewTestActivity.mTestPackage.getTheoryText());
        mType.setText("Teorie");
    }

    public void openViewTestActivity(View v){
        finish();
    }
}
