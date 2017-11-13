package br.com.cdoneda.biscoitosorte;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private  ServiceInicialize mService;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Testa(View v) {

        Context contexto = getApplicationContext();
        Intent objIntent = new Intent(contexto, RecadosService.class);
        //objIntent.putExtras(bundle);
//        contexto.sendBroadcast(objIntent);

        startService(objIntent);

    }

    public void InitService(View v) {


        mService = new ServiceInicialize();
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("android.intent.category.DEFAULT");
        registerReceiver(mService, mIntentFilter);



    }
}
