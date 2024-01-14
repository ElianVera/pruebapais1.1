package com.example.paseseva;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class Paisadaptador extends ArrayAdapter<nombrepais> {

        public Paisadaptador(Context context, ArrayList<nombrepais> countryList) {
        super(context, R.layout.paisitem, countryList);
        this.countryList = countryList;
        this.context = context;

    }
    private final Context context;
    private final ArrayList<nombrepais> countryList;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.paisitem,null);

    //Variables para mostrar en el paistem.xml los nombres de los países, capitales y banderas
        TextView lblPais = (TextView)item.findViewById(R.id.nombrepais);
        lblPais.setText(getItem(position).getName());
        TextView lblcapital = (TextView)item.findViewById(R.id.nombrecapital);
        lblcapital.setText(getItem(position).getName());
        ImageView imageView = (ImageView)item.findViewById(R.id.banderaimg);
        Glide.with(this.getContext())
                .load(getItem(position).getURL()).into(imageView);

        return (item);


    }
}
