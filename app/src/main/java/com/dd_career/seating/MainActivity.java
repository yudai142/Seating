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
    private final int SEAT_MAX_INDEX = 23; // 最大座席番号.
    private final int SEAT_MIN_INDEX = 1; // 最小座席番号.
    private Seats seats = new Seats(); // 座席のコレクション.
    private Users users = new Users(); // 利用者のコレクション.

    // 指定した座席に利用者を設定する.
    private void announceSeat(Seat seat, User newUser) {
        Resources resources = getResources();
        User oldUser = seat.getUser();
        StringBuilder builder = new StringBuilder();

        if (oldUser != null) {
            builder.append(Program.formatString(
                    resources.getString(R.string.seat_announcement_format),
                    seat.getIndex(),
                    oldUser.getName(),
                    resources.getString(R.string.seat_out)));
        }
        if (newUser != null) {
            builder.append(Program.formatString(
                    resources.getString(R.string.seat_announcement_format),
                    seat.getIndex(),
                    newUser.getName(),
                    resources.getString(R.string.seat_in)));
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(resources.getString(R.string.note));
        dialog.setMessage(builder.toString());
        dialog.setNegativeButton(R.string.cancel, null);
        dialog.setPositiveButton(R.string.accept, (dialogInterface, index) -> {
            seat.setUser(newUser);
        });

        dialog.show();
    }

    // 着座する利用者を選択する.
    private void chooseUser(Seat seat) {
        Resources resources = getResources();
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(resources.getString(R.string.seat_in));
        dialog.setNegativeButton(resources.getString(R.string.cancel), null);
        dialog.setItems(users.getNames(), (dialogInterface, index) -> {
            announceSeat(seat, users.get(index));
        });
        dialog.show();
    }

    private void loadSeats() {
        for (int index = SEAT_MIN_INDEX; index <= SEAT_MAX_INDEX; index++) {
            Button button = (Button)findViewById(Program.getSeatViewId(index));

            if (button != null) {
                seats.add(new Seat(index, button));
            }
        }
    }

    private void loadUsers() {
        try {
            users.loadDemo(getResources());
        }
        catch (Exception exception) {
            showAlert(exception);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadSeats();
        loadUsers();
        seats.update();

        if (savedInstanceState != null) {

        }
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
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    // 座席ボタンを押した場合に呼び出される.
    public void onSeatButtonClick(View view) {
        Seat seat = seats.findSeatByView(view);

        if (seat != null) {
            if (seat.isEmpty()) {
                chooseUser(seat);
            }
            else {
                announceSeat(seat, null);
            }
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

    // 指定した例外を説明するダイアログを表示する.
    private void showAlert(Exception exception) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(exception.getMessage());
        dialog.setTitle(getResources().getString(R.string.error));
        dialog.show();
    }
}