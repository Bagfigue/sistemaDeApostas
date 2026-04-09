package gui;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private CardLayout layout;
    private JPanel painelCentral;
    private PainelApostas painelApostas;

    public TelaPrincipal() {

        setTitle("Sistema de Apostas");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 🔹 MENU LATERAL
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(6, 1));
        menu.setBackground(new Color(20, 30, 50));

        JButton btn1 = criarBotao("Participantes");
        JButton btn2 = criarBotao("Apostas");
        JButton btn3 = criarBotao("Resultados");
        JButton btn4 = criarBotao("Classificação");

        menu.add(btn1);
        menu.add(btn2);
        menu.add(btn3);
        menu.add(btn4);

        add(menu, BorderLayout.WEST);

        // 🔹 ÁREA CENTRAL
        layout = new CardLayout();
        painelCentral = new JPanel(layout);

        painelCentral.add(new PainelParticipantes(), "p1");
        painelApostas = new PainelApostas();
        painelCentral.add(painelApostas, "p2");
        painelCentral.add(new PainelResultados(), "p3");
        painelCentral.add(new PainelClassificacao(), "p4");

        add(painelCentral, BorderLayout.CENTER);

        // 🔹 EVENTOS
        btn1.addActionListener(e -> layout.show(painelCentral, "p1"));
        btn2.addActionListener(e -> {
            painelApostas.atualizarCombo(); 
            layout.show(painelCentral, "p2");
        });
        btn3.addActionListener(e -> layout.show(painelCentral, "p3"));
        btn4.addActionListener(e -> layout.show(painelCentral, "p4"));
    }

    private JButton criarBotao(String texto) {
        JButton btn = new JButton(texto);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(40, 60, 90));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        return btn;
    }
}