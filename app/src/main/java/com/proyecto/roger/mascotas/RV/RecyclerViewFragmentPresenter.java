package com.proyecto.roger.mascotas.RV;

import android.content.Context;

import com.proyecto.roger.mascotas.db.Mascota;
import com.proyecto.roger.mascotas.db.ConstructorMascotas;

import java.util.ArrayList;

/**
 * Created by Joan on 13/06/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas,topMascotas;
    private int numTop;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context, int numTop){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        this.numTop = numTop;
        obtenerTopMascotas();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    public void obtenerTopMascotas(){
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerTopMascotas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }


}
