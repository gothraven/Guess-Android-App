package guess.guess;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.TextView;

public class game extends AppCompatActivity {
    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        time = (TextView) findViewById(R.id.chrono_tv);
        start_time();
    }


    private void start_time(){
        time.setText("START!");
        CountDownTimer chronom = new CountDownTimer(30000, 1000) {

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
