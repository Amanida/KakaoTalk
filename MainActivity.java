package kr.co.stone_i.jin.kakaotalk;

import android.os.PersistableBundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAB1 = "tab_friends";
    private static final String TAB2 = "tab_chats";
    private static final String TAB3 = "tab_etc";
    FragmentTabHost tabhost;
    TextView toolbarTitle;
    TextView toolbarTitle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabhost = (FragmentTabHost)findViewById(R.id.tabHost);
        tabhost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        tabhost.addTab(tabhost.newTabSpec(TAB1).setIndicator(getString(R.string.tab_friends)), FriendsFragment.class, null);
        tabhost.addTab(tabhost.newTabSpec(TAB2).setIndicator(getString(R.string.tab_chats)), ChatsFragment.class, null);
        tabhost.addTab(tabhost.newTabSpec(TAB3).setIndicator(getString(R.string.tab_etc)), EtcFragment.class, null);
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                switch(tabId){
                    case TAB1:
                        setToolbarTitle(getString(R.string.title_friends1));
                        break;
                    case TAB2:
                        setToolbarTitle(getString(R.string.title_chats1),getString(R.string.title_chats2));
                        break;
                    case TAB3:
                        setToolbarTitle(getString(R.string.title_etc1),getString(R.string.title_etc2));
                        break;
                    default:
                        break;
                }
            }
        });
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("");
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimary));
        toolbarTitle = (TextView)findViewById(R.id.toolbar_title);
        toolbarTitle2 = (TextView)findViewById(R.id.toolbar_title2);

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    public void setToolbarTitle(String title) {
        toolbarTitle.setText(title);
    }

    public void setToolbarTitle(String title, String title2) {
        toolbarTitle.setText(title);
        toolbarTitle2.setText(title2);
    }
}
