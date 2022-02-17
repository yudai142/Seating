package com.dd_career.seating;

import android.content.res.Resources;
import android.widget.Button;

// 座席番号と座席ボタンを紐づける.
public class Seat {

    // 座席ボタン.
    private Button button;

    // 座席番号.
    private int index;

    // 着席した利用者.
    private User user;

    public Seat(int index, Button button) {
        this.index = index;
        this.button = button;
    }

    public Button getButton() {
        return this.button;
    }

    public int getIndex() {
        return this.index;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isEmpty() {
        return user == null;
    }

    public void setUser(User user) {
        this.user = user;
        update();
    }

    private void update() {
        if (button != null) {
            Resources resources = button.getResources();
            int color;
            String name;

            if (user != null) {
                color = resources.getColor(R.color.used_seat);
                name = user.getName();
            }
            else {
                color = resources.getColor(R.color.empty_seat);
                name = resources.getString(R.string.empty_seat);
            }

            button.setBackgroundColor(color);
            button.setText(String.format(resources.getString(R.string.seat_button_text_format), index, name));
        }
    }
}
