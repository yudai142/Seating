package com.dd_career.seating;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

// 利用者情報使用方法を提供する.
public class Users {
    public static final String SIZE = "Users_size";
    private List<User> users = new ArrayList<>();

    public Users() {
    }

    public void add(User user) {
        users.add(user);
    }

    public void clear() {
        users.clear();
    }

    public User findUserById(int id) {
        for (User user : users) {
            if ((user != null) && (user.getId() == id)) {
                return user;
            }
        }

        return null;
    }

    public List<User> get() {
        return users;
    }

    public User get(int index) {
        return users.get(index);
    }

    public int[] getIds() {
        int[] ids = new int[users.size()];
        int index = 0;

        for (User user : users) {
            ids[index++] = user.getId();
        }

        return ids;
    }

    public String[] getNames() {
        String[] names = new String[users.size()];
        int index = 0;

        for (User user : users) {
            names[index++] = user.getName();
        }

        return names;
    }

    public void load(Bundle input) {
        int count = input.getInt(SIZE);

        for (int index = 0; index < count; index++) {
            users.add(new User(index, input));
        }
    }

    public void loadDemo(Resources resources) throws Exception {
        try (XmlResourceParser parser = resources.getXml(R.xml.demo_users)) {
            while (parser.getEventType() != XmlResourceParser.END_DOCUMENT) {
                if ((parser.getEventType() == XmlResourceParser.START_TAG) && (parser.getName().equals(User.ELEMENT))) {
                    users.add(new User(parser));
                }

                parser.next();
            }
        }
    }

    public void save(Bundle output) {
        int count = users.size();
        output.putInt(SIZE, count);

        for (int index = 0; index < count; index++) {
            users.get(index).save(index, output);
        }
    }

    public int size() {
        return users.size();
    }
}
