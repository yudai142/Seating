package com.dd_career.seating;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// 利用者情報を格納する.
public class User {
    public final class BundleKey {
        public static final String FLAGS = "User_Flags_%d";
        public static final String ID = "User_Id_%d";
        public static final String NAME = "User_Name_%d";
        private BundleKey() {}
    }
    public final class DemoKey {
        public static final String ID = "id";
        public static final String NAME = "name";
        private DemoKey() {}
    }
    public final class Flag {
        public static final int VISIBLE = 1;
        private Flag() {}
    }
    public final class GasKey {
        public static final String FLAGS = "status";
        public static final String ID = "studentNumber";
        public static final String NAME = "studentName";
        private GasKey() {}
    }

    private static final String NAMESPACE = null;
    private int flags;
    private int id;
    private String name;

    public User() {
        flags = Flag.VISIBLE;
        id = -1;
        name = null;
    }

    public User(JSONObject object) throws JSONException {
        flags = object.getInt(GasKey.FLAGS);
        id = object.getInt(GasKey.ID);
        name = object.getString(GasKey.NAME);
    }

    public User(XmlResourceParser parser) {
        super();
        id = Integer.parseInt(parser.getAttributeValue(NAMESPACE, DemoKey.ID));
        name = parser.getAttributeValue(NAMESPACE, DemoKey.NAME);
    }

    public User(int index, Bundle input) {
        super();
        Locale locale = Locale.ENGLISH;
        flags = input.getInt(String.format(locale, BundleKey.FLAGS, index), flags);
        id = input.getInt(String.format(locale, BundleKey.ID, index), id);
        name = input.getString(String.format(locale, BundleKey.NAME, index), name);
    }

    @NonNull
    public User clone() {
        User value = new User();
        value.flags = flags;
        value.id = id;
        value.name = name;
        return value;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void toBundle(int index, Bundle output) {
        Locale locale = Locale.ENGLISH;
        output.putInt(String.format(locale, BundleKey.FLAGS, index), flags);
        output.putInt(String.format(locale, BundleKey.ID, index), id);
        output.putString(String.format(locale, BundleKey.NAME, index), name);
    }

    public JSONArray toJsonArray() throws JSONException {
        JSONArray array = new JSONArray();
        array.put(toJsonObject());
        return array;
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject object = new JSONObject();
        object.put(GasKey.FLAGS, getFlags());
        object.put(GasKey.ID, getId());
        object.put(GasKey.NAME, getName());
        return object;
    }
}
