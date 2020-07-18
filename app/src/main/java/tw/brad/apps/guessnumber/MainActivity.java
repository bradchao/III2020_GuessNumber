package tw.brad.apps.guessnumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private long lastTime = 0;
    private String answer;
    private EditText input;
    private TextView log;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        log = findViewById(R.id.log);

        initGame();
    }

    public void guess(View view) {
        counter++;
        String strInput = input.getText().toString();
        String result = checkAB(strInput);
        log.append(counter + ":" + strInput + " => " + result + "\n");

        input.setText("");

        if (result.equals("3A0B")){
            // WINNER
            showMessage("恭喜老爺, 賀喜夫人");
            initGame();
        }else if (counter == 3){
            // LOSER
            showMessage("Loser: " + answer);
            initGame();
        }else{
            showMessage(strInput + "=>" + result);
        }

    }

    private void showMessage(String mesg){
        AlertDialog alertDialog = null;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Message");
        builder.setMessage(mesg);
        builder.setPositiveButton("OK",null);
        //builder.setCancelable(false);

        alertDialog = builder.create();
        alertDialog.show();
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
        new AlertDialog.Builder(this)
                .setMessage("New Game?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        initGame();
                    }
                })
                .setNegativeButton("No", null)
                .setCancelable(false)
                .create()
                .show();
    }

    private void initGame(){
        answer = createAnswer(3);
        counter = 0;
        log.setText("");
        Log.v("bradlog", answer);
    }

    public void setting(View view) {
        AlertDialog alertDialog = null;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("設定猜幾碼?");
        builder.setItems(new String[]{"2", "3", "4"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.v("bradlog", "i = " + i);
            }
        });

        alertDialog = builder.create();
        alertDialog.show();
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