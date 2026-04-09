package entities;

public class Placar {
    private int golsClube1;
    private int golsClube2;

    public Placar(int golsClube1, int golsClube2) {
        this.golsClube1 = golsClube1;
        this.golsClube2 = golsClube2;
    }

    public int getGolsClube1() {
        return golsClube1;
    }

    public int getGolsClube2() {
        return golsClube2;
    }
}