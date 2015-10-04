package com.example.karol.testsprawdzian;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import java.sql.SQLDataException;


public class MainActivity extends ActionBarActivity {
    RadioButton typSeansu2D;
    RadioButton rodzajBiletuNormalny;
    CheckBox popcorn;
    CheckBox coca_cola;
    CheckBox vip;

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typSeansu2D = (RadioButton) findViewById(R.id.typSeansu2D);
        rodzajBiletuNormalny = (RadioButton) findViewById(R.id.rodzajBiletuNormalny);
        popcorn = (CheckBox) findViewById(R.id.popcorn);
        coca_cola = (CheckBox) findViewById(R.id.coca_cola);
        vip = (CheckBox) findViewById(R.id.vip);


        try {
            database = this.openOrCreateDatabase("baza.sql", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS bilety (Rodzaj VARCHAR, Typ VARCHAR, Cola INTEGER, Vip INTEGER)");
        }
        catch (SQLiteException e) {
            Log.e(getClass().getSimpleName(), "Ojej");
        }
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

    public void Rezerwuj(View v) {
        Double kwota = 0.;
        String rodzaj = "";
        String typ = "";
        Integer Cola = 0;
        Integer Vip = 0;
        if(typSeansu2D.isChecked()) {
            kwota += 0;
            typ = "2D";
        } else {
            kwota += 10;
            typ = "3D";
        }

        if(rodzajBiletuNormalny.isChecked()) {
            kwota += 30;
            rodzaj = "Normalny";
        } else {
            kwota += 20;
            rodzaj = "Ulgowy";
        }

        if(popcorn.isChecked()) {
            kwota += 10;
        }
        if(vip.isChecked()) {
            kwota += 5;
            Vip = 1;
        }
        if(coca_cola.isChecked()) {
            kwota += 10;
            Cola = 1;
        }

        database.execSQL("INSERT INTO bilety VALUES('"+rodzaj+"','"+typ+"',"+Cola.toString()+","+Vip.toString()+");");

        // Tutaj wysylamy do bazy
        Toast.makeText(getBaseContext(), "Do zaplaty: " + kwota.toString(), Toast.LENGTH_LONG).show();
    }

    public void Ilosc (View v) {
        Cursor cursor = database.rawQuery("SELECT COUNT(*) as ilosc FROM bilety", null);
        Integer ilosc = 0;
        if (cursor.moveToFirst()) {
            ilosc = cursor.getInt(cursor.getColumnIndex("ilosc"));
        }
        Toast.makeText(getBaseContext(), ilosc.toString(), Toast.LENGTH_LONG).show();
    }
}
