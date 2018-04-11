package com.example.android.basicnotifications;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;

public class MainActivity extends Activity {

    public static final int NOTIFICATION_ID = 2;
    String id = "my_channel_02";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_layout);

    }

    public void sendNotification(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Intent.EXTRA_KEY_EVENT, NOTIFICATION_ID);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id)
                .setSmallIcon(R.drawable.ic_stat_notification)
                .setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));

        builder.setContentTitle("Testando Basica Notifications!");
        builder.setContentText("Testado com sucesso!");
        builder.setSubText("Tap to view documentation about notifications.");

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(NOTIFICATION_ID, builder.build());
        // END_INCLUDE(send_notification)
    }
}
