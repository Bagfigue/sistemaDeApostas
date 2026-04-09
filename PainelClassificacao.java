package gui;

import entities.Participante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Comparator;

public class PainelClassificacao extends JPanel {

    private DefaultTableModel modelo;

    public PainelClassificacao() {

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Classificação", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new Object[]{"Nome", "Pontos"}, 0);
        JTable tabela = new JTable(modelo);

        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JButton atualizar = new JButton("Atualizar Ranking");
        add(atualizar, BorderLayout.SOUTH);

        atualizar.addActionListener(e -> atualizarRanking());
    }

    private void atualizarRanking() {

        modelo.setRowCount(0);

        for (Participante p : Sistema.grupo.getParticipantes()) {
            p.calcularPontuacaoTotal();
        }

        Sistema.grupo.getParticipantes().stream()
                .sorted(Comparator.comparing(Participante::getPontuacao).reversed())
                .forEach(p -> modelo.addRow(new Object[]{p.getNome(), p.getPontuacao()}));
    }
}