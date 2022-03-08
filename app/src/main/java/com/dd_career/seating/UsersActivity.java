package com.dd_career.seating;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

// 利用者一覧画面を表す.
public class UsersActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int INVALID_INDEX = -1;
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

    private int findButton(View target) {
        for (int index = 0; index < buttons.size(); index++) {
            Button button = buttons.get(index);

            if (button == target) {
                return index;
            }
        }

        return INVALID_INDEX;
    }

    private void initializeUsers() {
        try {
            users = Users.create(this);
        }
        catch (Exception exception) {
            Program.showAlert(this, exception);
        }
    }

    // クリックしたボタンに対応する利用者を編集または新規作成する.
    @Override
    public void onClick(View view) {
        int id = findButton(view);
        User user = users.findById(id);
        if (user == null) user = new User(id);
        UserDialog dialog = new UserDialog(this);
        dialog.setUser(user);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.user);
        builder.setView(dialog.getView());
        builder.setNegativeButton(R.string.cancel, null);
        builder.setPositiveButton(R.string.apply, (dialogInterface, value) -> updateUser(dialog.getUser()));
        builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        initializeUsers();
        updateUsers();
    }

    private void updateUser(User user) {
        users.set(user);
        updateUsers();
    }

    private void updateUsers() {
        View view = findViewById(R.id.users_linear_layout);
        int size = users.size();

        if (view instanceof LinearLayout) {
            LinearLayout layout = (LinearLayout)view;

            while (buttons.size() <= size) {
                Button button = new Button(this);
                button.setBackgroundColor(getResources().getColor(R.color.empty_seat));
                button.setOnClickListener(this);
                button.setTextColor(getResources().getColor(R.color.black));
                buttons.add(button);
                layout.addView(button);
            }
        }
        for (int id = 0; id < size; id++) {
            Button button = buttons.get(id);
            User user = users.findById(id);
            button.setText(user.getName());
        }

        buttons.get(size).setText(R.string.add_new);
    }
}