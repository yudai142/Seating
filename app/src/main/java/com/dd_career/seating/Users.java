package com.dd_career.seating;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

// 利用者情報使用方法を提供する.
public final class Users {
    @NonNull
    private List<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    public final void add(User user) {
        this.users.add(user);
    }

    @NonNull
    public static Users createDemo(Resources resources) throws Exception {
        Users self = new Users();

        try (XmlResourceParser parser = resources.getXml(R.xml.demo_users)) {
            while (parser.getEventType() != XmlResourceParser.END_DOCUMENT) {
                if ((parser.getEventType() == XmlResourceParser.START_TAG) && (parser.getName().equals(User.ELEMENT_NAME))) {
                    self.add(new User(parser));
                }

                parser.next();
            }
        }

        return self;
    }

    @NonNull
    public final List<User> get() {
        return users;
    }

    @NonNull
    public final int[] getIds() {
        int[] ids = new int[users.size()];
        int index = 0;

        for (User user : users) {
            ids[index++] = user.getId();
        }

        return ids;
    }

    @NonNull
    public final String[] getNames() {
        String[] names = new String[users.size()];
        int index = 0;

        for (User user : users) {
            names[index++] = user.getName();
        }

        return names;
    }

    public int size() {
        return users.size();
    }
}
