package com.karaoke.core;

public class Music {
    private String titulo;  
    private String usuario;

    public Music(String titulo, String usuario) {
        this.titulo = titulo;
        this.usuario = usuario;
    }

    public String getTitulo() { 
        return titulo; 
    }

    public String getUsuario() { 
        return usuario; 
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Music)) return false;
        Music m = (Music) o;
        return titulo.equals(m.titulo) && usuario.equals(m.usuario);
    }

    @Override
    public int hashCode() {
        return titulo.hashCode() * 31 + usuario.hashCode();
    }
}

