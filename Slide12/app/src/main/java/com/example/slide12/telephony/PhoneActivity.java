package com.example.slide12.telephony;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import com.example.slide12.R;

public class PhoneActivity extends AppCompatActivity {
    TextView txtPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        txtPhone = (TextView) findViewById(R.id.textView2);
        //get phone information: device id, phone number, ...
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        Intent whoYouGonnaCall = new Intent(Intent.ACTION_CALL);
        whoYouGonnaCall.setData(Uri.parse("tel:0123456789"));
        startActivity(whoYouGonnaCall);

        //attributes
        String IMEINumber = tm.getDeviceId();
        String subscriberID = tm.getDeviceId();
        String SIMSerialNumber = tm.getSimSerialNumber();
        String networkCountryISO = tm.getNetworkCountryIso();
        String SIMCountryISO = tm.getSimCountryIso();
        String softwareVersion = tm.getDeviceSoftwareVersion();
        String voiceMailNumber = tm.getVoiceMailNumber();

        String strPhoneType = "";
        int phoneType = tm.getPhoneType();
        switch (phoneType) {
            case (TelephonyManager.PHONE_TYPE_CDMA):
                strPhoneType = "CDMA";
                break;
            case (TelephonyManager.PHONE_TYPE_GSM):
                strPhoneType = "GSM";
                break;
            case (TelephonyManager.PHONE_TYPE_NONE):
                strPhoneType = "NONE";
                break;
        }

        boolean isRoaming = tm.isNetworkRoaming();

        String info = "Phone Details:\n";
        info += "\n IMEI Number: " + IMEINumber;
        info += "\n SubscriberID: " + subscriberID;
        info += "\n Sim Serial Number: " + SIMSerialNumber;
        info += "\n Network Country ISO: " + networkCountryISO;
        info += "\n SIM Country ISO: " + SIMCountryISO;
        info += "\n Software Version: " + softwareVersion;
        info += "\n Voice Mail Number: " + voiceMailNumber;
        info += "\n Phone Network Type: " + strPhoneType;
        info += "\n In Roaming? : " + isRoaming;

        txtPhone.setText(info);
    }
}