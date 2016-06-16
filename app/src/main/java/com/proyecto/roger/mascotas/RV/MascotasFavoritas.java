package com.proyecto.roger.mascotas.RV;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.proyecto.roger.mascotas.db.Mascota;
import com.proyecto.roger.mascotas.R;
import com.proyecto.roger.mascotas.adaptadores.PerfilAdaptador;

import java.util.ArrayList;

/**
 * Created by Joan on 02/06/2016.
 */
public class MascotasFavoritas extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_favoritas,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.miRV2);
        GridLayoutManager glm = new GridLayoutManager(getContext(),3);
        listaMascotas.setLayoutManager(glm);
        inicializarListaContactos();
        inicializarAdaptador();

        CircularImageView circularImageView = (CircularImageView)v.findViewById(R.id.imagencircular);
// Set Border
        circularImageView.setBorderColor(getResources().getColor(R.color.colorPrimary));
        circularImageView.setBorderWidth(10);
// Add Shadow with default param
        circularImageView.addShadow();
// or with custom param
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.BLACK);
        return v;
    }

    public void inicializarAdaptador(){
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("GATO1",R.drawable.gato,5));
        mascotas.add(new Mascota("GATO1",R.drawable.garf,2));
        mascotas.add(new Mascota("GATO1",R.drawable.garf2,4));
        mascotas.add(new Mascota("GATO1",R.drawable.garf3,3));
        mascotas.add(new Mascota("GATO1",R.drawable.gato,2));
        mascotas.add(new Mascota("GATO1",R.drawable.garf,4));
        mascotas.add(new Mascota("GATO1",R.drawable.garf2,5));
        mascotas.add(new Mascota("GATO1",R.drawable.garf3,2));
    }
}
