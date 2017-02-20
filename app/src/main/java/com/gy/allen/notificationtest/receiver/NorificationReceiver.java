package com.gy.allen.notificationtest.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import com.gy.allen.notificationtest.R;
import com.gy.allen.notificationtest.activity.NotificationA;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by allen on 17/2/17.
 */

public class NorificationReceiver extends BroadcastReceiver {
    PendingIntent pendingIntent;
    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("name");
        String content = intent.getStringExtra("content");
        Intent intentTwo = new Intent(context,NotificationA.class);

        pendingIntent = PendingIntent.getActivity(context,0,intentTwo,0);

        NotificationManager manager = (NotificationManager)context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle(name)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(content))
                .setVibrate(new long[]{0,1000,1000,1000})
                .build();
        manager.notify(1,notification);

    }
}
