import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class telarevista implements telainter {
    public ArrayList<geral> listaGeral = new ArrayList<>();
    private JFrame frame;
    private JTextField titulo;
    private JTextField autor;
    private JTextField ano;
    private JTextField org;
    private JTextField vol;
    private JTextField nro;

    public void incluirRevista(String a, String b, int c, int d, int e) {
        geral revista = new revistas(a, b, c, d, e);
        listaGeral.add(revista);
        gravarNoArquivo(revista.toString());
    }
    private void gravarNoArquivo(String conteudo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("conteudo.txt", true))) {
            writer.write(conteudo);
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void iniciar() {
        frame = new JFrame();
        telalivro tl = new telalivro();
        telavideo tv = new telavideo();
        JPanel inputPanel = new JPanel(new GridLayout(0, 2)); // Layout para organizar os componentes verticalmente

        JLabel titulo2Label = new JLabel("REVISTAS");
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(titulo2Label);

        JLabel tituloLabel = new JLabel("Título:");
        inputPanel.add(tituloLabel);
        titulo = new JTextField();
        inputPanel.add(titulo);
        titulo.setColumns(10);

        JLabel OrgLabel = new JLabel("Org:");
        inputPanel.add(OrgLabel);
        org = new JTextField();
        inputPanel.add(org);
        org.setColumns(10);

        JLabel VolLabel = new JLabel("Vol:");
        inputPanel.add(VolLabel);
        vol = new JTextField();
        inputPanel.add(vol);
        vol.setColumns(10);

        JLabel NroLabel = new JLabel("Nro:");
        inputPanel.add(NroLabel);
        nro = new JTextField();
        inputPanel.add(nro);
        nro.setColumns(10);

        JLabel anoLabel = new JLabel("Ano:");
        inputPanel.add(anoLabel);
        ano = new JTextField();
        inputPanel.add(ano);
        ano.setColumns(10);

        JButton incluirButton = new JButton("Incluir");
        incluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                incluirRevista(titulo.getText(), org.getText(), Integer.parseInt(vol.getText()),
                        Integer.parseInt(nro.getText()), Integer.parseInt(ano.getText()));
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
                    if (item instanceof revistas) {
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
        JButton videoButton = new JButton("Revistas");
        videoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tv.iniciar();
            }
        });


        inputPanel.add(incluirButton);
        inputPanel.add(listagemButton);
        inputPanel.add(livroButton);
        inputPanel.add(videoButton);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void imprimirLista() {
        System.out.println("Conteúdo da Lista:");
        for (geral item : listaGeral) {
            System.out.println(item);
        }
    }
}
