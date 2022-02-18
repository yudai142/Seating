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

    public static int getSeatViewId(int index) {
        int id = 0;

        switch (index) {
            case 1: id = R.id.seat_button_1; break;
            case 2: id = R.id.seat_button_2; break;
            case 3: id = R.id.seat_button_3; break;
            case 4: id = R.id.seat_button_4; break;
            case 5: id = R.id.seat_button_5; break;
            case 6: id = R.id.seat_button_6; break;
            case 7: id = R.id.seat_button_7; break;
            case 8: id = R.id.seat_button_8; break;
            case 9: id = R.id.seat_button_9; break;
            case 10: id = R.id.seat_button_10; break;
            case 11: id = R.id.seat_button_11; break;
            case 12: id = R.id.seat_button_12; break;
            case 13: id = R.id.seat_button_13; break;
            case 14: id = R.id.seat_button_14; break;
            case 15: id = R.id.seat_button_15; break;
            case 16: id = R.id.seat_button_16; break;
            case 17: id = R.id.seat_button_17; break;
            case 18: id = R.id.seat_button_18; break;
            case 19: id = R.id.seat_button_19; break;
            case 20: id = R.id.seat_button_20; break;
            case 21: id = R.id.seat_button_21; break;
            case 22: id = R.id.seat_button_22; break;
            case 23: id = R.id.seat_button_23; break;
            default: id = 0; break;
        }

        return id;
    }

    public static int getSeatIndex(View view) {
        int index;

        switch (view.getId()) {
            case R.id.seat_button_1: index = 1; break;
            case R.id.seat_button_2: index = 2; break;
            case R.id.seat_button_3: index = 3; break;
            case R.id.seat_button_4: index = 4; break;
            case R.id.seat_button_5: index = 5; break;
            case R.id.seat_button_6: index = 6; break;
            case R.id.seat_button_7: index = 7; break;
            case R.id.seat_button_8: index = 8; break;
            case R.id.seat_button_9: index = 9; break;
            case R.id.seat_button_10: index = 10; break;
            case R.id.seat_button_11: index = 11; break;
            case R.id.seat_button_12: index = 12; break;
            case R.id.seat_button_13: index = 13; break;
            case R.id.seat_button_14: index = 14; break;
            case R.id.seat_button_15: index = 15; break;
            case R.id.seat_button_16: index = 16; break;
            case R.id.seat_button_17: index = 17; break;
            case R.id.seat_button_18: index = 18; break;
            case R.id.seat_button_19: index = 19; break;
            case R.id.seat_button_20: index = 20; break;
            case R.id.seat_button_21: index = 21; break;
            case R.id.seat_button_22: index = 22; break;
            case R.id.seat_button_23: index = 23; break;
            default: index = 0; break;
        }

        return index;
    }
}
