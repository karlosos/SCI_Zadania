package com.example.karol.spra;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        if (id == R.id.gallery) {
            Intent intent  = new Intent(this, Gallery.class);
            startActivity(intent);
        } else if (id == R.id.dialer) {
            EditText number = (EditText) findViewById(R.id.editText);
            Uri call = Uri.parse("tel:" + number);
            Intent dialer = new Intent(Intent.ACTION_CALL, call);
            startActivity(dialer);
        } else if (id == R.id.draw) {
            Intent intent  = new Intent(this, Draw.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
