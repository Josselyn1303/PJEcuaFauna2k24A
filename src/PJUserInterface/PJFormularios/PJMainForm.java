package PJUserInterface.PJFormularios;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PJMainForm extends JFrame {
    private JTextField txtCedula = new JTextField("1727169631");
    private JTextField txtNombres = new JTextField("Pozo Josselyn");

    public PJMainForm(String titleApp) {
        PJcustomizeComponent(titleApp);
    }

    private void PJcustomizeComponent(String titleApp) {
        setTitle(titleApp);
        setSize(950, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Contenedor principal
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Panel izquierdo del menú
        JPanel pnlMenu = new JPanel();
        pnlMenu.setLayout(new BoxLayout(pnlMenu, BoxLayout.Y_AXIS));
        pnlMenu.setPreferredSize(new Dimension(350, getHeight()));

        // Panel principal central
        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(null);

        JLabel lblCedula = new JLabel("Cédula:");
        lblCedula.setBounds(150, 30, 100, 30);
        pnlMain.add(lblCedula);

        txtCedula.setBounds(250, 30, 150, 30);
        txtCedula.setEditable(false);  // Hacer que no sea editable
        pnlMain.add(txtCedula);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(150, 80, 100, 30);
        pnlMain.add(lblNombres);

        txtNombres.setBounds(250, 80, 150, 30);
        txtNombres.setEditable(false);  // Hacer que no sea editable
        pnlMain.add(txtNombres);

        JLabel lblHormiguero = new JLabel("Hormiguero virtual");
        lblHormiguero.setBounds(150, 150, 150, 30);
        pnlMain.add(lblHormiguero);

        JButton btnCrearHormiga = new JButton("crear hormiga larva");
        btnCrearHormiga.setBounds(600, 150, 200, 30);
        pnlMain.add(btnCrearHormiga);

        JPanel pnlGrid = new JPanel(new GridLayout(2, 5, 5, 5));
        pnlGrid.setBounds(400, 200, 400, 100);
        pnlMain.add(pnlGrid);

        for (int i = 0; i < 10; i++) {
            pnlGrid.add(new JButton());
        }

        // ComboBox y botón "alimentar con Genoalimento"
        String[] genoAlimentoOptions = {"X", "XX", "XY"};
        JComboBox<String> cboGenoAlimento = new JComboBox<>(genoAlimentoOptions);
        cboGenoAlimento.setBounds(150, 350, 200, 30);
        pnlMain.add(cboGenoAlimento);

        JButton btnGenoAlimento = new JButton("alimentar con Genoalimento");
        btnGenoAlimento.setBounds(400, 350, 200, 30);
        pnlMain.add(btnGenoAlimento);

        // ComboBox y botón "alimentar con Ingesta Nativa"
        String[] ingestaNativaOptions = {"Carnívoro", "Herbívoro", "Omnívoro", "Insectívoro"};
        JComboBox<String> cboIngestaNativa = new JComboBox<>(ingestaNativaOptions);
        cboIngestaNativa.setBounds(150, 450, 200, 30);
        pnlMain.add(cboIngestaNativa);

        JButton btnIngestaNativa = new JButton("alimentar con Ingesta Nativa");
        btnIngestaNativa.setBounds(400, 450, 200, 30);
        pnlMain.add(btnIngestaNativa);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(400, 550, 200, 30);
        pnlMain.add(btnEliminar);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 550, 200, 30);
        pnlMain.add(btnGuardar);

        container.add(pnlMain, BorderLayout.CENTER);

        setVisible(true);
    }

}