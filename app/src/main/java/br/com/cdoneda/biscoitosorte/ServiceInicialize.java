package br.com.cdoneda.biscoitosorte;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ServiceInicialize extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		intent = new Intent(context, BiscoitoService.class);//explicita
		context.startService(intent);
		Log.d("SERVICE_INIT","SERVICO BISCO DA SORTE INICIADO");
	}
	
}
