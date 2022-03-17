package com.dd_career.seating;

import java.util.Date;

public class Record {
    private Date date;
    private int flags;
    private int seat;
    private int user;

    public Record() {
        date = new Date();
        flags = 0;
        seat = -1;
        user = -1;
    }

    public Date getDate() {
        return date;
    }

    public int getFlags() {
        return flags;
    }

    public int getSeat() {
        return seat;
    }

    public int getUser() {
        return user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
