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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 利用者情報使用方法を提供する.
// 利用者情報提供元に応じて特殊化する.
// 利用者情報使用時の困難を解決するために縛りを設ける.
// コレクション項目の順序が保障されること.
// 各利用者 ID 間に欠落がないこと.
// 各利用者 ID は配列の添え字に対応すること.
public class Users implements Closeable {
    public static final int INVALID = -1;
    public static final int INVISIBLE = 4; // 不可視.
    public static final int SEATED = 3; // 着席済み.
    public static final int UNSEATED = 2; // 離席済み.
    public static final int VISIBLE = 1; // 可視.
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
    // 指定した利用者識別子の利用者を返す.
    public User findById(int id) {
        return ((0 <= id) && (id < users.size())) ? users.get(id) : null;
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
    public User[] get() {
        User[] result = new User[users.size()];
        users.toArray(result);
        return result;
    }

    public User[] select(int filter) {
        return select(get(), filter);
    }

    public static User[] select(User[] users, int filter) {
        List<User> buffer = new ArrayList<>();

        switch (filter) {
            case INVISIBLE:
                for (User user : users) {
                    if ((user != null) && (!user.getVisible())) {
                        buffer.add(user);
                    }
                }
                break;
            case SEATED:
                for (User user : users) {
                    if ((user != null) && (INVALID < user.getSeat())) {
                        buffer.add(user);
                    }
                }
                break;
            case UNSEATED:
                for (User user : users) {
                    if ((user != null) && (user.getSeat() <= INVALID)) {
                        buffer.add(user);
                    }
                }
                break;
            case VISIBLE:
                for (User user : users) {
                    if ((user != null) && (user.getVisible())) {
                        buffer.add(user);
                    }
                }
                break;
            default:
                Collections.addAll(buffer, users);
                break;
        }

        User[] result = new User[buffer.size()];
        buffer.toArray(result);
        return result;
    }

    // コレクションに要素を追加する.
    public void set(User user) {
        int id = user.getId();

        while (users.size() <= id) {
            users.add(null);
        }

        users.set(id, user);
    }

    // コレクションの大きさを取得する.
    public int size() {
        return users.size();
    }

    public void update() {
    }

    public void update(String source) {
    }
}
