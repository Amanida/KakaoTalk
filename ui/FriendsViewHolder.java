package kr.co.stone_i.jin.kakaotalk.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kr.co.stone_i.jin.kakaotalk.R;
import kr.co.stone_i.jin.kakaotalk.model.Person;
import kr.co.stone_i.jin.kakaotalk.ui.widget.BezelImageView;

/**
 * Created by Jin on 2016-04-25.
 */
public class FriendsViewHolder extends RecyclerView.ViewHolder {
    private TextView nameView;
    private TextView textView;
    private BezelImageView imageView;


    public FriendsViewHolder(View itemView) {
        super(itemView);
        nameView = (TextView)itemView.findViewById(R.id.profile_name);
        textView = (TextView)itemView.findViewById(R.id.profile_text);
        imageView = (BezelImageView)itemView.findViewById(R.id.profile_image);
    }

    Person person;
    public void setPerson(Person p) {
        person = p;
        nameView.setText(p.getName());
        textView.setText(p.getText());
        imageView.setImageResource(R.drawable.person_image_empty);
    }
}
