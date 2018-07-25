package com.luis.batteryalert;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class StartStopActivity extends AppCompatActivity {

    private Switch sOnOff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_start_stop );
       

        sOnOff = findViewById( R.id.onoff );
        sOnOff.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){

                    checkBattery();


                }else{


                    Toast.makeText( StartStopActivity.this, "OFF", Toast.LENGTH_SHORT ).show();
                }
            }
        } );


    }

    public void checkBattery() {

        BatteryManager bm = (BatteryManager) getSystemService( BATTERY_SERVICE );
        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);

        Intent intent = new Intent();
        PendingIntent pIntent = PendingIntent.getActivity(StartStopActivity.this, 0, intent, 0);

        if (batLevel == 100) {

            //Toast.makeText( this, "FULL POWAAAA!!!", Toast.LENGTH_SHORT ).show();
            Notification not100 = new Notification.Builder( StartStopActivity.this )
                    .setTicker("100% Battery Reached")
                    .setContentTitle("FULL POWAAAA!!!")
                    .setContentText("Your device reached the MAX POWER")
                    .setSmallIcon( R.drawable.ic_launcher_foreground )
                    .setContentIntent(pIntent).build();

            not100.flags = Notification.FLAG_AUTO_CANCEL;
            NotificationManager nm = (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
            nm.notify(0, not100);

        }else if(batLevel == 75){

            Toast.makeText( this, "75% Full and 25% Empty", Toast.LENGTH_SHORT ).show();
            Notification not75 = new Notification.Builder( StartStopActivity.this )
                    .setTicker("75% Battery Reached")
                    .setContentTitle("75% Full and 25% Empty")
                    .setContentText("Starting to feel satisfied")
                    .setSmallIcon( R.drawable.ic_launcher_foreground )
                    .setContentIntent(pIntent).build();

            not75.flags = Notification.FLAG_AUTO_CANCEL;
            NotificationManager nm = (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
            nm.notify(0, not75);


        }else if(batLevel == 50){

            Toast.makeText( this, "fifty-fifty", Toast.LENGTH_SHORT ).show();
            Notification not50 = new Notification.Builder( StartStopActivity.this )
                    .setTicker("50% Battery Reached")
                    .setContentTitle("Fifty-Fifty")
                    .setContentText("Half-sad, half-satisfied")
                    .setSmallIcon( R.drawable.ic_launcher_foreground )
                    .setContentIntent(pIntent).build();

            not50.flags = Notification.FLAG_AUTO_CANCEL;
            NotificationManager nm = (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
            nm.notify(0, not50);


        }else if(batLevel == 25){

            Toast.makeText( this, "feed me preaseee!", Toast.LENGTH_SHORT ).show();
            Notification not25 = new Notification.Builder( StartStopActivity.this )
                    .setTicker("25% Battery Reached")
                    .setContentTitle("feed me preaseee!")
                    .setContentText("SAD!")
                    .setSmallIcon( R.drawable.ic_launcher_foreground )
                    .setContentIntent(pIntent).build();

            not25.flags = Notification.FLAG_AUTO_CANCEL;
            NotificationManager nm = (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
            nm.notify(0, not25);
        }else if(batLevel == 1){

            Toast.makeText( this, "I'M DYING!!!!!!!!", Toast.LENGTH_SHORT ).show();
            Notification not1 = new Notification.Builder( StartStopActivity.this )
                    .setTicker("1% Battery")
                    .setContentTitle("I'M DYING!!!!!!!!")
                    .setContentText("At the gates of hell")
                    .setSmallIcon( R.drawable.ic_launcher_foreground )
                    .setContentIntent(pIntent).build();

            not1.flags = Notification.FLAG_AUTO_CANCEL;
            NotificationManager nm = (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
            nm.notify(0, not1);
        }else{
            Toast.makeText( this, "Currently on: "+ batLevel+"%", Toast.LENGTH_SHORT ).show();


        }
    }
}
