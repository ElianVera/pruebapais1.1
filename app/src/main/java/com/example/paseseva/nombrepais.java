package com.example.paseseva;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class nombrepais { String name; String capital; String URL;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        name = name;
    }
    public String getCapital() {
        return capital;
    }
    public String getURL() {
        return URL;
    }

    public nombrepais(String countryCode, JSONObject countryData) throws JSONException {
        name =  countryData.getString("Name");
        capital= countryData.getString("Capital");
        URL = "http://www.geognos.com/api/en/countries/flag/"+countryCode+".png";
    }

    public static ArrayList<nombrepais> JsonObjectsBuild(JSONObject datos) throws JSONException {
        ArrayList<nombrepais> lstPaises = new ArrayList<>();

        Iterator<String> keys = datos.keys();
        while (keys.hasNext()) {
            String countryCode = keys.next();
            JSONObject countryData = datos.getJSONObject(countryCode);
            lstPaises.add(new nombrepais(countryCode, countryData));
        }
        return lstPaises;
    }

}
