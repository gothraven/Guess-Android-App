package guess.guess;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class game extends AppCompatActivity {
    private TextView time;
    private TextView puzzle;
    private TextView hints;
    private Random unknown;
    private EditText answer;
    private Button check;
    private Puzzle phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        time = (TextView) findViewById(R.id.chrono_tv);
        puzzle = (TextView) findViewById(R.id.puzzle_tv);
        hints = (TextView) findViewById(R.id.hints_tv);
        answer = (EditText) findViewById(R.id.answer_et);
        check = (Button) findViewById(R.id.check_btn);
        unknown = new Random();
        phone_number = new Puzzle(unknown.nextInt(10));
        start_time();
    }

    public void check_answer(View v){
        answer.animate();
    }

    private void start_time(){
        time.setText("START!");
        puzzle.setText(phone_number.toString());
        hints.setText(phone_number.getHints());


        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText("00:" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                time.setText("Done!");
                startActivity(new Intent(game.this,over.class));
            }

        }.start();
    }
}
