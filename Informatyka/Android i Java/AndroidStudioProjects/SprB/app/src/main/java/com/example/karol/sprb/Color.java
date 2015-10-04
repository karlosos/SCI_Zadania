package com.example.karol.sprb;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Color extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_color, menu);
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

    public void color(View v) {
        EditText r = (EditText)findViewById(R.id.editText);
        EditText g = (EditText)findViewById(R.id.editText2);
        EditText b = (EditText)findViewById(R.id.editText3);

        if(r.getText().toString() != "" && g.getText().toString() != "" && b.getText().toString() != "") {
            Toast toast = Toast.makeText(getApplicationContext(), "RGB("+r.getText().toString()+","+g.getText().toString()+","+b.getText().toString()+")", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
