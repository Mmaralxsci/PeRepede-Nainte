package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewSavedAnswerActivity extends AppCompatActivity {

    Button mTestBtn;
    TextView mSubject;
    TextView mGrade;
    TextView mTestteza;
    TextView mProfil;
    TextView mChapter;
    TextView mTitle;
    TextView mPublisher;
    TextView mDescription;
    TextView mAnswer;
    TextView mFileType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_saved_answer);

        mTestBtn=findViewById(R.id.test_view_saved_answer_btn);
        mSubject=findViewById(R.id.subject_view_saved_answer_tv);
        mGrade=findViewById(R.id.grade_view_saved_answer_tv);
        mTestteza=findViewById(R.id.testteza_view_saved_answer_tv);
        mProfil= findViewById(R.id.profile_view_saved_answer_tv);
        mChapter=findViewById(R.id.chapter_view_saved_answer_tv);
        mTitle=findViewById(R.id.title_view_saved_answer_tv);
        mPublisher=findViewById(R.id.publisher_view_saved_answer_tv);
        mDescription=findViewById(R.id.description_view_saved_answer_tv);
        mAnswer=findViewById(R.id.test_view_saved_answer_tv);
        mFileType=findViewById(R.id.file_type_view_saved_answer_tv);

        mSubject.setText(ViewSavedTestActivity.mTestPackage.getSubject());
        mGrade.setText(ViewSavedTestActivity.mTestPackage.getGrade());
        mTestteza.setText(ViewSavedTestActivity.mTestPackage.getTestteza());
        mProfil.setText(ViewSavedTestActivity.mTestPackage.getProfile());
        mChapter.setText(ViewSavedTestActivity.mTestPackage.getChapter());
        mTitle.setText(ViewSavedTestActivity.mTestPackage.getTitle());
        mPublisher.setText(ViewSavedTestActivity.mTestPackage.getPublisher());
        mDescription.setText(ViewSavedTestActivity.mTestPackage.getDescription());
        mAnswer.setText(ViewSavedTestActivity.mTestPackage.getAnswerText());
        mFileType.setText("Răspuns");
    }

    public void openViewSavedTestActivity(View v){
        finish();
    }
}
