package tw.brad.apps.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Collections;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private long lastTime = 0;
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guess(View view) {
    }

    public void newGame(View view) {
        answer = createAnswer(4);
        Log.v("bradlog", answer);
    }

    public void setting(View view) {
    }

    private String createAnswer(int d){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0; i<10; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        String ret = "";
        for (int i=0; i<d; i++){
            ret +=  list.get(i);
        }

        return ret;
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