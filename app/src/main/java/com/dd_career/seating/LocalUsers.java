package com.dd_career.seating;

import android.content.Context;

import java.io.File;
import java.io.IOException;

public class LocalUsers extends Users {
    private static final String FILENAME = "Users";
    private Context context;

    public LocalUsers(Context context) {
        this.context = context;
    }

    @Override
    public void close() throws IOException {
        super.close();
        File file = new File(context.getFilesDir(), FILENAME);
    }

    @Override
    public void update() {
        super.update();
    }
}
