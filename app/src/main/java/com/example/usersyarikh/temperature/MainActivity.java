package com.example.usersyarikh.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    import com.example.usersyarikh.Before;
    import com.example.usersyarikh.Test;
    import com.example.usersyarikh.runner.RunWith;
    import com.example.usersyarikh.Robolectric;
    import com.example.usersyarikh.RobolectricTestRunner;
    import com.example.usersyarikh.annotation.Config;

import static com.example.usersyarikh.Assert.*;

    @RunWith(RobolectricTestRunner.class)
    @Config(constants = BuildConfig.class, sdk = 21)

    public class ActivityTest {
        private MainActivity activity;
        private Converter conv;
        private double min = 0.0;//  Min Temperature Value
        private double max = 100.0; //    Max Temperature Value

        @Before     public void initTest() {
            activity = Robolectric.buildActivity(MainActivity.class).create().get();
            conv = new Converter();
        }



        When activity was already created, run the ActivityTest.java. If passed this picture will be shown.


        Example if failed:




        @Test
        public void farenheitButtonClicking() {
            double x = (int)(Math.random()*((max-min)+1))+min;
            activity.inputVal.setText(Double.toString(x));
            activity.farenheitAct.performClick();

            conv.setTemperature(x);
            assertEquals("Farenheit Failed !!",conv.getFarenheit()+" Farenheit",activity.resultVal.getText().toString());
        }

        @Test
        public void kelvinButtonClicking() {
            double x = (int)(Math.random()*((max-min)+1))+min;
            activity.inputVal.setText(Double.toString(x));
            activity.kelvinAct.performClick();

            conv.setTemperature(x);
            assertEquals("Kelvin Failed !!",conv.getKelvin()+" Kelvin",activity.resultVal.getText().toString());
        }
    }
