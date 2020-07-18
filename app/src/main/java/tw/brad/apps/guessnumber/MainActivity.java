package tw.brad.apps.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collections;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private long lastTime = 0;
    private String answer;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);

    }

    public void guess(View view) {
        String strInput = input.getText().toString();
        String result = checkAB(strInput);
        Log.v("bradlog", strInput + "=>" + result);
    }

    private String checkAB(String guess){
        int A, B; A = B = 0;
        for (int i=0; i<guess.length(); i++){
            if (guess.charAt(i) == answer.charAt(i)){
                A++;
            }else if (answer.indexOf(guess.charAt(i)) >= 0){
                B++;
            }
        }
        return A +"A" + B + "B";
    }

    public void newGame(View view) {
        answer = createAnswer(3);
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