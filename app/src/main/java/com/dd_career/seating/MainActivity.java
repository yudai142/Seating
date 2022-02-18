package com.dd_career.seating;
import android.app.AlertDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

// アプリケーションのメイン エントリ ポイント.
public class MainActivity extends AppCompatActivity {
    private final int SEAT_MAX_ID = 23; // 最大座席番号.
    private final int SEAT_MIN_ID = 1; // 最小座席番号.
    private Users users; // 利用者のコレクション.

    // 既定値で初期化する.
    public MainActivity() {
        users = new Users();
    }

    // 指定した座席に利用者を設定する.
    private void announceSeat(int seatId, int userId) {
        Resources resources = getResources();
        User oldUser = users.findBySeat(seatId);
        User newUser = users.findById(userId);
        StringBuilder builder = new StringBuilder();

        if (oldUser != null) {
            builder.append(Program.formatString(
                    resources.getString(R.string.seat_announcement_format),
                    seatId,
                    oldUser.getName(),
                    resources.getString(R.string.seat_out)));
        }
        if (newUser != null) {
            builder.append(Program.formatString(
                    resources.getString(R.string.seat_announcement_format),
                    seatId,
                    newUser.getName(),
                    resources.getString(R.string.seat_in)));
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(resources.getString(R.string.note));
        dialog.setMessage(builder.toString());
        dialog.setNegativeButton(R.string.cancel, null);
        dialog.setPositiveButton(R.string.accept, (dialogInterface, index) -> {
            updateSeat(seatId, userId);
        });

        dialog.show();
    }

    // 着座する利用者を選択する.
    private void chooseUser(int seatId) {
        Resources resources = getResources();
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(resources.getString(R.string.seat_in));
        dialog.setNegativeButton(resources.getString(R.string.cancel), null);
        dialog.setItems(users.getNames(), (dialogInterface, selectedIndex) -> {
            User selectedUser = users.get(selectedIndex);
            int userId = (selectedUser != null) ? selectedUser.getId() : 0;
            announceSeat(seatId, userId);
        });
        dialog.show();
    }

    private Button findButtonById(int id) {
        View view = findViewById(id);
        return (view instanceof Button) ? (Button)view : null;
    }

    // Activity を復元する.
    private void loadInstance(Bundle input) {
        users.loadInstance(input);
    }

    private void loadUsers() {
        try {
            users.loadDemo(getResources());
        }
        catch (Exception exception) {
            showAlert(exception);
        }
    }

    // Activity 作成時に呼び出される.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadUsers();
        updateSeatButtons();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu, view, info);
    }

    // Options Menu を表示する場合は true を返す.
    // そうでない場合は false を返す.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.options_menu:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        loadInstance(savedInstanceState);
        updateSeatButtons();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    // Activity 破棄時に呼び出される.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstance(outState);
    }

    // 座席ボタンを押した場合に呼び出される.
    public void onSeatButtonClick(View view) {
        int seatId = Program.getSeatIndex(view);
        User seatUser = users.findBySeat(seatId);

        if (seatUser != null) {
            announceSeat(seatId, 0);
        }
        else {
            chooseUser(seatId);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    // Activity を保存する.
    private void saveInstance(Bundle output) {
        users.saveInstance(output);
    }

    // 指定した例外を説明するダイアログを表示する.
    private void showAlert(Exception exception) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(exception.getMessage());
        dialog.setTitle(getResources().getString(R.string.error));
        dialog.show();
    }

    // 指定した利用者を座席に座らせる.
    private void updateSeat(int seatId, int userId) {
        User newUser = users.findById(userId);
        User oldUser = users.findBySeat(seatId);

        if (oldUser != null) {
            oldUser.setSeat(0);
        }
        if (newUser != null) {
            newUser.setSeat(seatId);
        }

        updateSeatButton(seatId, userId);
    }

    // 座席ボタン表示を更新する.
    private void updateSeatButton(int seatId, int userId) {
        int buttonId = Program.getSeatViewId(seatId);
        Button button = findButtonById(buttonId);

        if (button != null) {
            Resources resources = getResources();
            User user = users.findById(userId);
            String userName;
            int buttonColor;

            if (user != null) {
                buttonColor = resources.getColor(R.color.used_seat);
                userName = user.getName();
            }
            else {
                buttonColor = resources.getColor(R.color.empty_seat);
                userName = resources.getString(R.string.empty_seat);
            }

            button.setBackgroundColor(buttonColor);
            button.setText(Program.formatString(
                    resources.getString(R.string.seat_button_text_format),
                    seatId,
                    userName));
        }
    }

    // 各座席ボタンについて, 座席ボタン表示を更新する.
    private void updateSeatButtons() {
        for (int seatId = SEAT_MIN_ID; seatId < SEAT_MAX_ID; seatId++) {
            User user = users.findBySeat(seatId);
            int userId = (user != null) ? user.getId() : 0;
            updateSeatButton(seatId, userId);
        }
    }
}