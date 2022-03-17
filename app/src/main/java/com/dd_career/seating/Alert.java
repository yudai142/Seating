package com.dd_career.seating;

import android.app.AlertDialog;
import android.content.Context;

public final class Alert {
    private Alert() {
    }

    public static void show(Context context, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setMessage(message);
        dialog.setTitle(context.getResources().getString(R.string.error));
        dialog.setPositiveButton(R.string.accept, null);
        dialog.show();
    }

    public static void show(Context context, Exception exception) {
        show(context, exception.getMessage());
    }
}
