import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class telavideo implements telainter {
    public ArrayList<geral> listaGeral = new ArrayList<>();
    private JFrame frame;
    private JTextField titulo;
    private JTextField autor;
    private JTextField ano;
    private JTextField duracao;

    private void gravarNoArquivo(String conteudo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("conteudo.txt", true))) {
            writer.write(conteudo);
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void incluir(String a, int b, String c, String d) {
        geral revista = new video(a, b, c, d);
        listaGeral.add(revista);
        gravarNoArquivo(revista.toString());
    }

    public void iniciar() {
        frame = new JFrame();
        telarevista tr = new telarevista();
        JPanel inputPanel = new JPanel(new GridLayout(0, 2)); // Layout para organizar os componentes verticalmente
        telalivro tl = new telalivro();
        JLabel titulo2Label = new JLabel("VIDEOS");
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(titulo2Label);

        JLabel tituloLabel = new JLabel("Título:");
        inputPanel.add(tituloLabel);
        titulo = new JTextField();
        inputPanel.add(titulo);
        titulo.setColumns(10);

        JLabel OrgLabel = new JLabel("Autor:");
        inputPanel.add(OrgLabel);
        autor = new JTextField();
        inputPanel.add(autor);
        autor.setColumns(10);

        JLabel VolLabel = new JLabel("Ano:");
        inputPanel.add(VolLabel);
        ano = new JTextField();
        inputPanel.add(ano);
        ano.setColumns(10);

        JLabel NroLabel = new JLabel("Duracao:");
        inputPanel.add(NroLabel);
        duracao = new JTextField();
        inputPanel.add(duracao);
        duracao.setColumns(10);


        JButton incluirButton = new JButton("Incluir");
        incluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                incluir(titulo.getText(), Integer.parseInt(ano.getText()), autor.getText(),
                        duracao.getText());
            }
        });
        JButton listagemButton = new JButton("Listagem");
        listagemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame listagemFrame = new JFrame("Listagem de Revistas");
                JLabel titulo1Label = new JLabel("LISTAGEM");
                inputPanel.add(Box.createVerticalStrut(10));

                JTextArea listagemTextArea = new JTextArea();
                JScrollPane scrollPane = new JScrollPane(listagemTextArea);
                listagemFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

                for (geral item : listaGeral) {
                    if (item instanceof video) {
                        listagemTextArea.append(item.toString() + "\n");
                    }
                }

                listagemFrame.setSize(400, 300);
                listagemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                listagemFrame.setVisible(true);
            }
        });
        JButton livroButton = new JButton("Livros");
        livroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tl.iniciar();
            }
        });
        JButton revistaButton = new JButton("Revistas");
        revistaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tr.iniciar();
            }
        });
        inputPanel.add(incluirButton);
        inputPanel.add(listagemButton);
        inputPanel.add(livroButton);
        inputPanel.add(revistaButton);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
