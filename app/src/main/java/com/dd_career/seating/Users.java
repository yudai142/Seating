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
    private List<User> users;

    // 既定値で初期化する.
    public Users() {
        users = new ArrayList<>();
    }

    // コレクションの末尾に要素を追加する.
    public void add(User user) {
        users.add(user);
    }

    // コレクションをクリアする.
    public void clear() {
        users.clear();
    }

    // 利用者識別子で検索する.
    // 指定した利用者識別子の利用者または null を返す.
    public User findById(int id) {
        for (User user : users) {
            if ((user != null) && (user.getId() == id)) {
                return user;
            }
        }

        return null;
    }

    // 座席識別子で検索する.
    // 指定した座席識別子の利用者または null を返す.
    public User findBySeat(int seat) {
        for (User user : users) {
            if ((user != null) && (user.getSeat() == seat)) {
                return user;
            }
        }

        return null;
    }

    // 利用者のコレクションを取得する.
    public List<User> get() {
        return users;
    }

    // 指定した目録の利用者を取得する.
    public User get(int index) {
        return users.get(index);
    }

    // 利用者識別子のコレクションを取得する.
    public int[] getIds() {
        int count = users.size();
        int[] ids = new int[count];

        for (int index = 0; index < count; index++) {
            ids[index] = users.get(index).getId();
        }

        return ids;
    }

    // 利用者名のコレクションを取得する.
    public String[] getNames() {
        int count = users.size();
        String[] names = new String[count];

        for (int index = 0; index < count; index++) {
            names[index] = users.get(index).getName();
        }

        return names;
    }

    public void loadDemo(Resources resources) throws Exception {
        try (XmlResourceParser parser = resources.getXml(R.xml.demo_users)) {
            while (parser.getEventType() != XmlResourceParser.END_DOCUMENT) {
                if ((parser.getEventType() == XmlResourceParser.START_TAG) && (parser.getName().equals(User.ELEMENT))) {
                    User user = new User();
                    user.loadXml(parser);
                    users.add(user);
                }

                parser.next();
            }
        }
    }

    // Activity を復元する.
    public void loadInstance(Bundle input) {
        int count = users.size();

        for (int index = 0; index < count; index++) {
            User user = users.get(index);
            user.loadInstance(index, input);
        }
    }

    // Activity を保存する.
    public void saveInstance(Bundle output) {
        int count = users.size();
        output.putInt(SIZE, count);

        for (int index = 0; index < count; index++) {
            users.get(index).saveInstance(index, output);
        }
    }

    // コレクションの大きさを取得する.
    public int size() {
        return users.size();
    }
}
