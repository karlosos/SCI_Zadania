package com.example.kvr.android7;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
    TextView odbior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        odbior = (TextView)findViewById(R.id.textView4);

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

    public void wyslij(View v) {

        EditText tresc = (EditText)findViewById(R.id.tekstSms);
        EditText numer = (EditText)findViewById(R.id.numer);

        Toast.makeText(getBaseContext(), tresc.getText().toString() + " , " + numer.getText().toString(), Toast.LENGTH_LONG).show();
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(numer.getText().toString(), null, tresc.getText().toString(), null, null);
    }
}
