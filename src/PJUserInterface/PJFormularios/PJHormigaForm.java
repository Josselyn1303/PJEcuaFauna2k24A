package PJUserInterface.PJFormularios;
/*package PJUserInterface.Formularios;

import PJBusinessLogic.PJHormigaBL;
import PJDataAccess.PJDTO.PJHormigaDTO;
        
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PJHormigaForm extends JDialog {
            private JTextField txtTipoHormiga;
            private JTextField txtIdSexo;
            private JTextField txtIdProvincia;
            private JTextField txtIdGenoAlimento;
            private JTextField txtIdIngestaNativa;
            private JButton btnAddHormiga;
            private PJHormigaBL controller;
            private PJMainForm mainForm;
        
            public PJHormigaForm(Frame parent, PJHormigaBL controller) {
                super(parent, "Agregar Hormiga", true);
                this.controller = controller;
                this.mainForm = mainForm;
                initialize();
            }
        
            private void initialize() {
                setSize(400, 300);
                setLayout(new GridLayout(6, 2, 10, 10));
        
                add(new JLabel("Tipo Hormiga:"));
                txtTipoHormiga = new JTextField();
                add(txtTipoHormiga);
        
                add(new JLabel("ID Sexo:"));
                txtIdSexo = new JTextField();
                add(txtIdSexo);
        
                add(new JLabel("ID Provincia:"));
                txtIdProvincia = new JTextField();
                add(txtIdProvincia);
        
                add(new JLabel("ID GenoAlimento:"));
                txtIdGenoAlimento = new JTextField();
                add(txtIdGenoAlimento);
        
                add(new JLabel("ID Ingesta Nativa:"));
                txtIdIngestaNativa = new JTextField();
                add(txtIdIngestaNativa);
        
                btnAddHormiga = new JButton("Agregar Hormiga");
                add(btnAddHormiga);
        
                btnAddHormiga.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addHormiga();
                    }
                });
        
                setLocationRelativeTo(getParent());
            }
        
            private void addHormiga() {
                try {
                    PJHormigaDTO hormiga = new PJHormigaDTO();
                    hormiga.setTipoHormiga(txtTipoHormiga.getText());
                    hormiga.setIdSexo(Integer.parseInt(txtIdSexo.getText()));
                    hormiga.setIdProvincia(Integer.parseInt(txtIdProvincia.getText()));
                    hormiga.setIdGenoAlimento(Integer.parseInt(txtIdGenoAlimento.getText()));
                    hormiga.setIdIngestaNativa(Integer.parseInt(txtIdIngestaNativa.getText()));
                    controller.addHormiga(hormiga);
                    JOptionPane.showMessageDialog(this, "Hormiga agregada exitosamente!");
                    mainForm.updateHormigaList();
                    dispose();  // Cierra el diálogo
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al agregar Hormiga: " + e.getMessage());
                }
            }
        }
           
*/