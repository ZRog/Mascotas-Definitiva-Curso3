package com.proyecto.roger.mascotas.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.proyecto.roger.mascotas.db.Mascota;
import com.proyecto.roger.mascotas.R;
import com.proyecto.roger.mascotas.db.ConstructorMascotas;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity){

        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.img.setImageResource(mascota.getImagen());
        holder.txt.setText(mascota.getNombre());
        holder.txt2.setText(String.valueOf(mascota.getLikes()));
        holder.ib.setBackgroundResource(R.mipmap.ic_bone);
        /*holder.ib2.setImageResource(mascota.getBone2());
        */

        holder.ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Diste boton like a " + mascota.getNombre() + " Con ID: "+ mascota.getId(),Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);

                holder.txt2.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends  RecyclerView.ViewHolder{

        private ImageView img;
        private TextView txt,txt2;
        private ImageButton ib,ib2;

        public MascotaViewHolder(View itemView){
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.fotoMascota);
            txt = (TextView) itemView.findViewById(R.id.nombreMascota);
            txt2 = (TextView) itemView.findViewById(R.id.cuantoRating);
            ib = (ImageButton) itemView.findViewById(R.id.ratear);
            ib2 = (ImageButton) itemView.findViewById(R.id.rating);
        }
    }
}
