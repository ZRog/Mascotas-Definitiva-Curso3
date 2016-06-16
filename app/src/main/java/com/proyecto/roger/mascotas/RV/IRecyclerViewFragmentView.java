package com.proyecto.roger.mascotas.RV;

import com.proyecto.roger.mascotas.db.Mascota;
import com.proyecto.roger.mascotas.adaptadores.MascotaAdaptador;

import java.util.ArrayList;

/**
 * Created by Joan on 13/06/2016.
 */
public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
