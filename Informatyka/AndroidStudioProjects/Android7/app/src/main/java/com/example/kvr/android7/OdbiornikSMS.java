package com.example.kvr.android7;


import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class OdbiornikSMS extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Bundle bundle = arg1.getExtras();
        SmsMessage[] msgs=null;
        String wiadomosc="";
        Object[] pdus =(Object[])bundle.get("pdus");
        msgs=new SmsMessage[pdus.length];
        for(int x=0;x<msgs.length;x++){
            msgs[x]=SmsMessage.createFromPdu((byte[]) pdus[x]);
            wiadomosc=msgs[x].getMessageBody();
            Toast.makeText(arg0, wiadomosc, Toast.LENGTH_LONG).show();
        }
    }
}
