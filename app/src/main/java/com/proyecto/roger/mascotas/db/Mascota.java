package com.proyecto.roger.mascotas.db;

public class Mascota {

    private int id;
    private int imagen;
    private String nombre;
    private int likes = 0;

    public Mascota(){

    }

    public Mascota(String nombre, int imagen,int likes){
        this.imagen = imagen;
        this.nombre = nombre;
        this.likes = likes;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
