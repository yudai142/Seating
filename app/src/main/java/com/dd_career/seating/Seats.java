package com.dd_career.seating;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

// 座席のコレクションを格納する.
public class Seats {
    private List<Seat> seats;

    public Seats() {
        this.seats = new ArrayList<>();
    }

    public void add(Seat seat) {
        seats.add(seat);
    }

    public Seat findSeatByView(View view) {
        for (Seat seat : seats) {
            if ((seat != null) && (seat.getButton() == view)) {
                return seat;
            }
        }

        return null;
    }

    public Seat get(int index) {
        return seats.get(index);
    }

    public int size() {
        return seats.size();
    }

    public void update() {
        for (Seat seat : seats) {
            if (seat != null) {
                seat.setUser(null);
            }
        }
    }
}
