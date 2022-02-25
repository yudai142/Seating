package com.dd_career.seating;

import android.view.View;

import java.util.Locale;

public final class Program {
    public static final class ID {
        public static final int OPTIONS_MENU = R.id.options_menu;
        public static final int RESET_BUTTON = R.id.reset_button;
        public static final int SEAT_BUTTON_1 = R.id.seat_button_1;
        public static final int SEAT_BUTTON_2 = R.id.seat_button_2;
        public static final int SEAT_BUTTON_3 = R.id.seat_button_3;
        public static final int SEAT_BUTTON_4 = R.id.seat_button_4;
        public static final int SEAT_BUTTON_5 = R.id.seat_button_5;
        public static final int SEAT_BUTTON_6 = R.id.seat_button_6;
        public static final int SEAT_BUTTON_7 = R.id.seat_button_7;
        public static final int SEAT_BUTTON_8 = R.id.seat_button_8;
        public static final int SEAT_BUTTON_9 = R.id.seat_button_9;
        public static final int SEAT_BUTTON_10 = R.id.seat_button_10;
        public static final int SEAT_BUTTON_11 = R.id.seat_button_11;
        public static final int SEAT_BUTTON_12 = R.id.seat_button_12;
        public static final int SEAT_BUTTON_13 = R.id.seat_button_13;
        public static final int SEAT_BUTTON_14 = R.id.seat_button_14;
        public static final int SEAT_BUTTON_15 = R.id.seat_button_15;
        public static final int SEAT_BUTTON_16 = R.id.seat_button_16;
        public static final int SEAT_BUTTON_17 = R.id.seat_button_17;
        public static final int SEAT_BUTTON_18 = R.id.seat_button_18;
        public static final int SEAT_BUTTON_19 = R.id.seat_button_19;
        public static final int SEAT_BUTTON_20 = R.id.seat_button_20;
        public static final int SEAT_BUTTON_21 = R.id.seat_button_21;
        public static final int SEAT_BUTTON_22 = R.id.seat_button_22;
        public static final int SEAT_BUTTON_23 = R.id.seat_button_23;
        public static final int UPDATE_BUTTON = R.id.update_button;
        private ID() {}
    }

    private static final Locale LOCALE = Locale.JAPANESE;
    private Program() {}

    public static String formatString(String format, Object... args) {
        return String.format(LOCALE, format, args);
    }

    public static int getSeatButtonId(int index) {
        switch (index) {
            case 1: return ID.SEAT_BUTTON_1;
            case 2: return ID.SEAT_BUTTON_2;
            case 3: return ID.SEAT_BUTTON_3;
            case 4: return ID.SEAT_BUTTON_4;
            case 5: return ID.SEAT_BUTTON_5;
            case 6: return ID.SEAT_BUTTON_6;
            case 7: return ID.SEAT_BUTTON_7;
            case 8: return ID.SEAT_BUTTON_8;
            case 9: return ID.SEAT_BUTTON_9;
            case 10: return ID.SEAT_BUTTON_10;
            case 11: return ID.SEAT_BUTTON_11;
            case 12: return ID.SEAT_BUTTON_12;
            case 13: return ID.SEAT_BUTTON_13;
            case 14: return ID.SEAT_BUTTON_14;
            case 15: return ID.SEAT_BUTTON_15;
            case 16: return ID.SEAT_BUTTON_16;
            case 17: return ID.SEAT_BUTTON_17;
            case 18: return ID.SEAT_BUTTON_18;
            case 19: return ID.SEAT_BUTTON_19;
            case 20: return ID.SEAT_BUTTON_20;
            case 21: return ID.SEAT_BUTTON_21;
            case 22: return ID.SEAT_BUTTON_22;
            case 23: return ID.SEAT_BUTTON_23;
            default: return 0;
        }
    }

    public static int getSeatId(View view) {
        switch (view.getId()) {
            case ID.SEAT_BUTTON_1: return 1;
            case ID.SEAT_BUTTON_2: return 2;
            case ID.SEAT_BUTTON_3: return 3;
            case ID.SEAT_BUTTON_4: return 4;
            case ID.SEAT_BUTTON_5: return 5;
            case ID.SEAT_BUTTON_6: return 6;
            case ID.SEAT_BUTTON_7: return 7;
            case ID.SEAT_BUTTON_8: return 8;
            case ID.SEAT_BUTTON_9: return 9;
            case ID.SEAT_BUTTON_10: return 10;
            case ID.SEAT_BUTTON_11: return 11;
            case ID.SEAT_BUTTON_12: return 12;
            case ID.SEAT_BUTTON_13: return 13;
            case ID.SEAT_BUTTON_14: return 14;
            case ID.SEAT_BUTTON_15: return 15;
            case ID.SEAT_BUTTON_16: return 16;
            case ID.SEAT_BUTTON_17: return 17;
            case ID.SEAT_BUTTON_18: return 18;
            case ID.SEAT_BUTTON_19: return 19;
            case ID.SEAT_BUTTON_20: return 20;
            case ID.SEAT_BUTTON_21: return 21;
            case ID.SEAT_BUTTON_22: return 22;
            case ID.SEAT_BUTTON_23: return 23;
            default: return 0;
        }
    }
}
