package gui;

import javax.swing.*;
import java.awt.*;

public class PainelResultados extends JPanel {

    public PainelResultados() {

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Resultado", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        JPanel form = new JPanel();

        JTextField g1 = new JTextField(3);
        JTextField g2 = new JTextField(3);

        JButton salvar = new JButton("Salvar Resultado");

        form.add(new JLabel("Placar:"));
        form.add(g1);
        form.add(new JLabel("x"));
        form.add(g2);
        form.add(salvar);

        add(form, BorderLayout.CENTER);

        salvar.addActionListener(e -> {
            try {
                int placar1 = Integer.parseInt(g1.getText());
                int placar2 = Integer.parseInt(g2.getText());

                Sistema.partida.registrarResultado(placar1, placar2);

                JOptionPane.showMessageDialog(this, "Resultado salvo!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro!");
            }
        });
    }
}