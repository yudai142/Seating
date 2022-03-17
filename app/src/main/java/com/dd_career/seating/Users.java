package com.dd_career.seating;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 利用者情報使用方法を提供する.
public class Users {
    public final class BundleKey {
        public static final String SIZE = "Users_Size";
        private BundleKey() {}
    }

    private static final int INVALID_INDEX = -1;
    private static final String ELEMENT = "user";
    private List<User> users;

    public Users() {
        users = new ArrayList<>();
    }

    public Users(@NonNull Bundle input) {
        super();
        final int size = input.getInt(BundleKey.SIZE);

        for (int index = 0; index < size; index++) {
            set(new User(index, input));
        }
    }

    public Users(@NonNull JSONArray array) throws JSONException {
        super();
        int index = 0;
        JSONObject object;

        while ((object = array.getJSONObject(index)) != null) {
            users.add(new User(object));
            index++;
        }
    }

    public Users(@NonNull XmlResourceParser parser) throws IOException, XmlPullParserException {
        super();

        while (parser.getEventType() != XmlResourceParser.END_DOCUMENT) {
            if ((parser.getEventType() == XmlResourceParser.START_TAG) && (parser.getName().equals(ELEMENT))) {
                users.add(new User(parser));
            }

            parser.next();
        }
    }

    public void clear() {
        users.clear();
    }

    public boolean exist(int id) {
        return 0 <= indexOf(id);
    }

    public boolean exist(User user) {
        return exist(user.getId());
    }

    public User findById(int id) {
        User result = null;

        for (User user : users) {
            if ((user != null) && (user.getId() == id)) {
                result = user;
            }
        }

        return result;
    }

    // 利用者のコレクションを取得する.
    public User get(int index) {
        return users.get(index);
    }

    public int indexOf(int id) {
        final int size = size();

        for (int index = 0; index < size; index++) {
            if (users.get(index).getId() == id) {
                return index;
            }
        }

        return INVALID_INDEX;
    }

    public int indexOf(User user) {
        return indexOf(user.getId());
    }

    public void set(User user) {
        final int index = indexOf(user);
        final boolean found = 0 <= index;

        if (found) {
            users.set(index, user);
        } else {
            users.add(user);
        }
    }

    // コレクションの大きさを取得する.
    public int size() {
        return users.size();
    }

    public User[] toArray() {
        final User[] buffer = new User[users.size()];
        users.toArray(buffer);
        return buffer;
    }

    // Save to Bundle.
    public void toBundle(Bundle output) {
        final int size = size();
        output.putInt(BundleKey.SIZE, size);

        for (int index = 0; index < size; index++) {
            get(index).toBundle(index, output);
        }
    }
}
