package com.example.karol.spra;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


public class Gallery extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery, menu);
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


    public void gallery (View v) {
        CheckBox memory = (CheckBox) findViewById(R.id.memory);
        CheckBox sdcard = (CheckBox) findViewById(R.id.sdcard);

        if(memory.isChecked() && sdcard.isChecked()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Musisz wybrac jedna opcje", Toast.LENGTH_SHORT);
            toast.show();
        } else if (!memory.isChecked() && !sdcard.isChecked()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Musisz wybrac jedna opcje", Toast.LENGTH_SHORT);
            toast.show();
        } else if (memory.isChecked()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
            startActivity(Intent.createChooser(intent, "Choose browser"));
        } else if (sdcard.isChecked()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
            startActivity(Intent.createChooser(intent, "Choose browser"));
        }
    }
}
