package com.dd_career.seating;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Date;

public class SeatRecord {
    public static final String DATE = "Date";
    public static final int LEAVE = 2; // 離席.
    public static final String LEAVE_STRING = "Leave";
    public static final String SEAT = "Seat";
    public static final String STATUS = "Status";
    public static final int TAKE = 1; // 着席.
    public static final String TAKE_STRING = "Take";
    public static final String USER = "User";
    public static final String VERSION = "Version";
    private Date date; // 日付時刻.
    private int seat; // 座席.
    private int status; // 着席離席.
    private int user; // 利用者.
    private int version; // レイアウト.

    public SeatRecord() {
        date = new Date();
        seat = 0;
        status = 0;
        user = 0;
        version = 0;
    }

    public Date getDate() {
        return date;
    }

    public String getDateString() {
        return date.toString();
    }

    public int getSeat() {
        return seat;
    }

    public String getSeatString() {
        return Integer.toString(seat);
    }

    public int getStatus() {
        return status;
    }

    public String getStatusString() {
        switch (status) {
            case LEAVE:
                return LEAVE_STRING;
            case TAKE:
                return TAKE_STRING;
            default:
                return Integer.toString(status);
        }
    }

    public int getUser() {
        return user;
    }

    public String getUserString() {
        return Integer.toString(user);
    }

    public int getVersion() {
        return version;
    }

    public String getVersionString() {
        return Integer.toString(version);
    }

    public void save(Context context) {
        String destination = Program.getGoogleScriptUrl(context);
        SeatRequest request = new SeatRequest(Request.Method.POST, destination, response -> {
            Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
        }, error -> {
            Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
        });
        request.setRecord(this);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
