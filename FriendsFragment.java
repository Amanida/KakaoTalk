package kr.co.stone_i.jin.kakaotalk;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.stone_i.jin.kakaotalk.model.FriendsAdapter;
import kr.co.stone_i.jin.kakaotalk.model.Person;
import kr.co.stone_i.jin.kakaotalk.ui.widget.SimpleDividerItemDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {

    final static String EXTRA_PROFILE_NAME = "name";
    final static String EXTRA_PROFILE_TEXT = "text";
    final static String EXTRA_PROFILE_PHONE = "phone";
    final static String EXTRA_PROFILE_IMAGE = "image";
    final static String EXTRA_PROFILE_BACKGROUND = "background";

    RecyclerView friendList;
    FriendsAdapter friendsAdapter;
    MainActivity mainActivity;

    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        friendsAdapter = new FriendsAdapter();
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        friendList = (RecyclerView)view.findViewById(R.id.list_friends);
        //Create RecyclerView
        initData();
        friendList.setAdapter(friendsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        friendList.setLayoutManager(layoutManager);
        friendList.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        friendsAdapter.setOnItemClickListener(new FriendsAdapter.OnItemClickListener(){
            @Override
            public void OnItemClicked(RecyclerView.ViewHolder holder, View view, Person p, int position) {
                Intent i = new Intent(getContext(), ProfileActivity.class);
                i.putExtra(EXTRA_PROFILE_NAME, p.getName());
                i.putExtra(EXTRA_PROFILE_TEXT,p.getText());
                i.putExtra(EXTRA_PROFILE_PHONE,p.getPhone());
                i.putExtra(EXTRA_PROFILE_IMAGE,p.getImage());
                i.putExtra(EXTRA_PROFILE_BACKGROUND,p.getBackground());
                startActivity(i);
            }
        });
        mainActivity = (MainActivity)getActivity();
        mainActivity.setToolbarTitle(getString(R.string.title_friends1),getFriendCount()+"");

        return view;
    }

    private void initData() {
        //setting dummy data
        for(int i = 0; i < 500; i++) {
            friendsAdapter.add(new Person(i,"양지연"+i,"사랑해"+i,"0101112222"));
        }
    }

    public int getFriendCount() {
        return friendsAdapter.getItemCount();
    }
}
