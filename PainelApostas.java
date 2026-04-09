package gui;

import entities.*;

import javax.swing.*;
import java.awt.*;

public class PainelApostas extends JPanel {

    private JComboBox<String> combo;

    public PainelApostas() {

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Apostas", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        JPanel form = new JPanel();

        combo = new JComboBox<>();

        JTextField g1 = new JTextField(3);
        JTextField g2 = new JTextField(3);

        JButton apostar = new JButton("Registrar");

        form.add(new JLabel("Participante:"));
        form.add(combo);
        form.add(new JLabel("Placar:"));
        form.add(g1);
        form.add(new JLabel("x"));
        form.add(g2);
        form.add(apostar);

        add(form, BorderLayout.CENTER);

        // 🔥 Atualiza lista automaticamente
        atualizarCombo();

        apostar.addActionListener(e -> {
            try {
                int index = combo.getSelectedIndex();

                Participante p = Sistema.grupo.getParticipantes().get(index);

                int placar1 = Integer.parseInt(g1.getText());
                int placar2 = Integer.parseInt(g2.getText());

                p.registrarAposta(Sistema.partida, new Placar(placar1, placar2));

                JOptionPane.showMessageDialog(this, "Aposta registrada!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro!");
            }
        });
    }

    public void atualizarCombo() {
        combo.removeAllItems();

        for (Participante p : Sistema.grupo.getParticipantes()) {
            combo.addItem(p.getNome());
        }
    }
}