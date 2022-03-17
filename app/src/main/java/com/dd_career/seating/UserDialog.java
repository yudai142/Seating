package com.dd_career.seating;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;

public class UserDialog {
    private View view;

    public UserDialog(Activity activity) {
        view = activity.getLayoutInflater().inflate(R.layout.dialog_user, null);
    }

    private EditText findEditTextById(int id) {
        View found = findViewById(id);
        return (found instanceof EditText) ? (EditText)found : null;
    }

    private SwitchCompat findSwitchCompatById(int id) {
        View found = findViewById(id);
        return (found instanceof SwitchCompat) ? (SwitchCompat)found : null;
    }

    private TextView findTextViewById(int id) {
        View found = findViewById(id);
        return (found instanceof TextView) ? (TextView)found : null;
    }

    private View findViewById(int id) {
        return (view != null) ? view.findViewById(id) : null;
    }

    public User getUser() {
        User user = new User();
        user.setId(getUserId());
        user.setName(getUserName());
        return user;
    }

    private int getUserId() {
        TextView edit = findTextViewById(R.id.user_id_edit);
        return (edit != null) ? Integer.parseInt(edit.getText().toString()) : 0;
    }

    private String getUserName() {
        EditText edit = findEditTextById(R.id.user_name_edit);
        return (edit != null) ? edit.getText().toString() : null;
    }

    private int getUserSeat() {
        TextView edit = findTextViewById(R.id.user_seat_edit);
        return (edit != null) ? Integer.parseInt(edit.getText().toString()) : 0;
    }

    private boolean getUserVisible() {
        SwitchCompat edit = findSwitchCompatById(R.id.user_visible_edit);
        return (edit != null) && edit.isChecked();
    }

    public View getView() {
        return view;
    }

    public void setUser(User user) {
        setUserId(user.getId());
        setUserName(user.getName());
    }

    private void setUserId(int id) {
        TextView edit = findTextViewById(R.id.user_id_edit);

        if (edit != null) {
            edit.setText(String.valueOf(id));
        }
    }

    private void setUserName(String name) {
        EditText edit = findEditTextById(R.id.user_name_edit);

        if (edit != null) {
            edit.setText(name);
        }
    }

    private void setUserSeat(int seat) {
        TextView edit = findTextViewById(R.id.user_seat_edit);

        if (edit != null) {
            edit.setText(String.valueOf(seat));
        }
    }

    private void setUserVisible(boolean visible) {
        SwitchCompat edit = findSwitchCompatById(R.id.user_visible_edit);

        if (edit != null) {
            edit.setChecked(visible);
        }
    }
}
