package com.proyecto.roger.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.proyecto.roger.mascotas.R;

import java.util.ArrayList;

/**
 * Created by Joan on 13/06/2016.
 */
public class ConstructorMascotas {
    private Context context;
    private ArrayList<Mascota> mascotas;
    public static final int LIKE = 1;
    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return db.obtenerTodasLasMascotas();

    }

    public ArrayList<Mascota> obtenerTopMascotas(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerTopMascotas();
    }

    public void insertarTresMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"ANIMALITO1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.gatete);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"ANIMALITO2");
        contentValues2.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.gatete2);
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"ANIMALITO3");
        contentValues3.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.gatete3);
        ContentValues contentValues4 = new ContentValues();
        contentValues4.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"ANIMALITO4");
        contentValues4.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.perrete);
        ContentValues contentValues5 = new ContentValues();
        contentValues5.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"ANIMALITO5");
        contentValues5.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.perrete2);
        db.insertarMascota(contentValues);
        db.insertarMascota(contentValues2);
        db.insertarMascota(contentValues3);
        db.insertarMascota(contentValues4);
        db.insertarMascota(contentValues5);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA,mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES,LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }


}
