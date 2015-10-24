package com.myapplication.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.myapplication.R;
import com.myapplication.entidades.Titular;
import com.myapplication.vistas.adapters.AdaptadorTitulares;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
  private final String[] datos =
          new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
  private Titular[] datosTitulo =
          new Titular[]{
                  new Titular("Título 1", "Subtítulo largo 1"),
                  new Titular("Título 2", "Subtítulo largo 2"),
                  new Titular("Título 3", "Subtítulo largo 3"),
                  new Titular("Título 4", "Subtítulo largo 4"),
                  new Titular("Título 4", "Subtítulo largo 5"),
                  new Titular("Título 4", "Subtítulo largo 6"),
                  new Titular("Título 4", "Subtítulo largo 7"),
                  new Titular("Título 4", "Subtítulo largo 8"),
                  new Titular("Título 4", "Subtítulo largo 9"),
                  new Titular("Título 4", "Subtítulo largo 10")};




  private Spinner lista;
  private TextView mensaje;
  private TextView lblElemento;
  private ListView lstOpciones;
  private ArrayAdapter<String> adaptador;
  private ArrayAdapter<String> adaptadorOpciones;
  private AdaptadorTitulares adaptadorTitulares;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    lista=(Spinner)findViewById(R.id.spnDatos);
    mensaje=(TextView)findViewById(R.id.tvwMensaje);
    lstOpciones=(ListView)findViewById(R.id.lstOpciones);
    lblElemento=(TextView)findViewById(R.id.lblElemento);

    //Adaptador - Spinner
    adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
    adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
    //Adaptador - Listview
    adaptadorOpciones=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
    //Adaptador - Titulares
    adaptadorTitulares=new AdaptadorTitulares(this, datosTitulo);

    //Implementar adaptador
    lista.setAdapter(adaptador);
    //lstOpciones.setAdapter(adaptadorOpciones);
    lstOpciones.setAdapter(adaptadorTitulares);

    //Cabecera
    View header=getLayoutInflater().inflate(R.layout.list_header,null);
    lstOpciones.addHeaderView(header);


    //Eventos de lista
    lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mensaje.setText("Seleccionado : "+parent.getItemAtPosition(position));
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {
        mensaje.setText("");
      }
    });
    //Eventos de listview
    lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Opcion 1
        String opcionSeleccionada=((Titular)parent.getItemAtPosition(position)).getTitulo();

        //Opcion 2
        //String opcionSeleccionada=((TextView)view.findViewById(R.id.lblTitulo)).getText().toString();

        lblElemento.setText("Opcion seleccionada: "+opcionSeleccionada);
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
