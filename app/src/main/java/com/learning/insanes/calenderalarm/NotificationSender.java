package com.learning.insanes.calenderalarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class NotificationSender extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent1 = new Intent(context, MainActivity.class);

        PendingIntent pi = PendingIntent.getActivity(context, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Builder builder = new Notification.Builder(context)
                .setContentIntent(pi)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Alarm!!!")
                .setContentText("You have got an alarm")
                .setAutoCancel(true);

        if (nm != null) {
            nm.notify(0, builder.build());
        }

    }
}
