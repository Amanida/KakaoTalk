package kr.co.stone_i.jin.kakaotalk;

import android.os.PersistableBundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String TAB1 = "tab_friends";
    private static final String TAB2 = "tab_chats";
    private static final String TAB3 = "tab_etc";
    FragmentTabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabhost = (FragmentTabHost)findViewById(R.id.tabHost);

        tabhost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        tabhost.addTab(tabhost.newTabSpec(TAB1).setIndicator(getString(R.string.tab_friends)), FriendsFragment.class, null);
        tabhost.addTab(tabhost.newTabSpec(TAB2).setIndicator(getString(R.string.tab_chats)), ChatsFragment.class, null);
        tabhost.addTab(tabhost.newTabSpec(TAB3).setIndicator(getString(R.string.tab_etc)), EtcFragment.class, null);

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
