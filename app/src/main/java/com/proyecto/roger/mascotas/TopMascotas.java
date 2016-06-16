package com.proyecto.roger.mascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.proyecto.roger.mascotas.RV.IRecyclerViewFragmentView;
import com.proyecto.roger.mascotas.RV.RecyclerViewFragmentPresenter;
import com.proyecto.roger.mascotas.adaptadores.MascotaAdaptador;
import com.proyecto.roger.mascotas.adaptadores.PerfilAdaptador;
import com.proyecto.roger.mascotas.db.Mascota;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TopMascotas extends AppCompatActivity implements IRecyclerViewFragmentView{

    RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    RecyclerViewFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topmascotas);

        Toolbar segundaToolBar = (Toolbar) findViewById(R.id.miToolbar);
        segundaToolBar.setTitle("Top Mascotas");
        setSupportActionBar(segundaToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.miRV3);

        presenter = new RecyclerViewFragmentPresenter(this,getBaseContext(),5);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        return adaptador;

    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
