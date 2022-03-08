package com.dd_career.seating;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SeatRequest extends StringRequest {
    private SeatRecord record;

    public SeatRequest(int method, String url, Response.Listener<String> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<>();

        if (record != null) {
            params.put(SeatRecord.DATE, record.getDateString());
            params.put(SeatRecord.SEAT, record.getStatusString());
            params.put(SeatRecord.STATUS, record.getSeatString());
            params.put(SeatRecord.USER, record.getUserString());
            params.put(SeatRecord.VERSION, record.getVersionString());
        }

        return params;
    }

    public SeatRecord getRecord() {
        return record;
    }

    public void setRecord(SeatRecord record) {
        this.record = record;
    }
}
