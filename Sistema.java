package gui;

import entities.*;
import java.time.LocalDateTime;

public class Sistema {

    public static Grupo grupo;
    public static Partida partida;

    static {
        Clube c1 = new Clube("Time A");
        Clube c2 = new Clube("Time B");

        grupo = new Grupo("Grupo 1");
        partida = new Partida(c1, c2, LocalDateTime.now());
    }
}