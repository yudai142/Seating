package com.dd_career.seating;

import android.app.AlertDialog;
import android.view.View;

import java.util.Locale;

public final class Program {
    private static final Locale LOCALE = Locale.JAPANESE;

    private Program() {
    }

    public static String formatString(String format, Object... args) {
        return String.format(LOCALE, format, args);
    }

    public static int getSeatIndex(View view) {
        int value;

        switch (view.getId()) {
            case R.id.seat_button_1: value = 1; break;
            case R.id.seat_button_2: value = 2; break;
            case R.id.seat_button_3: value = 3; break;
            case R.id.seat_button_4: value = 4; break;
            case R.id.seat_button_5: value = 5; break;
            case R.id.seat_button_6: value = 6; break;
            case R.id.seat_button_7: value = 7; break;
            case R.id.seat_button_8: value = 8; break;
            case R.id.seat_button_9: value = 9; break;
            case R.id.seat_button_10: value = 10; break;
            case R.id.seat_button_11: value = 11; break;
            case R.id.seat_button_12: value = 12; break;
            case R.id.seat_button_13: value = 13; break;
            case R.id.seat_button_14: value = 14; break;
            case R.id.seat_button_15: value = 15; break;
            case R.id.seat_button_16: value = 16; break;
            case R.id.seat_button_17: value = 17; break;
            case R.id.seat_button_18: value = 18; break;
            case R.id.seat_button_19: value = 19; break;
            case R.id.seat_button_20: value = 20; break;
            case R.id.seat_button_21: value = 21; break;
            case R.id.seat_button_22: value = 22; break;
            case R.id.seat_button_23: value = 23; break;
            default: value = 0;
        }

        return value;
    }
}
