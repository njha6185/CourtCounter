package com.example.nitishkumar.courtcounter;

import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0, scoreTeamB=0;
    long timeWhenStopped = 0;
    Chronometer chronometer;
    Button startStopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        chronometer = (Chronometer)findViewById(R.id.chronometer_timer);
        startStopButton = (Button)findViewById(R.id.start_stop_timer_button);
    }
    public void displayForTeamA(int score)
    {
        TextView scoreView = (TextView)findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score)
    {
        TextView scoreView = (TextView)findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void threePointForTeamA(View view)
    {
        scoreTeamA+=3;
        displayForTeamA(scoreTeamA);
    }
    public void twoPointForTeamA(View view)
    {
        scoreTeamA+=2;
        displayForTeamA(scoreTeamA);
    }
    public void freeThrowPointForTeamA(View view)
    {
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);
    }

    public void threePointForTeamB(View view)
    {
        scoreTeamB+=3;
        displayForTeamB(scoreTeamB);
    }
    public void twoPointForTeamB(View view)
    {
        scoreTeamB+=2;
        displayForTeamB(scoreTeamB);
    }
    public void freeThrowPointForTeamB(View view)
    {
        scoreTeamB+=1;
        displayForTeamB(scoreTeamB);
    }
    public void startStopTimer(View view)
    {
        if(startStopButton.getText().equals("START"))
        {
            chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
            chronometer.start();
            startStopButton.setText("PAUSE");
        }
        else
        {
            timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
            chronometer.stop();
            startStopButton.setText("START");
        }
    }
    public void reset(View view)
    {
        scoreTeamA=0;
        displayForTeamA(scoreTeamA);
        scoreTeamB=0;
        displayForTeamB(scoreTeamB);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.stop();
        startStopButton.setText("START");
        timeWhenStopped = 0;
    }
}
