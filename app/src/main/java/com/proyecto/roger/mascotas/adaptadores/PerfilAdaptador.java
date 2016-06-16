package com.proyecto.roger.mascotas.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.proyecto.roger.mascotas.db.Mascota;
import com.proyecto.roger.mascotas.R;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {
    ArrayList<Mascota> mascotas;

    public PerfilAdaptador(ArrayList<Mascota> mascotas){

        this.mascotas = mascotas;

    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.img.setImageResource(mascota.getImagen());
        //holder.txt.setText(mascota.getNombre());
        holder.txt2.setText(String.valueOf(mascota.getLikes()));
        //holder.ib.setImageResource(mascota.getBone());
        //holder.ib2.setImageResource(mascota.getBone2());

    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class PerfilViewHolder extends  RecyclerView.ViewHolder{

        private ImageView img;
        private TextView txt,txt2;
        private ImageButton ib,ib2;

        public PerfilViewHolder(View itemView){
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.fotoMascota);
            //txt = (TextView) itemView.findViewById(R.id.nombreMascota);
            txt2 = (TextView) itemView.findViewById(R.id.cuantoRating);
            ib = (ImageButton) itemView.findViewById(R.id.ratear);
            ib.setAlpha(0f);
            ib2 = (ImageButton) itemView.findViewById(R.id.rating);
        }
    }
}