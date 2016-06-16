package com.proyecto.roger.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Joan on 13/06/2016.
 */
public class BaseDatos extends SQLiteOpenHelper{
    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" + ")";
        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                "(" +ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + ")" + ")";
        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascota = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImagen(registros.getInt(2));

            String queryLikes = "SELECT COUNT (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();
            Cursor registrosLikes = db.rawQuery(queryLikes,null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }
            else{
                mascotaActual.setLikes(0);
            }

            mascota.add(mascotaActual);

        }
        db.close();
        return mascota;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null,contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA,null,contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+ ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }

    public ArrayList<Mascota> obtenerTopMascotas(){
        int contador = 5;
        ArrayList<Mascota> mascota = new ArrayList<>();
        String queryTop = "SELECT "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " , COUNT (*) FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " GROUP BY " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA +
                " ORDER BY COUNT(*) DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(queryTop, null);
        while(contador != 0 && registros.moveToNext()){
            String obtener = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS +
                    " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_ID + "=" + registros.getInt(0);
            SQLiteDatabase dbb = this.getWritableDatabase();
            Cursor registross = dbb.rawQuery(obtener,null);
                registross.moveToFirst();
                Mascota mascotaActual = new Mascota();
                mascotaActual.setId(registross.getInt(0));
                mascotaActual.setNombre(registross.getString(1));
                mascotaActual.setImagen(registross.getInt(2));
            String queryLikes = "SELECT COUNT (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();
            SQLiteDatabase dbbb = this.getWritableDatabase();
            Cursor registrosLikes = dbbb.rawQuery(queryLikes,null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }
            else{
                mascotaActual.setLikes(0);
            }

            /*mascota.add(mascotaActual);
            dbb.close();*/
            dbbb.close();

                dbb.close();
                mascota.add(mascotaActual);
            contador--;
            }
        db.close();
        return mascota;
    }
}
