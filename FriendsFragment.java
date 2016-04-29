package kr.co.stone_i.jin.kakaotalk;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.co.stone_i.jin.kakaotalk.model.FriendsAdapter;
import kr.co.stone_i.jin.kakaotalk.model.Person;
import kr.co.stone_i.jin.kakaotalk.ui.widget.SimpleDividerItemDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {


    public FriendsFragment() {
        // Required empty public constructor
    }

    RecyclerView friendList;
    FriendsAdapter friendsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        friendsAdapter = new FriendsAdapter();
        initData();
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        friendList = (RecyclerView)view.findViewById(R.id.list_friends);

        friendList.setAdapter(friendsAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        friendList.setLayoutManager(layoutManager);
        friendList.addItemDecoration(new SimpleDividerItemDecoration(getContext()));

        return view;
    }

    private void initData() {
        //setting dummy data
        for(int i = 0; i < 500; i++) {
            friendsAdapter.add(new Person(i,"양지연","사랑해"));
        }
    }

}
