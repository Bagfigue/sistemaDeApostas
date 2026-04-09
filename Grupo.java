package entities;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nome;
    private List<Participante> participantes = new ArrayList<>();

    public Grupo(String nome) {
        this.nome = nome;
    }

    public void adicionarParticipante(Participante participante) {
        if (participantes.size() < 5) {
            participantes.add(participante);
        } else {
            System.out.println("Máximo de 5 participantes atingido.");
        }
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }
}