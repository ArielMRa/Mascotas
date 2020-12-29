package com.aricode.integrandomaterialdesign;

public class Mascota {

    private String nombre;
    private int foto;
    private int raiting;

    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
        this.raiting = 0;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}
