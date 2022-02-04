package com.dd_career.seating;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Debug", "Main Activity: On Create.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Debug", "Main Activity: On Destroy.");
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

    public void onSeatButtonClick_1(View view) {

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