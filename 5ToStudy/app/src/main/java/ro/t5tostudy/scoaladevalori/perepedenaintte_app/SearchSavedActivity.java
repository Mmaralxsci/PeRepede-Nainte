package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

public class SearchSavedActivity extends AppCompatActivity {

    Button mBackBtn;
    Button mSearchBtn;
    ToggleButton mTesttezaBtn;
    EditText mSubject;
    EditText mGrade;
    EditText mProfile;
    EditText mChapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_saved);

        mBackBtn = findViewById(R.id.back_search_saved_btn);
        mSearchBtn = findViewById(R.id.search_search_saved_btn);
        mTesttezaBtn = findViewById(R.id.testteza_search_saved_tgl);
        mSubject = findViewById(R.id.subject_search_saved_et);
        mGrade = findViewById(R.id.grade_search_saved_et);
        mProfile = findViewById(R.id.profile_search_saved_et);
        mChapter = findViewById(R.id.chapter_search_saved_et);
    }

    public void openSavedActivity(View v){
        setResult(RESULT_OK);
        finish();

    }

    @SuppressLint("RestrictedApi")
    public void openListSavedActivity (View v) {

        mTesttezaBtn = findViewById(R.id.testteza_search_saved_tgl);

        final SearchParametersPackage parameters = new SearchParametersPackage();
        parameters.subject = mSubject.getText().toString();
        mTesttezaBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    parameters.testteza = mTesttezaBtn.getTextOn().toString();
                }
                else {
                    parameters.testteza = mTesttezaBtn.getTextOff().toString();
                }
            }
        });
        parameters.grade = mGrade.getText().toString();
        parameters.profil = mProfile.getText().toString();
        parameters.chapter = mChapter.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("subject", parameters.subject);
        bundle.putString("testteza", parameters.testteza);
        bundle.putString("grade", parameters.grade);
        bundle.putString("profil", parameters.profil);
        bundle.putString("chapter", parameters.chapter);
        Intent intentList = new Intent(SearchSavedActivity.this, ListSavedActivity.class);
        startActivityForResult(intentList, 1, bundle);
    }
}
