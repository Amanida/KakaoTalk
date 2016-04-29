package kr.co.stone_i.jin.kakaotalk.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kr.co.stone_i.jin.kakaotalk.R;
import kr.co.stone_i.jin.kakaotalk.ui.FriendsViewHolder;

/**
 * Created by Jin on 2016-04-25.
 */
public class FriendsAdapter extends RecyclerView.Adapter<FriendsViewHolder> {
    List<Person> friends = new ArrayList<Person>();

    public void add(Person p) {
        friends.add(p);
        notifyDataSetChanged();
    }

    public void remove(Person p) {
        friends.remove(p);
        notifyDataSetChanged();
    }

    public void addAll(List<Person> items) {
        this.friends.addAll(items);
        notifyDataSetChanged();
    }

    public void clear() {
        friends.clear();
        notifyDataSetChanged();
    }

    @Override
    public FriendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_friends, parent, false);
        return new FriendsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendsViewHolder holder, int position) {
        holder.setPerson(getItem(position));
    }

    private Person getItem(int position) {
        return friends.get(position);
    }
    @Override
    public int getItemCount() {
        return friends.size();
    }

}
