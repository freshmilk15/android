package com.example.administrator.notificationtest2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.sentnotice);
        button.setOnClickListener(this
               /* new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NotificationManager manager =  (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                //Notification notification = new NotificationCompat.Builder(MainActivity.this,"default")
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("this is title")
                        .setContentText("this is text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .build();
                manager.notify(20,notification);
            }
        }*/

        );


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sentnotice:
                Intent intent = new Intent(this,NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);

                NotificationManager manager =  (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("this is title")
                        .setContentText("this is text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentIntent(pi)
                        .setVibrate(new long[]{0,1000,1000,1000})
                        .build();
                manager.notify(3,notification);


                break;
            default:
                break;
        }
    }
}
