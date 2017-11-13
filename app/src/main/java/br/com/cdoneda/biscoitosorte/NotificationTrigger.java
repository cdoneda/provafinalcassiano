package br.com.cdoneda.biscoitosorte;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class NotificationTrigger extends BroadcastReceiver {

    private String autor;
    private String message;

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager mNotifyMgr = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

        Bundle bundle = intent.getExtras();
        try {

            this.autor = bundle.getString("autor");
            this.message = bundle.getString("msg");


        } catch (Exception e) {
            e.printStackTrace();
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                context).setSmallIcon(R.drawable.ic_info)
                .setContentTitle(autor)
                .setContentText(message);


        Bundle bundle2 = new Bundle();
        bundle2.putString("autor", autor);
        bundle2.putString("msg", message);
        Intent resultIntent= new Intent(context, MainActivity.class);
        resultIntent.putExtras(bundle2);


        PendingIntent resultPendingIntent = PendingIntent.getActivity(
                context,
                0,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        mBuilder.setContentIntent(resultPendingIntent);// Seta a intent que vai
        // abrir

        Notification n = mBuilder.build();
        n.vibrate = new long[]{150, 300, 150, 600, 10, 600};//Vibrar
        n.flags = Notification.FLAG_AUTO_CANCEL;

        mNotifyMgr.notify(1, n);


        Uri som = Uri.parse("android.resource://br.com.cdoneda.biscoitosorte/" + R.raw.msg);
        Ringtone toque = RingtoneManager.getRingtone(context, som);
        toque.play();


    }


}
