package com.example.recycler_view.model;

public class Kontak {
    String _nama;
    String _noHp;
    int _foto;
    String _email;

    public Kontak(int foto, String nama, String noTlp, String email) {
        this._foto = foto;
        this._nama = nama;
        this._noHp = noTlp;
        this._email = email;
    }

    public String getNama() {
        return _nama;
    }

    public String getNoHp() {
        return _noHp;
    }

    public int getFoto() {
        return _foto;
    }

}
