package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView mUsername;
    ImageButton mProfilePicture;
    Button mSearchBtn;
    Button mTestsBtn;
    Button mPostBtn;
    Button mPostedBtn;
    Button mSavedBtn;
    Button mSettingsBtn;
    UserPackage userPackage;
    public static boolean resultCode;
    public static String picturePath;
    int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mUsername = findViewById(R.id.username_profile_tv);
        mProfilePicture = findViewById(R.id.profile_imgv);
        mSearchBtn = findViewById(R.id.search_profile_btn);
        mTestsBtn = findViewById(R.id.tests_profile_btn);
        mPostBtn = findViewById(R.id.post_profile_btn);
        mPostedBtn = findViewById(R.id.posted_profile_btn);
        mSavedBtn = findViewById(R.id.saved_profile_btn);
        mSettingsBtn = findViewById(R.id.settings_profile_btn);

        userPackage = LoginActivity.userList.get(UserSignInActivity.userIndex);
        if (userPackage != null) {
            mUsername.setText(userPackage.username);
        }

        mProfilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });
    }

    public void openUserSignInActivity(View v){
        setResult(RESULT_OK);
        finish();
    }

    public void openSearchActivity(View v) {
        Intent intent = new Intent(ProfileActivity.this, SearchActivity.class);
        intent.putExtra("userPackage", userPackage);
        startActivityForResult(intent, -1);
    }

    public void openCalendarApp(View v){
        long startMillis;
        startMillis = System.currentTimeMillis();
        Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
        builder.appendPath("time");
        ContentUris.appendId(builder, startMillis);
        Intent intent = new Intent(Intent.ACTION_VIEW)
                .setData(builder.build());
        startActivity(intent);
    }

    public void openPostActivity(View v) {
        Intent intent = new Intent(ProfileActivity.this, PostActivity.class);
        intent.putExtra("userPackage", userPackage);
        startActivityForResult(intent, -1);
    }

    public void openPostedActivity(View v) {
        Intent intent = new Intent(ProfileActivity.this, PostedActivity.class);
        intent.putExtra("userPackage", userPackage);
        startActivityForResult(intent, -1);
    }

    public void openSavedActivity(View v) {
        Intent intent = new Intent(ProfileActivity.this, SavedActivity.class);
        intent.putExtra("userPackage", userPackage);
        startActivityForResult(intent, -1);
    }

    public void openSettingsActivity(View v) {
        Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
        intent.putExtra("userPackage", userPackage);
        startActivityForResult(intent, -1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);

        mProfilePicture = findViewById(R.id.profile_imgv);

        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != intent){
            Uri selectedImage = intent.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn,
                    null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();

            mProfilePicture.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}
