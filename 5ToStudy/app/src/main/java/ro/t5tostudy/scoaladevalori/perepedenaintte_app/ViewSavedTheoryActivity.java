package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewSavedTheoryActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_view_saved_theory);

        mTestBtn=findViewById(R.id.test_view_saved_theory_btn);
        mSubject=findViewById(R.id.subject_view_saved_theory_tv);
        mGrade=findViewById(R.id.grade_view_saved_theory_tv);
        mTestteza=findViewById(R.id.testteza_view_saved_theory_tv);
        mProfil=findViewById(R.id.profile_view_saved_theory_tv);
        mChapter=findViewById(R.id.chapter_view_saved_theory_tv);
        mTitle=findViewById(R.id.title_view_saved_theory_tv);
        mPublisher=findViewById(R.id.publisher_view_saved_theory_tv);
        mDescription=findViewById(R.id.description_view_saved_theory_tv);
        mTheory=findViewById(R.id.test_view_saved_theory_tv);
        mType=findViewById(R.id.file_type_view_saved_theory_tv);


        mSubject.setText(ViewSavedTestActivity.mTestPackage.getSubject());
        mGrade.setText(ViewSavedTestActivity.mTestPackage.getGrade());
        mTestteza.setText(ViewSavedTestActivity.mTestPackage.getTestteza());
        mProfil.setText(ViewSavedTestActivity.mTestPackage.getProfile());
        mChapter.setText(ViewSavedTestActivity.mTestPackage.getChapter());
        mTitle.setText(ViewSavedTestActivity.mTestPackage.getTitle());
        mPublisher.setText(ViewSavedTestActivity.mTestPackage.getPublisher());
        mDescription.setText(ViewSavedTestActivity.mTestPackage.getDescription());
        mTheory.setText(ViewSavedTestActivity.mTestPackage.getTheoryText());
        mType.setText("Teorie");
    }

    public void openViewSavedTestActivity(View v){
        finish();
    }
}
