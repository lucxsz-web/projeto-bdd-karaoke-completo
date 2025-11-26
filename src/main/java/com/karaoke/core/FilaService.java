package com.karaoke.core;

import java.util.*;

public class FilaService {
    private static FilaService instance = new FilaService();
    private String sessaoId;
    private Set<String> participantes = new LinkedHashSet<>();
    private List<Music> fila = new ArrayList<>();

    private FilaService() {}

    public static FilaService getInstance() {
        return instance;
    }

    public void criarSessao(String id) {
        this.sessaoId = id;
        this.participantes.clear();
        this.fila.clear();
    }

    public boolean sessaoAtiva() {
        return this.sessaoId != null;
    }

    public void adicionarParticipante(String nome) {
        if (!sessaoAtiva()) throw new IllegalStateException("Sessão não ativa");
        participantes.add(nome);
    }

    public Music adicionarMusica(String titulo, String usuario) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da música inválido");
        }

        // evita músicas duplicadas pelo título
        for (Music m : fila) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                throw new IllegalArgumentException("Música já está na fila");
            }
        }

        Music m = new Music(titulo, usuario); 
        fila.add(m);
        return m;
    }

    public List<Music> getFila() {
        return Collections.unmodifiableList(fila);
    }
}

