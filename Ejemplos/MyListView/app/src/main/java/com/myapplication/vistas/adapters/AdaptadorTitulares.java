package com.myapplication.vistas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.myapplication.R;
import com.myapplication.entidades.Titular;

import org.w3c.dom.Text;

/**
 * Created by 430004587 on 25/08/2015.
 */
public class AdaptadorTitulares extends ArrayAdapter<Titular> {
  Titular[] datos;
  public AdaptadorTitulares(Context context, Titular[] datos){
    super(context, R.layout.listitem_titular,datos);
    this.datos=datos;
  }

  public View getView(int position, View convertView, ViewGroup parent){
    LayoutInflater inflater = LayoutInflater.from(getContext());
    View item = inflater.inflate(R.layout.listitem_titular, null);

    //Titulo
    TextView lblTitulo=(TextView)item.findViewById(R.id.lblTitulo);
    lblTitulo.setText(datos[position].getTitulo());

    //Subtitulo
    TextView lblSubtitulo=(TextView)item.findViewById(R.id.lblSubtitulo);
    lblSubtitulo.setText(datos[position].getSubtitulo());

    return item;
  }
}
