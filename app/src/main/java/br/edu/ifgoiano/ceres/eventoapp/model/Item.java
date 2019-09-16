package br.edu.ifgoiano.ceres.eventoapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
    private String titulo;
    private String tipo;
    private String local;
    private String periodo;

    public Item() {
    }

    public Item(String titulo, String tipo, String periodo) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.periodo = periodo;
    }

    public Item(String titulo, String tipo, String local, String periodo) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.local = local;
        this.periodo = periodo;
    }

    protected Item(Parcel in) {
        titulo = in.readString();
        tipo = in.readString();
        local = in.readString();
        periodo = in.readString();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
