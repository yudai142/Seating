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
    private List<User> users;

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
            Users created = Users.create(this);
            users = new ArrayList<>();

            for (User user : created.get()) {
                users.add(user);
            }
        }
        catch (Exception exception) {
            Program.showAlert(this, exception);
        }
    }

    @Override
    public void onClick(View view) {
        for (int index = 0; index < buttons.size(); index++) {
            if (view == buttons.get(index)) {
                User user = users.get(index);
                UserDialog dialog = new UserDialog(this);
                dialog.setUser(user);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.user);
                builder.setView(dialog.getView());
                builder.setNegativeButton(R.string.cancel, null);
                builder.setPositiveButton(R.string.apply, (dialogInterface, value) -> {});
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

            for (User user : users) {
                layout.addView(createItem(user));
            }
        }
    }
}