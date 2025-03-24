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

public class ListSavedActivity extends AppCompatActivity {

    Button mSearchBtn;
    ListView mListView;

    ArrayList<TestPackage> mAdapterList = new ArrayList<>();
    public static ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_saved);

        mSearchBtn = findViewById(R.id.search_list_saved_btn);
        mListView = findViewById(R.id.list_saved_list_view);
        mAdapterList = (ArrayList<TestPackage>) LoginActivity.testList;

        Intent intentList = getIntent();
        Bundle bundle = intentList.getExtras();


        if(LoginActivity.userList.get(UserSignInActivity.userIndex).savedTestPackage!= null) {
            for (TestPackage testPackage : LoginActivity.userList.get(UserSignInActivity.userIndex).savedTestPackage) {
                if(testPackage.subject.equals(bundle.getString("subject"))&&
                        testPackage.testteza.equals(bundle.getString("testteza"))&&
                        testPackage.grade.equals(bundle.getString("grade"))&&
                        testPackage.profile.equals(bundle.getString("profil"))&&
                        testPackage.chapter.equals(bundle.getString("chapter"))){

                    mListView.setAdapter(listAdapter);

                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @SuppressLint("RestrictedApi")
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            TestPackage testPackage = mAdapterList.get(position);
                            Intent intent = new Intent(ListSavedActivity.this, ViewSavedTestActivity.class);
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
                };
            }
        }
    }
    public void openSearchSavedActivity(View v) {
        setResult(RESULT_OK);
        finish();
    }
}
