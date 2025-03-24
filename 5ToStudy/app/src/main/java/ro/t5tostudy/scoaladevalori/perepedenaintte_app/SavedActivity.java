package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SavedActivity extends AppCompatActivity {

    Button mBackBtn;
    Button mSearchBtn;
    ListView mListView;

    ArrayList<TestPackage> mAdapterList = new ArrayList<>();
    public static ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        mBackBtn = findViewById(R.id.back_posted_btn);
        mSearchBtn = findViewById(R.id.search_posted_btn);
        mListView = findViewById(R.id.posted_list_view);
        mAdapterList = (ArrayList<TestPackage>) LoginActivity.testList;

        if(LoginActivity.userList.get(UserSignInActivity.userIndex).savedTestPackage != null) {
            for (TestPackage testPackage : LoginActivity.userList.get(UserSignInActivity.userIndex).savedTestPackage) {

                mListView.setAdapter(listAdapter);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TestPackage testPackage = mAdapterList.get(position);
                        Intent intent = new Intent(SavedActivity.this, ViewSavedTestActivity.class);
                        Bundle b=new Bundle();
                        b.putSerializable("subject", testPackage.getSubject());
                        b.putSerializable("testteza", testPackage.getTestteza());
                        b.putSerializable("grade", testPackage.getGrade());
                        b.putSerializable("profile", testPackage.getProfile());
                        b.putSerializable("chapter", testPackage.getChapter());
                        b.putSerializable("title", testPackage.getTitle());
                        b.putSerializable("publisher", testPackage.getPublisher());
                        b.putSerializable("description", testPackage.getDescription());
                        b.putSerializable("test", testPackage.getTestText());
                        b.putSerializable("answer", testPackage.getAnswerText());
                        b.putSerializable("theory", testPackage.getTheoryText());
                        startActivityForResult(intent, 1, b);
                    }
                });
            }
        }
    }

    public void openSearchSavedActivity(View v) {
        startActivityForResult(new Intent(SavedActivity.this, SearchSavedActivity.class), 1);
    }

    public void openProfileActivity(View v){
        setResult(RESULT_OK);
        finish();
    }
}
