package kr.co.stone_i.jin.kakaotalk;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    final static String EXTRA_PROFILE_NAME = "name";
    final static String EXTRA_PROFILE_TEXT = "text";
    final static String EXTRA_PROFILE_PHONE = "phone";
    final static String EXTRA_PROFILE_IMAGE = "image";
    final static String EXTRA_PROFILE_BACKGROUND = "background";

    TextView nameView;
    TextView phoneView;
    TextView textView;
    ImageButton backgroundImage;
    ImageButton profileImage;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_profile);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#330000ff")));
//        actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#550000ff")));
        actionBar.setDisplayHomeAsUpEnabled(true);

        nameView = (TextView)findViewById(R.id.name_profile);
        phoneView = (TextView)findViewById(R.id.phone_profile);
        textView = (TextView)findViewById(R.id.text_profile);
        backgroundImage = (ImageButton)findViewById(R.id.image_background);
        profileImage = (ImageButton)findViewById(R.id.image_profile);

        b = getIntent().getExtras();
        nameView.setText(b.getString(EXTRA_PROFILE_NAME));
        phoneView.setText(b.getString(EXTRA_PROFILE_PHONE));
        textView.setText(b.getString(EXTRA_PROFILE_TEXT));
        backgroundImage.setImageResource(b.getInt(EXTRA_PROFILE_BACKGROUND));
        profileImage.setImageResource(b.getInt(EXTRA_PROFILE_IMAGE));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
