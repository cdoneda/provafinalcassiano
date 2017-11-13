package br.com.cdoneda.biscoitosorte;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  ServiceInicialize mService;
    private IntentFilter mIntentFilter;
    private Mensagem m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ta = (TextView) findViewById(R.id.tautor);
        TextView tm = (TextView) findViewById(R.id.tmensagem);



        m = new Mensagem();
        Bundle b = new Bundle();
        try {

            m.setAutor(b.getString("autor"));
            m.setMensagem(b.getString("msg"));
            Log.d("AUTOR", m.getAutor());

        } catch (Exception e) {
            e.printStackTrace();
        }

        ta.setText(m.getAutor());
        ta.setText(m.getMensagem());
    }

    public void Testa(View v) {

        Context contexto = getApplicationContext();
        Intent objIntent = new Intent(contexto, BiscoitoService.class);
        startService(objIntent);

    }
}
