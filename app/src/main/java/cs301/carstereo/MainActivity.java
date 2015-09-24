package cs301.carstereo;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    public static final int BUTTON_COLOR = 0xffd6d7d7;
    Button powerBtn;
    TextView display;
    TextView tunertext;
    TextView signalText;
    TextView volumeText;
    int toggle = 0;
    ImageButton stop;
    ImageButton play;
    ImageButton eject;
    ImageButton skip;
    ImageButton reverse;
    ImageButton pause;
    ToggleButton amfmBtn;
    SeekBar tuner;
    int[] amFavorites = {550, 600, 650, 700, 750, 800};
    double[] fmFavorites = {90.9, 92.9, 94.9, 96.9, 98.9, 100.9};

    //true means FM, false means AM
    boolean amfm = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        powerBtn = (Button) findViewById(R.id.powerButton);
        display = (TextView) findViewById(R.id.display);
        stop = (ImageButton) findViewById(R.id.stopButton);
        play = (ImageButton) findViewById(R.id.playButton);
        eject = (ImageButton) findViewById(R.id.ejectButton);
        skip = (ImageButton) findViewById(R.id.skipButton);
        reverse = (ImageButton) findViewById(R.id.reverseButton);
        pause = (ImageButton) findViewById(R.id.pauseButton);
        tunertext = (TextView) findViewById(R.id.tunerText);
        volumeText = (TextView) findViewById(R.id.volumeText);
        signalText = (TextView) findViewById(R.id.signalText);
        amfmBtn = (ToggleButton) findViewById(R.id.amfmSwitch);
        amfmBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    signalText.setText("FM");
                    display.setText("88.1");
                }
                else{
                    signalText.setText("AM");
                    display.setText("530");
                }
            }
        });

        tuner = (SeekBar) findViewById(R.id.tunerSlider);
        tuner.setMax(99);
        tuner.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (signalText.getText().equals("FM")) {
                    tuner.setMax(99);
                    int stnProg = tuner.getMax() - progress;
                    int stationNum = 881 + stnProg * 2;
                    double stationDouble = (double) stationNum;
                    stationDouble = stationDouble / 10;
                    display.setText(Double.toString(stationDouble));

                } else if(signalText.getText().equals("AM")) {
                    tuner.setMax(117);
                    int stnProg = tuner.getMax() - progress;
                    int stationNum = 530 + stnProg * 10;
                    display.setText(Integer.toString(stationNum));

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            //unused
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            //unused
            }

        });

        //Part 3 ---------------------------------------------------------------------------------

        eject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(signalText.getText().equals("AM"))
                    display.setText(Integer.toString(amFavorites[0]));
                else{
                    display.setText(Double.toString(fmFavorites[0]));
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signalText.getText().equals("AM"))
                    display.setText(Integer.toString(amFavorites[1]));
                else {
                    display.setText(Double.toString(fmFavorites[1]));
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signalText.getText().equals("AM"))
                    display.setText(Integer.toString(amFavorites[2]));
                else {
                    display.setText(Double.toString(fmFavorites[2]));
                }
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signalText.getText().equals("AM"))
                    display.setText(Integer.toString(amFavorites[3]));
                else {
                    display.setText(Double.toString(fmFavorites[3]));
                }
            }
        });
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signalText.getText().equals("AM"))
                    display.setText(Integer.toString(amFavorites[4]));
                else {
                    display.setText(Double.toString(fmFavorites[4]));
                }
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signalText.getText().equals("AM"))
                    display.setText(Integer.toString(amFavorites[5]));
                else {
                    display.setText(Double.toString(fmFavorites[5]));
                }
            }
        });

        //PART4 ----------------------------------------------------------------------------------

        eject.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(signalText.getText().equals("AM")){

                    amFavorites[0] = Integer.parseInt((String)display.getText());
                    return true;
                }
                else{
                    fmFavorites[0] = Double.parseDouble((String) display.getText());
                    return true;
                }
            }
        });

        stop.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(signalText.getText().equals("AM")){

                    amFavorites[1] = Integer.parseInt((String)display.getText());
                    return true;
                }
                else{
                    fmFavorites[1] = Double.parseDouble((String) display.getText());
                    return true;
                }
            }
        });

        pause.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (signalText.getText().equals("AM")) {

                    amFavorites[2] = Integer.parseInt((String) display.getText());
                    return true;
                } else {
                    fmFavorites[2] = Double.parseDouble((String) display.getText());
                    return true;
                }
            }
        });

        play.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(signalText.getText().equals("AM")){

                    amFavorites[3] = Integer.parseInt((String)display.getText());
                    return true;
                }
                else{
                    fmFavorites[3] = Double.parseDouble((String) display.getText());
                    return true;
                }
            }
        });

        reverse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (signalText.getText().equals("AM")) {

                    amFavorites[4] = Integer.parseInt((String) display.getText());
                    return true;
                } else {
                    fmFavorites[4] = Double.parseDouble((String) display.getText());
                    return true;
                }
            }
        });

        skip.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (signalText.getText().equals("AM")) {

                    amFavorites[5] = Integer.parseInt((String) display.getText());
                    return true;
                } else {
                    fmFavorites[5] = Double.parseDouble((String) display.getText());
                    return true;
                }
            }
        });



    }


    public void onClickPowerBtn(View view) {
        if(toggle == 0) {
            //if the user presses the off button
            display.setTextColor(Color.BLACK);
            signalText.setTextColor(Color.BLACK);
            stop.setBackgroundColor(Color.BLACK);
            play.setBackgroundColor(Color.BLACK);
            eject.setBackgroundColor(Color.BLACK);
            skip.setBackgroundColor(Color.BLACK);
            reverse.setBackgroundColor(Color.BLACK);
            pause.setBackgroundColor(Color.BLACK);
            tunertext.setTextColor(0xff424242);
            volumeText.setTextColor(0x80323232);
            toggle++;
            return;
        }
        if(toggle == 1){
            //user presses on
            display.setTextColor(Color.GREEN);
            signalText.setTextColor(Color.GREEN);
            stop.setBackgroundColor(BUTTON_COLOR);
            play.setBackgroundColor(BUTTON_COLOR);
            eject.setBackgroundColor(BUTTON_COLOR);
            skip.setBackgroundColor(BUTTON_COLOR);
            reverse.setBackgroundColor(BUTTON_COLOR);
            pause.setBackgroundColor(BUTTON_COLOR);
            tunertext.setTextColor(Color.WHITE);
            volumeText.setTextColor(Color.WHITE);
            toggle--;
            return;
        }
    }

}
