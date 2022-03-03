package com.dd_career.seating;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

import androidx.annotation.NonNull;

import org.xmlpull.v1.XmlPullParserException;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 利用者情報使用方法を提供する.
// 利用者情報使用時の困難を解決するために縛りを設ける.
// 各利用者 ID 間に欠落がないこと.
// 各利用者 ID は配列の添え字に対応すること.
// 利用者 ID ゼロを使用しないこと.
public class Users implements Closeable {
    private final List<User> users;

    // 既定値で初期化する.
    public Users() {
        users = new ArrayList<>();
    }

    // コレクションをクリアする.
    public void clear() {
        users.clear();
    }

    @Override
    public void close() throws IOException {
    }

    public static Users create(Context context) throws Exception {
        return new DemoUsers(context);
    }

    // 利用者識別子で検索する.
    // 指定した利用者識別子の利用者または null を返す.
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    // 座席識別子で検索する.
    // 指定した座席識別子の利用者または null を返す.
    public User findBySeat(int seat) {
        for (User user : users) {
            if (user.getSeat() == seat) {
                return user;
            }
        }

        return null;
    }

    // 利用者のコレクションを取得する.
    public User[] get() {
        User[] result = new User[users.size()];
        users.toArray(result);
        return result;
    }

    // コレクションに要素を追加する.
    public void set(User user) {
        for (int index = 0; index < users.size(); index++) {
            User target = users.get(index);

            if (target.getId() == user.getId()) {
                users.set(index, user);
            }
        }

        users.add(user);
    }

    // コレクションの大きさを取得する.
    public int size() {
        return users.size();
    }

    public void Update() {
    }
}
