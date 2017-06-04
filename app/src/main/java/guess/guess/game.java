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
    private TextView puzzle_tv;
    private TextView hints;
    private TextView status;
    private TextView score_show;
    private Random unknown;
    private EditText answer;
    private Puzzle puzzle;
    private int score;
    private CountDownTimer chrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        time = (TextView) findViewById(R.id.chrono_tv);
        puzzle_tv = (TextView) findViewById(R.id.puzzle_tv);
        hints = (TextView) findViewById(R.id.hints_tv);
        answer = (EditText) findViewById(R.id.answer_et);
        status = (TextView) findViewById(R.id.status_tv);
        score_show = (TextView) findViewById(R.id.score_tv);
        unknown = new Random();

        score = 0;
        score_show.setText("Score : "+score);

        puzzle_init();

        chrono = new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText("00:" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                time.setText("Done!");
                startActivity(new Intent(game.this,over.class));
            }

        }.start();

    }

    public void check_answer(View v){
        String input = answer.getText().toString();
        if(input.length() != puzzle.getUnknown()){
            status.setText("WRRONNNGGG!!!!!");
        }else{
            status.setText("");
            update_score();
            next_puzzle();
        }
    }

    private void next_puzzle(){
        puzzle = null;
        puzzle = new Puzzle(unknown.nextInt(10));
        puzzle_tv.setText(puzzle.toString());
        hints.setText(puzzle.getHints());
        chrono.cancel();
        chrono.start();
    }

    private void update_score(){
        score+=132*puzzle.getUnknown();
        score_show.setText("Score : "+score);
    }

    private void puzzle_init(){
        time.setText("START!");
        puzzle = new Puzzle(unknown.nextInt(10));
        puzzle_tv.setText(puzzle.toString());
        hints.setText(puzzle.getHints());
    }
}
