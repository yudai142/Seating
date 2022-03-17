package com.dd_career.seating;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Date;
import java.util.Locale;

public class Seat {
    public final class BundleKey {
        public static final String ID = "Seat_Id_%d";
        public static final String USER = "Seat_User_%d";
        private BundleKey() {}
    }

    private int id; // 座席番号.
    private int user; // 利用者番号.

    public Seat() {
        id = -1;
        user = -1;
    }

    public Seat(int index, Bundle input) {
        super();
        final Locale locale = Locale.ENGLISH;
        id = input.getInt(String.format(locale, BundleKey.ID, index), id);
        user = input.getInt(String.format(locale, BundleKey.USER, index), user);
    }

    public int getId() {
        return id;
    }

    public int getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void toBundle(int index, Bundle output) {
        final Locale locale = Locale.ENGLISH;
        output.putInt(String.format(locale, BundleKey.ID, index), id);
        output.putInt(String.format(locale, BundleKey.USER, index), user);
    }
}
