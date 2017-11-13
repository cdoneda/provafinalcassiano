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
        Intent objIntent = new Intent(contexto, BiscoitoService.class);
        startService(objIntent);

    }
}
