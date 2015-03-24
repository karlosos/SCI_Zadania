package com.example.karol.android2;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Button jeden, dwa, trzy, cztery, piec, szesc, siedem, osiem, dziewiec, zero, czysc, rownasie, mnoz, dziel,
    plus, minus, poteg, pierw, sin, jedenprzezX, zmianaznaku, silnia;

    EditText disp;
    int op1;
    int op2;
    String optr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jeden = (Button) findViewById(R.id.jeden);
        dwa = (Button) findViewById(R.id.dwa);
        trzy = (Button) findViewById(R.id.trzy);
        cztery = (Button) findViewById(R.id.cztery);
        piec = (Button) findViewById(R.id.piec);
        szesc = (Button) findViewById(R.id.szesc);
        siedem = (Button) findViewById(R.id.siedem);
        osiem = (Button) findViewById(R.id.osiem);
        dziewiec = (Button) findViewById(R.id.dziewiec);
        zero = (Button) findViewById(R.id.zero);

        czysc = (Button) findViewById(R.id.czysc);
        rownasie = (Button) findViewById(R.id.rowna);
        mnoz = (Button) findViewById(R.id.mnoz);
        dziel = (Button) findViewById(R.id.dziel);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        poteg = (Button) findViewById(R.id.poteg);
        pierw = (Button) findViewById(R.id.pierw);
        sin = (Button) findViewById(R.id.sin);
        jedenprzezX = (Button) findViewById(R.id.jedenprzezX);
        zmianaznaku = (Button) findViewById(R.id.zmianaznaku);
        silnia = (Button) findViewById(R.id.silnia);

        disp = (EditText) findViewById(R.id.display);

     try {
         jeden.setOnClickListener(this);
         dwa.setOnClickListener(this);
         trzy.setOnClickListener(this);
         cztery.setOnClickListener(this);
         szesc.setOnClickListener(this);
         siedem.setOnClickListener(this);
         osiem.setOnClickListener(this);
         dziewiec.setOnClickListener(this);
         zero.setOnClickListener(this);

         czysc.setOnClickListener(this);
         rownasie.setOnClickListener(this);
         mnoz.setOnClickListener(this);
         dziel.setOnClickListener(this);
         plus.setOnClickListener(this);
         minus.setOnClickListener(this);
         poteg.setOnClickListener(this);
         pierw.setOnClickListener(this);
         sin.setOnClickListener(this);
         jedenprzezX.setOnClickListener(this);
         zmianaznaku.setOnClickListener(this);
         silnia.setOnClickListener(this);

     }
     catch(Exception e) {

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

    @Override
    public void onClick(View arg0) {
        Editable str =  disp.getText();
        switch(arg0.getId()){
            case R.id.jeden:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(jeden.getText());
                disp.setText(str);
                break;
            case R.id.dwa:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(dwa.getText());
                disp.setText(str);
                break;
            case R.id.trzy:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(trzy.getText());
                disp.setText(str);
                break;
            case R.id.cztery:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(cztery.getText());
                disp.setText(str);
                break;
            case R.id.piec:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(piec.getText());
                disp.setText(str);
                break;
            case R.id.szesc:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(szesc.getText());
                disp.setText(str);
                break;
            case R.id.siedem:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(siedem.getText());
                disp.setText(str);
                break;
            case R.id.osiem:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(osiem.getText());
                disp.setText(str);

                break;
            case R.id.dziewiec:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(dziewiec.getText());
                disp.setText(str);

                break;
            case R.id.czysc:
                op1 = 0;
                op2 = 0;
                disp.setText("");
                disp.setHint("Perform Operation :)");

                break;
            case R.id.plus:
                optr = "+";
                if(op1 == 0){
                    op1 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                }
                else if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                else{
                    op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 + op2;
                    disp.setText("Result : " + Integer.toString(op1));
                }
                break;
            case R.id.minus:
                optr = "-";
                if(op1 == 0){
                    op1 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                }
                else if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                else{
                    op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 - op2;
                    disp.setText("Result : " + Integer.toString(op1));
                }
                break;
            case R.id.mnoz:
                optr = "*";
                if(op1 == 0){
                    op1 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                }
                else if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                else{
                    op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 * op2;
                    disp.setText("Result : " + Integer.toString(op1));
                }
                break;
            case R.id.dziel:
                optr = "/";
                if(op1 == 0){
                    op1 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                }
                else if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                else{
                    op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 / op2;
                    disp.setText("Result : " + Integer.toString(op1));
                }
                break;
            case R.id.rowna:
                if(!optr.equals(null)){
                    if(op2 != 0){
                        if(optr.equals("+")){
                            disp.setText("");
							/*op1 = op1 + op2;*/
                            disp.setText("Result : " + Integer.toString(op1));
                        }
                        else if(optr.equals("-")){
                            disp.setText("");/*
							op1 = op1 - op2;*/
                            disp.setText("Result : " + Integer.toString(op1));
                        }
                        else if(optr.equals("*")){
                            disp.setText("");/*
							op1 = op1 * op2;*/
                            disp.setText("Result : " + Integer.toString(op1));
                        }
                        else if(optr.equals("/")){
                            disp.setText("");/*
							op1 = op1 / op2;*/
                            disp.setText("Result : " + Integer.toString(op1));
                        }
                    }
                    else{
                        operation();
                    }
                }
                break;
        }
    }

    public void operation(){
        if(optr.equals("+")){
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 + op2;
            disp.setText("Result : " + Integer.toString(op1));
        }
        else if(optr.equals("-")){
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 - op2;
            disp.setText("Result : " + Integer.toString(op1));
        }
        else if(optr.equals("*")){
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 * op2;
            disp.setText("Result : " + Integer.toString(op1));
        }
        else if(optr.equals("/")){
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 / op2;
            disp.setText("Result : " + Integer.toString(op1));
        }
    }



}
