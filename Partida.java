package entities;

import java.time.LocalDateTime;

public class Partida {
    private Clube clube1;
    private Clube clube2;
    private LocalDateTime dataHora;
    private Placar resultado;

    public Partida(Clube clube1, Clube clube2, LocalDateTime dataHora) {
        this.clube1 = clube1;
        this.clube2 = clube2;
        this.dataHora = dataHora;
    }

    public void registrarResultado(int gols1, int gols2) {
        this.resultado = new Placar(gols1, gols2);
    }

    public Placar getResultado() {
        return resultado;
    }

    public Clube getClube1() {
        return clube1;
    }

    public Clube getClube2() {
        return clube2;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    // 🔥 IMPORTANTE: corrigindo uso no HashMap
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Partida)) return false;

        Partida outra = (Partida) obj;

        return clube1.getNome().equals(outra.clube1.getNome()) &&
               clube2.getNome().equals(outra.clube2.getNome()) &&
               dataHora.equals(outra.dataHora);
    }

    @Override
    public int hashCode() {
        return clube1.getNome().hashCode() +
               clube2.getNome().hashCode() +
               dataHora.hashCode();
    }
}