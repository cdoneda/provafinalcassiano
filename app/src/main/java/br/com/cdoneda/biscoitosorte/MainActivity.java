package br.com.cdoneda.biscoitosorte;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ServiceInicialize mService;
    private IntentFilter mIntentFilter;
    private Mensagem m;
    TextView ta;
    TextView tm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context contexto = getApplicationContext();
        Intent objIntent = new Intent(contexto, BiscoitoService.class);
        startService(objIntent);


        ta = (TextView) findViewById(R.id.tautor);
        tm = (TextView) findViewById(R.id.tmensagem);


        m = new Mensagem();

        try {

            m.setAutor(getIntent().getExtras().getString("autor"));
            m.setMensagem(getIntent().getExtras().getString("msg"));
            Log.d("AUTOR MAIN", m.getAutor());
            Log.d("MSG MAIN", m.getMensagem());

        } catch (Exception e) {
            e.printStackTrace();
        }
        vaiWebService();
        ta.setText(m.getAutor());
        tm.setText(m.getMensagem());
    }

    private void vaiWebService() {

        String url = "http://biscoito.herokuapp.com";
        new ListService().execute(url);
    }

    private class ListService extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                return WebServiceUtil.getContentAsString(urls[0]);
            } catch (IOException e) {
                Log.e("Exception", e.toString());//Observe que aqui uso o log.e e não log.d
                return "Problema ao montar a requisição";
            }
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Gson parser = new Gson();
            Mensagem msg;

            msg = parser.fromJson(result,
                    new TypeToken<Mensagem>() {
                    }.getType());

            if (msg.getAutor() != null) {
                m.setMensagem(msg.getMensagem());
                m.setAutor(msg.getAutor());
                ta.setText(m.getAutor());
                tm.setText(m.getMensagem());
            } else {
                m.setAutor("Hoje você está sem sorte.");
                m.setMensagem("");
                Log.d("AUTOR", "NULL");
                ta.setText(m.getAutor());
                tm.setText(m.getMensagem());
            }


        }

    }


    public void initService(View v) {

        Context contexto = getApplicationContext();
        Intent objIntent = new Intent(contexto, BiscoitoService.class);
        startService(objIntent);

    }

}
