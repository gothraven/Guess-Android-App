package guess.guess;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game extends AppCompatActivity {
    private TextView time;
    private TextView puzzle_tv;
    private TextView hints;
    private TextView score_show;
    private TextView status;
    private Random unknown;
    private EditText answer;
    private Puzzle puzzle;
    private int score;
    private CountDownTimer chrono;
    private Toast toastRight;
    private Toast toastAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        time = (TextView) findViewById(R.id.chrono_tv);
        puzzle_tv = (TextView) findViewById(R.id.puzzle_tv);
        hints = (TextView) findViewById(R.id.hints_tv);
        answer = (EditText) findViewById(R.id.answer_et);
        score_show = (TextView) findViewById(R.id.score_tv);
        status = (TextView) findViewById(R.id.status_tv);
        toastRight = Toast.makeText(getApplicationContext(),"RIGHTT!!",Toast.LENGTH_LONG);
        toastRight.setDuration(1);
        unknown = new Random();

        score = 0;
        score_show.setText("Score : "+score);

        puzzle_init();

        chrono = new CountDownTimer(100000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText(millisUntilFinished / 1000+"s");
            }

            public void onFinish() {
                time.setText("Done!");
                startActivity(new Intent(game.this,over.class));
                finish();
            }

        }.start();

    }

    public void check_answer(View v){
        String input = answer.getText().toString();
        if((input.length() != puzzle.getUnknown()) || (!input.equals(puzzle.getAnswer()))){
            status.setText("Wrong, try again!!");
        }else{
            status.setText("Great, here's another one");
            toastRight.show();
            update_score();
            next_puzzle();
        }
    }

    private void next_puzzle(){
        puzzle = null;
        puzzle = new Puzzle(unknown.nextInt(5));
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
        puzzle = new Puzzle(unknown.nextInt(5));
        puzzle_tv.setText(puzzle.toString());
        hints.setText(puzzle.getHints());
    }

    public void show_answer(View v){
        toastAnswer = Toast.makeText(getApplicationContext(),puzzle.getAnswer(),Toast.LENGTH_LONG);
        toastAnswer.setDuration(1);
        toastAnswer.show();
    }
}
