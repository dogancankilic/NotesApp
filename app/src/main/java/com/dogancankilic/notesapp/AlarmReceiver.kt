package com.dogancankilic.notesapp

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.*

class AlarmReceiver:BroadcastReceiver() {
    var random = Random()
    var randoms = random.nextInt(9999 - 1000) * 1000
    override fun onReceive(context:Context, intent:Intent) {
        // Get id & message from intent.
        val notificationId = intent.getIntExtra("notificationId", 0)
        val message = intent.getStringExtra("todo")
        // When notification is tapped, call MainActivity.
        val mainIntent = Intent(context, AlarmActivity::class.java)
        val contentIntent = PendingIntent.getActivity(context, 0, mainIntent, 0)
        val myNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        // Prepare notification.
        val builder = Notification.Builder(context)
        builder.setSmallIcon(R.drawable.alarmon)
                .setContentTitle("Hatırlatıcı")
                .setContentText(message)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contentIntent)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_ALL)
        // Notify
        myNotificationManager.notify(randoms, builder.build())
    }
}