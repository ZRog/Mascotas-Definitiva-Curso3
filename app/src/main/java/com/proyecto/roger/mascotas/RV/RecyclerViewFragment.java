package com.proyecto.roger.mascotas.RV;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proyecto.roger.mascotas.db.Mascota;
import com.proyecto.roger.mascotas.R;
import com.proyecto.roger.mascotas.adaptadores.MascotaAdaptador;

import java.util.ArrayList;

/**
 * Created by Joan on 02/06/2016.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.miRV);

        presenter = new RecyclerViewFragmentPresenter(this,getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;

    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
