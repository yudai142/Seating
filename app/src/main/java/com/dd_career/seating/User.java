package com.dd_career.seating;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 利用者情報を格納する.
public final class User {
    public static final String ID_ATTRIBUTE_NAME = "id";
    public static final String NAME_ATTRIBUTE_NAME = "name";
    public static final String NAMESPACE = null;
    public static final String ELEMENT_NAME = "user";

    // 利用者一意識別子.
    private int id;

    // 最新着座時刻.
    private Date latestSeatIn;

    // 最新離席時刻.
    private Date latestSeatOut;

    // 利用者名.
    private String name;

    // 着座した場合は ture. 離席した場合は false.
    private boolean onSeat;

    // 着座した座席番号またはゼロ.
    private int seat;

    // 着座可能である場合は true. 着席不能である場合は false.
    private boolean visible;

    public User() {
        this.visible = true;
    }

    public User(XmlResourceParser parser) {
        this.id = Integer.parseInt(parser.getAttributeValue(NAMESPACE, ID_ATTRIBUTE_NAME));
        this.name = parser.getAttributeValue(NAMESPACE, NAME_ATTRIBUTE_NAME);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getOnSeat() {
        return this.onSeat;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final void setOnSeat(boolean onSeat) {
        this.onSeat = onSeat;
    }

    public final void setVisible(boolean visible) {
        this.visible = visible;
    }
}
