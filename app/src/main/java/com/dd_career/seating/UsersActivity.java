package com.dd_career.seating;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Button> buttons;
    private Users users;

    public UsersActivity() {
         buttons = new ArrayList<>();
    }

    private View createItem(User user) {
        Button button = new Button(this);
        button.setOnClickListener(this);
        button.setBackgroundColor(getResources().getColor(R.color.white));
        button.setText(user.getName());
        buttons.add(button);
        return button;
    }

    private void initializeUsers() {
        try {
            users = Users.create(this);
        }
        catch (Exception exception) {
            Program.showAlert(this, exception);
        }
    }

    @Override
    public void onClick(View view) {
        for (int index = 0; index < buttons.size(); index++) {
            if (view == buttons.get(index)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.user);
                builder.setView(getLayoutInflater().inflate(R.layout.dialog_user, null));
                builder.setNegativeButton(R.string.cancel, null);
                builder.setPositiveButton(R.string.apply, null);
                builder.show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        initializeUsers();
        updateUsers();
    }

    private void updateUsers() {
        View view = findViewById(R.id.users_linear_layout);

        if (view instanceof LinearLayout) {
            LinearLayout layout = (LinearLayout)view;

            for (User user : users.get()) {
                layout.addView(createItem(user));
            }
        }
    }
}