package application;


import java.time.LocalDateTime;
import entities.*;
import gui.TelaPrincipal;

public class GerenciadorApostas {

    public static void main(String[] args) {

        Clube c1 = new Clube("Time A");
        Clube c2 = new Clube("Time B");

        Campeonato campeonato = new Campeonato("Campeonato");
        campeonato.adicionarClube(c1);
        campeonato.adicionarClube(c2);

        Partida partida = new Partida(c1, c2, LocalDateTime.now());
        campeonato.registrarPartida(partida);

        Grupo grupo = new Grupo("Grupo 1");

        Participante p1 = new Participante("João");
        Participante p2 = new Participante("Maria");

        grupo.adicionarParticipante(p1);
        grupo.adicionarParticipante(p2);

        p1.registrarAposta(partida, new Placar(2, 1));
        p2.registrarAposta(partida, new Placar(1, 1));

        partida.registrarResultado(2, 1);

        for (Participante p : grupo.getParticipantes()) {
            p.calcularPontuacaoTotal();
            System.out.println(p.getNome() + " - Pontos: " + p.getPontuacao());
        }
        
        new TelaPrincipal().setVisible(true);
    }
}