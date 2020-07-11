package tw.brad.apps.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guess(View view) {
    }

    public void newGame(View view) {
    }

    public void setting(View view) {
    }

    public void exit(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        Log.v("bradlog", "onBackPressed before");
        super.onBackPressed();
        Log.v("bradlog", "onBackPressed after");
    }

    @Override
    public void finish() {
        Log.v("bradlog", "finish before");
        super.finish();
        Log.v("bradlog", "finish after");
    }
}