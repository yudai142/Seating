package com.dd_career.seating;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 利用者情報を格納する.
public class User {
    public static final String ELEMENT = "user";
    public static final String FORMAT = "User_%s_%d";
    public static final String ID = "id";
    public static final int ID_DEFAULT_VALUE = 0;
    public static final String NAME = "name";
    public static final String NAME_DEFAULT_VALUE = null;
    public static final String NAMESPACE = null;
    public static final String SEAT = "seat";
    public static final int SEAT_DEFAULT_VALUE = 0;
    public static final String VISIBLE = "visible";
    public static final boolean VISIBLE_DEFAULT_VALUE = true;

    // 利用者一意識別子.
    private int id;

    // 利用者名.
    private String name;

    // 着座した座席識別子またはゼロ.
    private int seat;

    // 着座可能である場合は true. 着席不能である場合は false.
    private boolean visible;

    // 既定値で初期化する.
    public User() {
        id = ID_DEFAULT_VALUE;
        name = NAME_DEFAULT_VALUE;
        seat = SEAT_DEFAULT_VALUE;
        visible = VISIBLE_DEFAULT_VALUE;
    }

    @NonNull
    public User clone() {
        User value = new User();
        value.id = id;
        value.name = name;
        value.seat = seat;
        value.visible = visible;
        return value;
    }

    public int getId() {
        return this.id;
    }

    private static String getIdKey(int index) {
        return getKey(index, ID);
    }

    private static String getKey(int index, String name) {
        return Program.formatString(FORMAT, name, index);
    }

    public String getName() {
        return this.name;
    }

    private static String getNameKey(int index) {
        return getKey(index, NAME);
    }

    public int getSeat() {
        return this.seat;
    }

    private static String getSeatKey(int index) {
        return getKey(index, SEAT);
    }

    public boolean getVisible() {
        return this.visible;
    }

    private static String getVisibleKey(int index) {
        return getKey(index, VISIBLE);
    }

    public boolean isValid() {
        return (id != 0) && (name != null);
    }

    public void loadInstance(int index, Bundle input) {
        id = input.getInt(getIdKey(index));
        name = input.getString(getNameKey(index));
        seat = input.getInt(getSeatKey(index));
        visible = input.getBoolean(getVisibleKey(index));
    }

    public void loadXml(XmlResourceParser parser) {
        id = Integer.parseInt(parser.getAttributeValue(NAMESPACE, ID));
        name = parser.getAttributeValue(NAMESPACE, NAME);
        seat = 0;
        visible = true;
    }

    public void saveInstance(int index, Bundle output) {
        output.putInt(getIdKey(index), getId());
        output.putString(getNameKey(index), getName());
        output.putInt(getSeatKey(index), getSeat());
        output.putBoolean(getVisibleKey(index), getVisible());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
