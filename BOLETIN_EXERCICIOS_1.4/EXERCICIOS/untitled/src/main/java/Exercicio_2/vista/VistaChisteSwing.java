package Exercicio_2.vista;

import javax.swing.*;
import java.awt.*;

public class VistaChisteSwing extends JFrame implements VistaChiste{

    private final JTextArea txtChiste;
    private final JButton btnConsulta;

    private IControladorChiste controlador;

    public VistaChisteSwing(IControladorChiste controlador) throws HeadlessException {
        this.controlador = controlador;

        btnConsulta = new JButton("Consultar chiste");
        txtChiste = new JTextArea();

        JPanel panelSuperior = new JPanel();
        panelSuperior.add(btnConsulta);
        add(panelSuperior, BorderLayout.CENTER);
        add(txtChiste);

        btnConsulta.addActionListener(t -> {
                    txtChiste.setText(controlador.getRandomJoke());
                });

        setLocationRelativeTo(null);
        setSize(400, 400);
        setVisible(true);


    }

    @Override
    public void setChiste(String chiste) {

        txtChiste.setText(chiste);

    }

    public void setController ();



}
