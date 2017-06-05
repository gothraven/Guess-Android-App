package guess.guess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.CallScreeningService;
import android.view.View;
import android.widget.Button;

public class over extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);

    }

    public void restart(View v){
        startActivity(new Intent(over.this,game.class));
        finish();
    }
}

