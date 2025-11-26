package com.karaoke.bdd;

import com.karaoke.core.FilaService;
import com.karaoke.core.Music;
import io.cucumber.java.pt.*;
import static org.junit.Assert.*;

public class AdicionarMusicaSteps {

    private FilaService filaService = FilaService.getInstance();
    private Music resultado;
    private String nomeInserido;   
    private String mensagemErro;

    @Dado("que existe uma sessão ativa com ID {string}")
    public void existeSessao(String id) {
        filaService.criarSessao(id);
    }

    @Dado("que o participante {string} está conectado à sessão")
    public void participanteConectado(String nome) {
        filaService.adicionarParticipante(nome);
    }

    @Dado("que estou na tela da sessão")
    public void estouNaTela() {
        assertTrue(filaService.sessaoAtiva());
    }

    @Quando("insiro o nome {string}")
    public void insiroONome(String nomeMusica) {
        this.nomeInserido = nomeMusica;  
    }

    @Quando("clico em {string}")
    public void clicoEm(String botao) {
        try {
            resultado = filaService.adicionarMusica(nomeInserido, "Lucas");               
            mensagemErro = null;
        } catch (IllegalArgumentException ex) {
            resultado = null;
            mensagemErro = ex.getMessage();
        }
    }

    @Entao("a música deve aparecer na fila")
    public void musicaDeveAparecer() {
        assertNotNull("Resultado deve ser diferente de null", resultado);
        assertTrue(filaService.getFila().contains(resultado));
    }

    @Entao("deve estar associada ao usuário {string}")
    public void associadaAoUsuario(String usuario) {
        assertEquals(usuario, resultado.getUsuario());
    }

    @Entao("o sistema deve exibir a mensagem de erro {string}")
    public void sistemaExibeMensagem(String expected) {
        assertEquals(expected, mensagemErro);
    }
}

