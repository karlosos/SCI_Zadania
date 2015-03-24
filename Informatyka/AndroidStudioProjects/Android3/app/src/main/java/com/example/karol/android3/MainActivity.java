package com.example.karol.android3;

import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


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
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.nowe_okno) {
            Intent intent  = new Intent(this, NoweOkno.class);
            String str = "No i co sie prujesz";
            intent.putExtra("dane", str);
            startActivity(intent);

        }
        else if(id == R.id.kalendarz) {
            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setData(CalendarContract.Events.CONTENT_URI);
            startActivity(intent);
        }
        else if(id == R.id.google) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(Intent.createChooser(intent, "Choose browser"));
        }
        else if(id == R.id.pogoda) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twojapogoda.pl/polska/zachodniopomorskie/szczecin"));
            startActivity(Intent.createChooser(intent, "Choose browser"));
        }
        else if(id == R.id.zadzwon) {
            String number = "690340409";
            Uri call = Uri.parse("tel:" + number);
            Intent surf = new Intent(Intent.ACTION_DIAL, call);
            startActivity(surf);

//            String number = "7777777777";
//            Uri call = Uri.parse("tel:" + number);
//            Intent surf = new Intent(Intent.ACTION_CALL, call);
//            startActivity(surf);
        }
        else if(id == R.id.galeria) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
            startActivity(Intent.createChooser(intent, "Choose browser"));
        }


        return super.onOptionsItemSelected(item);
    }
}
