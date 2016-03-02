package com.example.james.clockin;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPref = this.getPreferences(Context.MODE_PRIVATE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickClockIn(View view) {

        // Get and save current time
        Calendar cal = Calendar.getInstance();
        Date currentTime = cal.getTime();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.saved_clock_in_time), currentTime.toString());
        editor.commit();


        // Update display
        TextView textViewClockedIn = (TextView) findViewById(R.id.textViewClockedIn);
        textViewClockedIn.setText(currentTime.toString());

        // Calculate Current Hours


        // Update output
        TextView textViewCurrentHours = (TextView) findViewById(R.id.textViewCurrentHours);
        textViewCurrentHours.setText("Current Hours: 10");

    }

}
