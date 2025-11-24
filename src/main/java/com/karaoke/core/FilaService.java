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

    public Music adicionarMusica(String url, String usuario) {
        if (url == null || !isValidYoutubeUrl(url)) {
            throw new IllegalArgumentException("Link inválido");
        }
        // Prevent duplication of same video url
        for (Music m : fila) {
            if (m.getUrl().equals(url)) {
                throw new IllegalArgumentException("Música já está na fila");
            }
        }
        Music m = new Music(url, usuario, "Título mock");
        fila.add(m);
        return m;
    }

    private boolean isValidYoutubeUrl(String url) {
        if (url == null) return false;
        return url.contains("youtube.com/watch?v=") || url.contains("youtu.be/");
    }

    public List<Music> getFila() {
        return Collections.unmodifiableList(fila);
    }
}
