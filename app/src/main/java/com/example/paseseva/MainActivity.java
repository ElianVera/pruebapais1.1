package com.example.paseseva;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.paseseva.WebServices.Asynchtask;
import com.example.paseseva.WebServices.WebService;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.WebService;


public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("http://www.geognos.com/api/en/countries/info/all.json",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {

        ArrayList<nombrepais>  nombrepais = new ArrayList<nombrepais>();
        JSONObject lista = new JSONObject(result);
        JSONObject JSONlista = lista.getJSONObject("Results");

        nombrepais = nombrepais.JsonObjectsBuild(JSONlista);

        Paisadaptador Paisadaptador
                = new Paisadaptador(this,nombrepais );
        ListView lstOpciones = (ListView) findViewById(R.id.listViewCountries);
        lstOpciones.setAdapter(Paisadaptador);
    }
}
