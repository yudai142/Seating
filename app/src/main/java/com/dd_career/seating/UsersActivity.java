package com.dd_career.seating;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// 利用者一覧画面を表す.
public class UsersActivity extends Activity implements View.OnClickListener {
    private static final int CHECKOUT_MENU_ITEM = R.id.checkout_menu_item;
    private static final int COMMIT_MENU_ITEM = R.id.commit_menu_item;
    private static final int INVALID_INDEX = -1;
    private static final int NEW_MENU_ITEM = R.id.new_menu_item;
    private static final String BUTTON_TEXT_FORMAT = "%d: %s";
    private List<Button> buttons;
    private LinearLayout usersLinearLayout;

    public UsersActivity() {
         buttons = new ArrayList<>();
    }

    private void applyUser(User user) {
        getUsers().set(user);
        updateButtons();
    }

    private int findButton(View target) {
        int result = INVALID_INDEX;

        for (int index = 0; index < buttons.size(); index++) {
            Button button = buttons.get(index);

            if (button == target) {
                result = index;
                break;
            }
        }

        return result;
    }

    private void newUser() {
    }

    @Override
    protected void onCheckoutUsers(JSONArray response) {
        super.onCheckoutUsers(response);
        updateButtons();
    }

    // クリックしたボタンに対応する利用者を編集または新規作成する.
    @Override
    public void onClick(View view) {
        int id = findButton(view);
        User user = getUsers().findById(id);

        if (user != null) {
            UserDialog dialog = new UserDialog(this);
            dialog.setUser(user);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.user);
            builder.setView(dialog.getView());
            builder.setNegativeButton(R.string.cancel, null);
            builder.setPositiveButton(R.string.apply, (dialogInterface, value) -> applyUser(dialog.getUser()));
            builder.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        usersLinearLayout = findViewById(R.id.users_linear_layout);
        updateButtons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_users, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case CHECKOUT_MENU_ITEM:
                checkoutUsers();
                return true;
            case COMMIT_MENU_ITEM:
                commitUsers();
                return true;
            case NEW_MENU_ITEM:
                newUser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateButtons() {
        Users users = getUsers();
        int size = users.size();
        buttons.clear();
        usersLinearLayout.removeAllViews();

        while (buttons.size() < size) {
            Button button = new Button(this);
            button.setBackgroundColor(getResources().getColor(R.color.white));
            button.setOnClickListener(this);
            button.setTextColor(getResources().getColor(R.color.black));
            buttons.add(button);
            usersLinearLayout.addView(button);
        }
        for (int index = 0; index < size; index++) {
            Button button = buttons.get(index);
            User user = users.get(index);
            button.setText(String.format(Locale.ENGLISH, BUTTON_TEXT_FORMAT, user.getId(), user.getName()));
        }
    }
}