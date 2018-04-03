package com.example.database.dani.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    Button notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notify=findViewById(R.id.notifybtn);

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Intent intent = new Intent();
                    PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                    Notification  noti = new Notification.Builder(MainActivity.this).setTicker("Breaking News")
                            .setContentTitle("Content Title").setContentText("Content Text").setSmallIcon(R.drawable.android_head)
                            .addAction(R.drawable.download,"First Pic",pendingIntent)
                            .addAction(R.drawable.ic_system_update_black_24dp,"Second Pic",pendingIntent)
                            .setContentIntent(pendingIntent).getNotification();

                    noti.flags= Notification.FLAG_AUTO_CANCEL;
                    NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.notify(0,noti) ;
                }catch (Exception ex){
                    Log.e("Exception",ex.toString());
                }finally {
                    Intent i = new Intent(MainActivity.this,List_Activity.class);
                    startActivity(i);

                }



            }
        });
    }
}
