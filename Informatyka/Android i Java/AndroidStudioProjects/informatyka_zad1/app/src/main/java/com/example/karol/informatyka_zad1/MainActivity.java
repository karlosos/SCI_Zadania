package com.example.karol.informatyka_zad1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends Activity {
    Toast msg;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, Activity2.class);
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

    public void buttonClick(View v) {
        final EditText nameText;
        final EditText surnameText;
        final EditText phoneText;
        final EditText emailText;
        final EditText dataText;
        final RadioGroup zainteresowaniaGroup;
        final RadioButton zainteresowanie;


        // get EditText by id
        nameText = (EditText) findViewById(R.id.name);
        surnameText = (EditText) findViewById(R.id.surname);
        phoneText = (EditText) findViewById(R.id.editText);
        emailText = (EditText) findViewById(R.id.editText2);
        dataText = (EditText) findViewById(R.id.editText3);
        zainteresowaniaGroup = (RadioGroup) findViewById(R.id.radioGroup);
        zainteresowanie = (RadioButton) findViewById(zainteresowaniaGroup.getCheckedRadioButtonId());

        String nameString = nameText.getText().toString();
        String surnameString = surnameText.getText().toString();
        String phoneString = phoneText.getText().toString();
        String emailString = emailText.getText().toString();
        String dataString = dataText.getText().toString();
        String zainteresowanieString = zainteresowanie.getText().toString();

        String message = "Imie: " + nameString;
        message += " Nazwisko: " + surnameString;
        message += " Telefon: " + phoneString;
        message += " Email: " + emailString;
        message += " Data: " + dataString;
        message += " Zainteresowanie:" + zainteresowanieString;
// Store EditText in Variable

        msg.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

        intent.putExtra("dane", message);
        startActivity(intent);

//        new AlertDialog.Builder(this)
//                .setTitle("Twoje dane")
//                .setMessage(message)
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // continue with delete
//                    }
//                })
//                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // do nothing
//                    }
//                })
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .show();
  }
}
