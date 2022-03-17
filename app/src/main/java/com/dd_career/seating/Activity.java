package com.dd_career.seating;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Locale;

public class Activity extends AppCompatActivity {
    public static final class Command {
        public static final int RECORD = 2;
        public static final int SEAT = 3;
        public static final int USER = 1;
        private Command() {}
    }
    public static final class CommandString {
        public static final String RECORD = "record";
        public static final String SEAT = "seat";
        public static final String USER = "student";
        private CommandString() {}
        public static String fromCommand(int command) {
            switch (command) {
                case Command.RECORD:
                    return RECORD;
                case Command.SEAT:
                    return SEAT;
                case Command.USER:
                    return USER;
                default:
                    return null;
            }
        }
    }

    private static final String COMMAND_FORMAT = "%s?params=%s";
    private Preferences preferences;
    private RequestQueue requestQueue;
    private Users users;

    public Activity() {
    }

    public void checkoutUsers() {
        JSONArray response = new JSONArray();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, getUrl(Command.USER), response, this::onCheckoutUsers, this::onErrorResponse);
        requestQueue.add(request);
    }

    public void commitUsers() {
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    private String getUrl(int command) {
        return String.format(Locale.ENGLISH, COMMAND_FORMAT, getPreferences().getGoogleAppsScriptUrl(), CommandString.fromCommand(command));
    }

    public Users getUsers() {
        return users;
    }

    public void loadUsers(@Nullable Bundle input) {
        if (input != null) {
            users = new Users(input);
        } else {
            users = new Users();
        }
    }

    protected void onCheckoutUsers(JSONArray response) {
        onJsonResponse(response);

        try {
            users.clear();

            for (int index = 0; index < response.length(); index++) {
                JSONObject object = response.getJSONObject(index);
                users.set(new User(object));
            }
        }
        catch (Exception exception) {
            Alert.show(this, exception);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = new Preferences(this);
        requestQueue = Volley.newRequestQueue(this);
        loadUsers(savedInstanceState);
    }

    private void onErrorResponse(VolleyError error) {
        Alert.show(this, error.toString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        saveUsers(outState);
    }

    private void onJsonResponse(JSONArray response) {
        Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show();
    }

    public void saveUsers(Bundle output) {
        if (users != null) {
            users.toBundle(output);
        }
    }
}
