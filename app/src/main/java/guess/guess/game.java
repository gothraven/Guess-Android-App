package guess.guess;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;

public class game extends AppCompatActivity {
    private TextView time;
    private TextView puzzle;
    private TextView hint1;
    private TextView hint2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        time = (TextView) findViewById(R.id.chrono_tv);
        puzzle = (TextView) findViewById(R.id.puzzle_tv);

        hint1 = (TextView) findViewById(R.id.hint1_tv);
        hint2 = (TextView) findViewById(R.id.hint2_tv);
        start_time();
    }


    private void start_time(){
        time.setText("START!");

        Puzzle phone_number = new Puzzle();
        puzzle.setText(phone_number.toString());
        hint1.setText(phone_number.getHint(0));
        hint2.setText(phone_number.getHint(1));

        CountDownTimer chronom = new CountDownTimer(5000, 1000) {
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
