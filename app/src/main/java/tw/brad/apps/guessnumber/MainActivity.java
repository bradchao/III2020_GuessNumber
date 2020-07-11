package tw.brad.apps.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long lastTime = 0;

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

//    @Override
//    public void onBackPressed() {
//        Log.v("bradlog", "onBackPressed before");
//        super.onBackPressed();
//        Log.v("bradlog", "onBackPressed after");
//    }

    @Override
    public void finish() {
        if (System.currentTimeMillis() - lastTime >= 3*1000) {
            Toast.makeText(this,
                    "Press press again exit",
                    Toast.LENGTH_SHORT).show();
            lastTime = System.currentTimeMillis();
        }else {
            super.finish();
        }
    }
}