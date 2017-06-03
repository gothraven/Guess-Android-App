package guess.guess;

import android.content.Intent;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import static java.lang.System.exit;

public class Help extends AppCompatActivity {
    private ProgressBar progress;
    private EditText playername;
    private TextView showname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        progress = (ProgressBar) findViewById(R.id.progress_pb);
        playername = (EditText) findViewById(R.id.playername_tx);
        showname = (TextView) findViewById(R.id.name_tv);
        progress.setProgress(0);


    }

    public void start_game(View v){
        String name = playername.getText().toString();
        if(name.equals("")) {
            showname.setText("please specify your name!!!");
            return;
        }else {
            showname.setText("Prepare your self, " + name + "!!!");
        }
        new CountDownTimer(3000, 1000) {
            int i = 1;

            public void onTick(long millisUntilFinished) {
                progress.setProgress(i * 100 / 3);
                i++;
            }

            public void onFinish() {
                progress.setProgress(100);
                startActivity(new Intent(Help.this, game.class));
                i++;
            }

        }.start();
    }

}

