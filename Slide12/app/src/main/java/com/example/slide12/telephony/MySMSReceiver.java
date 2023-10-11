package com.example.slide12.telephony;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            SmsMessage[] smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            for (SmsMessage smsMessage : smsMessages) {
                String msg = smsMessage.getMessageBody();
                long when = smsMessage.getTimestampMillis();
                String from = smsMessage.getOriginatingAddress();
                Toast.makeText(context, "SMS Received from " + from + " at " +
                        when + " with message: " + msg, Toast.LENGTH_LONG).show();
            }
        }

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            for (Object obj : pdus) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("5556", null, "Hello from MySMSReceiver", null, null);
            }
        }
    }
}
