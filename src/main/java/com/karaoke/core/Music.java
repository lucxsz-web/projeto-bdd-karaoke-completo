package com.karaoke.core;

public class Music {
    private String url;
    private String usuario;
    private String titulo;

    public Music(String url, String usuario, String titulo) {
        this.url = url;
        this.usuario = usuario;
        this.titulo = titulo;
    }

    public String getUrl() { return url; }
    public String getUsuario() { return usuario; }
    public String getTitulo() { return titulo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Music)) return false;
        Music m = (Music) o;
        return url.equals(m.url) && usuario.equals(m.usuario);
    }

    @Override
    public int hashCode() {
        return url.hashCode() * 31 + usuario.hashCode();
    }
}
