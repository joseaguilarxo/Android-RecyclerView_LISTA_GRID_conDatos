package com.joseaguilar.a4_recyclerview_lista__grid_condatos.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joseaguilar.a4_recyclerview_lista__grid_condatos.Clases.Personajes;
import com.joseaguilar.a4_recyclerview_lista__grid_condatos.Controles.Utilidades;
import com.joseaguilar.a4_recyclerview_lista__grid_condatos.R;

import java.util.ArrayList;

//Paso 1: extends e importaciones de metodos
public class AdapterPersonajes extends RecyclerView.Adapter<AdapterPersonajes.ViewHolderPersonajes> {

    //Paso 2: Arraylist de la clase Personajes
    ArrayList<Personajes> listaPersonajes;

    //Paso 3: Constructor
    public AdapterPersonajes(ArrayList<Personajes> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    //Paso 4: Creamos una condicional para la seleccion de los moldes
    @Override
    public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = 0;
        if (Utilidades.visualizacion == Utilidades.LIST) {
            layout = R.layout.molde_lista_personajes;
        } else {
            layout = R.layout.molde_grid_personajes;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, null, false);
        return new ViewHolderPersonajes(view);
    }


    //Paso 7: Creamos condicional para saber que datos enviaremos dependiendo el molde
    @Override
    public void onBindViewHolder(ViewHolderPersonajes holder, int position) {

        if (Utilidades.visualizacion == Utilidades.LIST) {
            holder.txtnombre.setText(listaPersonajes.get(position).getNombre());
            holder.txtdescripcion.setText(listaPersonajes.get(position).getInfo());
            holder.foto.setImageResource(listaPersonajes.get(position).getFoto()); //se coloca SetImageResource cuando las imagenes se traen desde drawable
        }else{
            holder.txtnombre.setText(listaPersonajes.get(position).getNombre());
            holder.foto.setImageResource(listaPersonajes.get(position).getFoto());
        }
        }



    //Paso 5: realizamos el conteo de items de la lista
    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    //Paso 6: Hacemos la misma condicional para que sepamos cual elemento debera mostrar
    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {
        TextView txtnombre, txtdescripcion;
        ImageView foto;

        public ViewHolderPersonajes(View itemView) {
            super(itemView);

            if (Utilidades.visualizacion == Utilidades.LIST) {
                txtnombre = (TextView) itemView.findViewById(R.id.idNombre);
               txtdescripcion =(TextView)itemView.findViewById(R.id.idInfo);
                foto = (ImageView) itemView.findViewById(R.id.idImagen);
            }else{
                txtnombre = (TextView) itemView.findViewById(R.id.idNombre2);
                foto = (ImageView) itemView.findViewById(R.id.idImagen2);
            }

        }
    }
}
