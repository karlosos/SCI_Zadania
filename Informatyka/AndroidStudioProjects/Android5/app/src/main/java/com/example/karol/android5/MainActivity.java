package com.example.karol.android5;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private final String DB_NAME = "Baza.db";// Nazwa dla nowej bazy
    SQLiteDatabase baza = null;
    private Button wyslij;
    private Button liczba_komentarzy;

    private EditText name;
    private EditText email;
    private EditText comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        wyslij = (Button) findViewById(R.id.button);
        liczba_komentarzy = (Button) findViewById(R.id.button);

        name = (EditText) findViewById(R.id.editText);
        email = (EditText) findViewById(R.id.editText2);
        comment = (EditText) findViewById(R.id.editText3);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            baza = this.openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            baza.execSQL("CREATE TABLE IF NOT EXISTS Persons (FirstName VARCHAR, Email VARCHAR, Comment VARCHAR)");
        }
        catch(SQLiteException e) {
            Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        }

        baza.execSQL("INSERT INTO Persons Values('Donald', 'a@wp.pl','ala ma kota koment');");
        baza.execSQL("INSERT INTO Persons Values('Donald', 'a@wp.pl','ala ma kota komentarz 2 ');");
        baza.execSQL("INSERT INTO Persons Values('Donald', 'a@a.pl','ala ma kota');");
        baza.execSQL("INSERT INTO Persons Values('Donald', 'a@a.pl','ala ma kota');");
        baza.execSQL("INSERT INTO Persons Values('Donald', 'a@wp.pl','ala ma kota hehehehehe ');");
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

    public void dodajKomentarz(View v) {

        String name_s = name.getText().toString();
        String email_s = email.getText().toString();
        String comment_s = comment.getText().toString();

        baza.execSQL("INSERT INTO Persons Values('"+name_s+"', '"+email_s+"','"+comment_s+"');");
        Toast toast = Toast.makeText(getApplicationContext(), "\"INSERT INTO Persons Values('\"+name_s+\"', '\"+email_s+\"','\"+comment_s+\"');\"", Toast.LENGTH_SHORT);
        toast.show();
    }
}
