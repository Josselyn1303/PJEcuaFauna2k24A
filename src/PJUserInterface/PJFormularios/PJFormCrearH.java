package PJUserInterface.PJFormularios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import PJDataAccess.PJRegionDAO;

public class PJFormCrearH extends JFrame{

    public PJFormCrearH() {
        // Configurar la ventana
        setTitle("Crear Hormiga Larva");
        setLayout(new GridLayout(5, 2, 10, 10));

        // ComboBox para País (solo Ecuador)
        JLabel lblPais = new JLabel("País:");
        JComboBox<String> cbPais = new JComboBox<>(new String[] { "ECUADOR" });
        add(lblPais);
        add(cbPais);
        
        // ComboBox para Región
        JLabel lblRegion = new JLabel("Región:");
        JComboBox<String> cbRegion = new JComboBox<>();
        add(lblRegion);
        add(cbRegion);
        
        // ComboBox para Provincia
        JLabel lblProvincia = new JLabel("Provincia:");
        JComboBox<String> cbProvincia = new JComboBox<>();
        add(lblProvincia);
        add(cbProvincia);
        
        // Botón para guardar la hormiga
        JButton btnGuardar = new JButton("Guardar Hormiga");
        add(btnGuardar);
        
        // Eventos para cargar datos de la base de datos
        // Llenar el ComboBox de regiones con datos de la base de datos
        PJRegionDAO regionDAO = new PJRegionDAO();
        try {
            List<String> regiones = regionDAO.obtenerRegiones();  // Método que extrae las regiones de la DB
            for (String region : regiones) {
                cbRegion.addItem(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Evento para cargar provincias cuando se selecciona una región
        cbRegion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbProvincia.removeAllItems();
                String regionSeleccionada = (String) cbRegion.getSelectedItem();
                
                PJProvinciaDAO provinciaDAO = new PJProvinciaDAO();
                try {
                    List<String> provincias = provinciaDAO.obtenerProvinciasPorRegion(regionSeleccionada);
                    for (String provincia : provincias) {
                        cbProvincia.addItem(provincia);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        // Evento para guardar la hormiga en la base de datos
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Guardar la hormiga en la base de datos
                String provinciaSeleccionada = (String) cbProvincia.getSelectedItem();
                guardarHormiga(provinciaSeleccionada);  // Método que debes implementar
                dispose();  // Cerrar la ventana una vez guardada
            }
        });

        // Configuraciones de la ventana
        setSize(400, 300);
        setVisible(true);
    }
    
    // Método para guardar hormiga en la base de datos (debes implementarlo)
    private void guardarHormiga(String provinciaSeleccionada) {
        // Aquí debes implementar la lógica para guardar la hormiga en la base de datos
    }
}



