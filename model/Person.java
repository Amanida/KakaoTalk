package kr.co.stone_i.jin.kakaotalk.model;

import android.support.annotation.DrawableRes;

import java.io.Serializable;

import kr.co.stone_i.jin.kakaotalk.R;

/**
 * Created by Jin on 2016-04-25.
 */
public class Person {
    private int id;
    private String name;
    private String text;
    private String phone;
    private @DrawableRes int image;
    private @DrawableRes int background;

    public Person(int id, String name, String text, String phone){
        this.id = id;
        this.name = name;
        this.text = text;
        this.phone = phone;
        this.image = R.drawable.person_image_empty;
        this.background = R.drawable.person_image_empty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }
}
