package com.dd_career.seating;
import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(Program.formatString("%d", Program.getSeatIndex(view)));
        dialog.setTitle("Title");
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Debug", "Main Activity: On Create.");
    }

    // Options Menu を表示する場合は true を返す.
    // そうでない場合は false を返す.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Debug", "Main Activity: On Destroy.");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Debug", "Main Activity: On Pause.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Debug", "Main Activity: On Restart.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Debug", "Main Activity: On Resume.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Debug", "Main Activity: On Start.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Debug", "Main Activity: On Stop.");
    }
}