package gui;

import entities.Participante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PainelParticipantes extends JPanel {

    private DefaultTableModel modelo;

    public PainelParticipantes() {

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Participantes", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new Object[]{"Nome"}, 0);
        JTable tabela = new JTable(modelo);

        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel form = new JPanel();
        JTextField nome = new JTextField(15);
        JButton add = new JButton("Adicionar");

        form.add(nome);
        form.add(add);

        add(form, BorderLayout.SOUTH);

        add.addActionListener(e -> {
            if (!nome.getText().isEmpty()) {

                Participante p = new Participante(nome.getText());
                Sistema.grupo.adicionarParticipante(p);

                modelo.addRow(new Object[]{p.getNome()});
                nome.setText("");
            }
        });
    }
}