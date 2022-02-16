package com.dd_career.seating;
import android.app.AlertDialog;
import android.content.res.Resources;
import android.os.Bundle;
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
    private Seats seats;
    private Users users;

    // 着座する利用者を選択する.
    private void chooseUser(View view) {
        Seat seat = seats.findSeatByView(view);

        if (seat != null) {
            Resources resources = getResources();
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle(resources.getString(R.string.seat_in));
            dialog.setNegativeButton(resources.getString(R.string.cancel), null);
            dialog.setItems(users.getNames(), (dialogInterface, index) -> {
                seat.setUser(users.get(index));
            });
            dialog.show();
        }
    }

    private void loadSeats() {
        seats = new Seats();
        for (int index = 1; index <= 23; index++) {
            seats.add(new Seat(index, (Button)findViewById(Program.getSeatViewId(index))));
        }
    }

    private void loadUsers() {
        try {
            users = Users.createDemo(getResources());
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

    public void onSeatButtonClick(View view) {
        chooseUser(view);
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