import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class telalivro implements telainter {
    public ArrayList<geral> listaGeral = new ArrayList<>();
    private JFrame frame;
    private JTextField titulo;
    private JTextField autor;
    private JTextField ano;
    private JTextField org;
    private JTextField vol;
    private JTextField nro;
    public void incluirLivro(String a, String b, int c) {
        geral livro = new livro(a, b, c);
        listaGeral.add(livro);
        System.out.println("Livro incluído: " + livro);
    }

    public void iniciar() {
        frame = new JFrame();
        telarevista tr = new telarevista();
        telavideo tv = new telavideo();
        JPanel inputPanel = new JPanel(new GridLayout(0, 2)); // Layout para organizar os componentes verticalmente

        JLabel titulo1Label = new JLabel("LIVROS");
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(titulo1Label);
        JLabel tituloLabel = new JLabel("Título:");
        inputPanel.add(tituloLabel);
        titulo = new JTextField();
        inputPanel.add(titulo);
        titulo.setColumns(10);

        JLabel autorLabel = new JLabel("Autor:");
        inputPanel.add(autorLabel);
        autor = new JTextField();
        inputPanel.add(autor);
        autor.setColumns(10);

        JLabel anoLabel = new JLabel("Ano:");
        inputPanel.add(anoLabel);
        ano = new JTextField();
        inputPanel.add(ano);
        ano.setColumns(10);

        JButton incluirButton = new JButton("Incluir");
        incluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                incluirLivro(titulo.getText(), autor.getText(), Integer.parseInt(ano.getText()));
            }
        });

        JButton listagemButton = new JButton("Listagem");
        listagemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame listagemFrame = new JFrame("Listagem de Livros");
                JLabel titulo1Label = new JLabel("LISTAGEM");
                inputPanel.add(Box.createVerticalStrut(10));

                JTextArea listagemTextArea = new JTextArea();
                JScrollPane scrollPane = new JScrollPane(listagemTextArea);
                listagemFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

                for (geral item : listaGeral) {
                    if (item instanceof livro) {
                        listagemTextArea.append(item.toString() + "\n");
                    }
                }

                listagemFrame.setSize(400, 300);
                listagemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                listagemFrame.setVisible(true);
            }
        });

        JButton revistaButton = new JButton("Revistas");
        revistaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tr.iniciar();
            }
        });
        JButton videoButton = new JButton("Videos");
        videoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tv.iniciar();
            }
        });

        inputPanel.add(incluirButton);
        inputPanel.add(listagemButton);
        inputPanel.add(revistaButton);
        inputPanel.add(videoButton);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

