package entities;

import java.util.ArrayList;
import java.util.List;

public class Campeonato {

    private String nome;
    private List<Clube> clubes = new ArrayList<>();
    private List<Partida> partidas = new ArrayList<>();

    public Campeonato(String nome) {
        this.nome = nome;
    }

    public void adicionarClube(Clube clube) {
        if (clubes.size() < 8) {
            clubes.add(clube);
        } else {
            System.out.println("Máximo de 8 clubes atingido.");
        }
    }

    public void registrarPartida(Partida partida) {
        partidas.add(partida);
    }

    public List<Partida> getPartidas() {
        return partidas;
    }
}