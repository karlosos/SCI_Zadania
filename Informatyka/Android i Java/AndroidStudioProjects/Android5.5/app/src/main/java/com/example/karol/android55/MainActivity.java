package com.example.karol.android55;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private final String DB_NAME = "Baza.db";
    private SQLiteDatabase baza = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            baza = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            baza.execSQL("CREATE TABLE `wplaty` (" +
                    "`kwota`REAL," +
                    "`opis`TEXT," +
                    "`data`TEXT" +
                    ");");

            baza.execSQL("CREATE TABLE `wyplaty` (" +
                    "`kwota`REAL," +
                    "`opis`TEXT," +
                    "`data`TEXT" +
                    ");");

        } catch(SQLiteException e) {
            Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        }
    }

    public void wyslij(View v) {
        Double kwota = Double.parseDouble(findViewById(R.id.kwota).toString());
        String data = findViewById(R.id.data).toString();
        String opis = findViewById(R.id.opis).toString();

        boolean wyplata = findViewById(R.id.switch1).isEnabled();

        String sql = "";
        if (wyplata) {
            sql = "INSERT INTO wyplaty VALUES("+kwota+", "+data+", "+opis+")";
            Toast.makeText(getBaseContext(), "Wplacono pieniadze", Toast.LENGTH_LONG);
        } else {
            sql = "INSERT INTO wplaty VALUES("+kwota+", "+data+", "+opis+")";
            Toast.makeText(getBaseContext(), "Wyplacono pieniadze", Toast.LENGTH_LONG);
        }

        baza.execSQL(sql);

    }

    public void stanKonta(View v) {
        Double wyplaty = 0.;
        Double wplaty = 0.;
        Cursor cursor = baza.rawQuery("SELECT sum(kwota) as suma FROM wyplaty", null);
        if(cursor.moveToFirst()) {
            wyplaty = cursor.getDouble(cursor.getColumnIndex("suma"));
        }
        cursor.close();

        cursor = baza.rawQuery("SELECT sum(kwota) as suma FROM wplaty", null);
        if(cursor.moveToFirst()) {
            wplaty = cursor.getDouble(cursor.getColumnIndex("suma"));
        }
        cursor.close();

        Double saldo = wplaty - wyplaty;
        Toast.makeText(getBaseContext(), "Saldo: " + saldo.toString(), Toast.LENGTH_LONG);
    }

    public void najwiekszaWyplata(View v) {
        Cursor cursor = baza.rawQuery("SELECT max(kwota) as kwota, opis, data FROM wyplaty", null);
        Double max = 0.;
        String opis = "";
        String data = "";
        if(cursor.moveToFirst()) {
            max = cursor.getDouble(cursor.getColumnIndex("kwota"));
            opis = cursor.getString(cursor.getColumnIndex("opis"));
            data = cursor.getString(cursor.getColumnIndex("data"));
        }

        cursor.close();

        Toast.makeText(getBaseContext(), "Najwieksza wyplata to: " + max.toString() + " zł. Opis: " + opis + " Data: " + data, Toast.LENGTH_LONG);
    }


    public void najwiekszaWplata(View v) {
        Cursor cursor = baza.rawQuery("SELECT max(kwota) as kwota, opis, data FROM wyplaty", null);
        Double max = 0.;
        String opis = "";
        String data = "";
        if(cursor.moveToFirst()) {
            max = cursor.getDouble(cursor.getColumnIndex("kwota"));
            opis = cursor.getString(cursor.getColumnIndex("opis"));
            data = cursor.getString(cursor.getColumnIndex("data"));
        }

        cursor.close();

        Toast.makeText(getBaseContext(), "Najwieksza wplata to: " + max.toString() + " zł. Opis: " + opis + " Data: " + data, Toast.LENGTH_LONG);
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
}
