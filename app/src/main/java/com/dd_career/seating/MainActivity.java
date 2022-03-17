package com.dd_career.seating;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

// アプリケーションのメイン エントリ ポイント.
public class MainActivity extends Activity implements View.OnClickListener {
    private static final int INVALID = -1;
    private static final int SEAT_MAX_ID = 23; // 最大座席番号.
    private static final int SEAT_MIN_ID = 1; // 最小座席番号.
    private static final int SETTINGS_MENU_ITEM = R.id.settings_menu_item;
    private static final int USERS_MENU_ITEM = R.id.users_menu_item;

    // 既定値で初期化する.
    public MainActivity() {
    }

    // 指定した座席に利用者を設定する.
    private void announceSeat(int seatId, int userId) {
//        User oldUser = users.findBySeat(seatId);
//        User newUser = users.findById(userId);
//        StringBuilder builder = new StringBuilder();
//
//        if (oldUser != null) {
//            builder.append(Program.formatString(
//                    getString(R.string.seat_announcement_format),
//                    seatId,
//                    oldUser.getName(),
//                    getString(R.string.seat_out)));
//        }
//        if (newUser != null) {
//            builder.append(Program.formatString(
//                    getString(R.string.seat_announcement_format),
//                    seatId,
//                    newUser.getName(),
//                    getString(R.string.seat_in)));
//        }
//
//        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//        dialog.setTitle(R.string.note);
//        dialog.setMessage(builder.toString());
//        dialog.setNegativeButton(R.string.cancel, null);
//        dialog.setPositiveButton(R.string.accept, (dialogInterface, index) -> updateSeat(seatId, userId));
//        dialog.show();
    }

    // 着座する利用者を選択する.
    private void chooseUser(int seatId) {
//        User[] users = this.users.get();
//        int[] userIds = new int[users.length];
//        String[] userNames = new String[users.length];
//
//        for (int index = 0; index < users.length; index++) {
//            userIds[index] = users[index].getId();
//            userNames[index] = users[index].getName();
//        }
//
//        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//        dialog.setTitle(getString(R.string.seat_in));
//        dialog.setNegativeButton(getString(R.string.cancel), null);
//        dialog.setItems(userNames, (dialogInterface, selectedIndex) -> announceSeat(seatId, userIds[selectedIndex]));
//        dialog.show();
    }

    private void closeUsers() {
//        try {
//            if (users != null) {
//                users.close();
//                users = null;
//            }
//        }
//        catch (Exception exception) {
//            Program.showAlert(this, exception);
//        }
    }

    private Button findButtonById(int id) {
        View view = findViewById(id);
        return (view instanceof Button) ? (Button)view : null;
    }

    private void initializeUsers() {
//        try {
//            users = new DemoUsers(this);
//        }
//        catch (Exception exception) {
//            showAlert(exception);
//        }
    }

    @Override
    public void onClick(View sender) {
        switch (sender.getId()) {
            case Program.ID.RESET_BUTTON:
                reset();
                break;
            case Program.ID.UPDATE_BUTTON:
                update();
                break;
            default:
                onSeatButtonClick(sender);
                break;
        }
    }

    // Activity 作成時に呼び出される.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initializeUsers();
//        updateSeatButtons();
//        updateRoom();
//        findViewById(R.id.reset_button).setOnClickListener(this);
//        findViewById(R.id.update_button).setOnClickListener(this);
//
//        for (int index = SEAT_MIN_ID; index <= SEAT_MAX_ID; index++) {
//            findViewById(Program.getSeatButtonId(index)).setOnClickListener(this);
//        }
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
        closeUsers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case SETTINGS_MENU_ITEM:
                intent = new Intent(getApplication(), SettingsActivity.class);
                break;
            case USERS_MENU_ITEM:
                intent = new Intent(getApplication(), UsersActivity.class);
                break;
            default:
                intent = null;
                break;
        }
        if (intent != null) {
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        updateSeatButtons();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    // Activity 破棄時に呼び出される.
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    // 座席ボタンを押した場合に呼び出される.
    public void onSeatButtonClick(View view) {
//        int seatId = Program.getSeatId(view);
//        User seatUser = users.findBySeat(seatId);
//
//        if (seatUser != null) {
//            announceSeat(seatId, INVALID);
//        }
//        else {
//            chooseUser(seatId);
//        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    // 間取り図を原点へ移動する.
    private void reset() {
        View view = findViewById(R.id.room_layout);

        if (view != null) {
            ViewGroup.LayoutParams params = view.getLayoutParams();

            if (params instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams layout = (ViewGroup.MarginLayoutParams)params;
                layout.leftMargin = 0;
                layout.topMargin = 0;
            }

            view.layout(0, 0, view.getWidth(), view.getHeight());
        }
    }

    // 指定した例外を説明するダイアログを表示する.
    private void showAlert(Exception exception) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(exception.getMessage());
        dialog.setTitle(getResources().getString(R.string.error));
        dialog.show();
    }

    private void update() {
        String source = Program.getGoogleScriptUrl(this);
        Toast.makeText(this, source, Toast.LENGTH_LONG).show();
    }

    private void updateLatestTimeText() {
        View view = findViewById(R.id.latest_time_text);

        if (view instanceof TextView) {
            Date date = new Date();
            TextView textView = (TextView)view;
            textView.setText(date.toString());
        }
    }

    // 間取り図にタッチ機能を登録する.
    private void updateRoom() {
        View room = findViewById(R.id.room_layout);

        if (room != null) {
            room.setOnTouchListener(new TouchListener());
        }
    }

    // 指定した利用者を座席に座らせる.
    private void updateSeat(int seatId, int userId) {
//        User newUser = users.findById(userId);
//        User oldUser = users.findBySeat(seatId);
//
//        if (oldUser != null) {
//            oldUser.setSeat(0);
//            users.set(oldUser);
//        }
//        if (newUser != null) {
//            newUser.setSeat(seatId);
//            users.set(newUser);
//        }
//
//        updateSeatButton(seatId, userId);
//
//        SeatRecord record = new SeatRecord();
//        record.setSeat(seatId);
//        record.setStatus(SeatRecord.TAKE);
//        record.setUser(userId);
//        record.save(this);
    }

    // 座席ボタン表示を更新する.
    private void updateSeatButton(int seatId, int userId) {
//        int buttonId = Program.getSeatButtonId(seatId);
//        Button button = findButtonById(buttonId);
//
//        if (button != null) {
//            Resources resources = getResources();
//            User user = users.findById(userId);
//            String userName;
//            int buttonColor;
//
//            if (user != null) {
//                buttonColor = resources.getColor(R.color.used_seat);
//                userName = user.getName();
//            }
//            else {
//                buttonColor = resources.getColor(R.color.empty_seat);
//                userName = resources.getString(R.string.empty_seat);
//            }
//
//            button.setBackgroundColor(buttonColor);
//            button.setText(Program.formatString(
//                    resources.getString(R.string.seat_button_text_format),
//                    seatId,
//                    userName));
//        }
    }

    // 各座席ボタンについて, 座席ボタン表示を更新する.
    private void updateSeatButtons() {
//        for (int seatId = SEAT_MIN_ID; seatId <= SEAT_MAX_ID; seatId++) {
//            User user = users.findBySeat(seatId);
//            int userId = (user != null) ? user.getId() : INVALID;
//            updateSeatButton(seatId, userId);
//        }
    }
}