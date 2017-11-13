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
		// Gets an instance of the NotificationManager service
				NotificationManager mNotifyMgr = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

				Intent resultIntent = new Intent(context, MainActivity.class);

				PendingIntent resultPendingIntent = PendingIntent.getActivity( // atividade
						context, // Contexto que vem do receive "MUITO IMPORTANTE"
						0, // Parametro não usado
						resultIntent, // Intent que lancará
						PendingIntent.FLAG_UPDATE_CURRENT
						);
		Bundle bundle = intent.getExtras();
		try {
			//receiveNumbers = intent.getExtras().get("phN").toString();
			//this.title = intent.getStringExtra("tit");
			//this.message = intent.getStringExtra("msg");
			this.autor = bundle.getString("autor");
			this.message = bundle.getString("msg");


		} catch (Exception e) {
			e.printStackTrace();
		}
				NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
						context).setSmallIcon(R.drawable.ic_info)
						// TODO passar por bundle
						.setContentTitle(autor)
						.setContentText(message);

				mBuilder.setContentIntent(resultPendingIntent);// Seta a intent que vai
																// abrir

				Notification n = mBuilder.build();
				n.vibrate = new long[] { 150, 300, 150, 600, 10, 600 };//Vibrar
				n.flags = Notification.FLAG_AUTO_CANCEL;

				mNotifyMgr.notify(1, n);
				
				
				Uri som = Uri.parse("android.resource://br.com.cdoneda.biscoitosorte/" + R.raw.msg);
				Ringtone toque = RingtoneManager.getRingtone(context, som);
				toque.play();
			

	}
	


}
