package com.example.karol.spra;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class Draw extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_draw, menu);
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

    public void draw (View v) {
        RadioButton square = (RadioButton) findViewById(R.id.square);
        RadioButton circle = (RadioButton) findViewById(R.id.circle);
        CheckBox shadow = (CheckBox) findViewById(R.id.shadow);
        EditText weight = (EditText) findViewById(R.id.weight);
        String start = "Rysuje ";
        String shape = "";
        String mid = " o grubosci ";
        String px = " px ";
        String sh = "";
        String end = " cieniowania";
        if (square.isChecked()) {
            shape = "kwadrat";
        } else if (circle.isChecked()) {
            shape = "okrag";
        }

        if (shadow.isChecked()) {
            sh = "z";
        } else {
            sh = "bez";
        }

        sh = weight.getText().toString();

        Toast toast = Toast.makeText(getApplicationContext(), start + shape + mid + sh + px + end, Toast.LENGTH_SHORT);
        toast.show();
    }
}
