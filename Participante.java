package entities;

import java.util.HashMap;
import java.util.Map;

public class Participante {

    private String nome;
    private Map<Partida, Placar> apostas = new HashMap<>();
    private int pontuacao;

    public Participante(String nome) {
        this.nome = nome;
    }

    public void registrarAposta(Partida partida, Placar placar) {
        apostas.put(partida, placar);
    }

    public void calcularPontuacaoTotal() {
        pontuacao = 0; // evita duplicação

        for (Map.Entry<Partida, Placar> entry : apostas.entrySet()) {
            Partida partida = entry.getKey();
            Placar previsto = entry.getValue();

            if (partida.getResultado() != null) {
                Placar resultado = partida.getResultado();

                if (previsto.getGolsClube1() == resultado.getGolsClube1() &&
                    previsto.getGolsClube2() == resultado.getGolsClube2()) {
                    pontuacao += 10;
                }
                else if ((resultado.getGolsClube1() > resultado.getGolsClube2() &&
                          previsto.getGolsClube1() > previsto.getGolsClube2()) ||

                         (resultado.getGolsClube1() < resultado.getGolsClube2() &&
                          previsto.getGolsClube1() < previsto.getGolsClube2()) ||

                         (resultado.getGolsClube1() == resultado.getGolsClube2() &&
                          previsto.getGolsClube1() == previsto.getGolsClube2())) {
                    pontuacao += 5;
                }
            }
        }
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public String getNome() {
        return nome;
    }
}