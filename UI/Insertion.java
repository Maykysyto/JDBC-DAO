import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Insertion extends JPanel {
    
    private static final String[] TIPOS_INCIDENTES = {"Android_Adware", "Benign", "Android_SMS_Malware", "Android_Scareware"};

    public Insertion() {
        setLayout(new GridLayout(4, 2));

        // Crear lista desplegable para seleccionar el tipo de incidente
        JComboBox<String> tipoIncidenteComboBox = new JComboBox<>(TIPOS_INCIDENTES);
        add(new JLabel("Tipo de Incidente:"));
        add(tipoIncidenteComboBox);

        // Botón para realizar la inserción
        JButton insertButton = new JButton("Insertar Incidente");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarInsercion(tipoIncidenteComboBox.getSelectedItem().toString());
            }
        });
        add(insertButton);
    }

    private void realizarInsercion(String tipoIncidenteSeleccionado) {
        // Determinar la cantidad de atributos adicionales según el tipo de incidente
        String label = null;
        Integer adicionales = null;
        String Stringlabel = null;

        switch (tipoIncidenteSeleccionado) {
            case "Android_Scareware":
                label ="Android_Scareware" ;
                adicionales =1;
                Stringlabel ="8.Flow Duration";
                break;
            case "Android_Adware":
                label = "Android_Adware";
                adicionales =2;
                Stringlabel ="8.Fwd packets+9.Packets/s";
                break;
            case "Android_SMS_Malware":
                label = "Android_SMS_Malware";
                adicionales =2;
                Stringlabel ="8.Length Var 9.Av packet";
                break;
            case "Benign":
                label="Benign";
                Stringlabel ="8.Flow Duration 9.Flow Packet 10.Fwd Packets 11.Length Var 12.Av Packet";
                adicionales =5;
                break;
        }
            JFrame frame;
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle("1.Flow Id 2.Source IP 3.Source Port 4.Destination IP 5.Destination Port 6.Protocol 7.Label "+Stringlabel);

            // Crear un panel para el contenido
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 4));


        // Crear campos de texto adicionales según la cantidad de atributos adicionales

            JTextField[] textField = new JTextField[7+adicionales];
            for (int i = 0; i < 7+adicionales; i++) {
                panel.add(new JLabel("Atributo" + (i + 1) + ":"));
                textField[i] = new JTextField();
                // Verifica si es el séptimo atributo (atributo7)
                if (i == 6) {
                    // Asigna manualmente el valor a atributo7 (supongamos que es un valor predeterminado)
                    textField[i].setText(label);
                }

                panel.add(textField[i]);
            }

        // Botón para realizar la inserción
        JButton addButton = new JButton("Add Incident");

        String finalAtributosAdicionales = label;
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButton.setEnabled(false);
                agregarIncidente(textField, finalAtributosAdicionales);
                // Re-enable the button
                addButton.setEnabled(true);
                frame.dispose(); // Cerrar la ventana de inserción después de agregar el incidente
                System.out.println(Arrays.toString(textField));
            }
        });
        panel.add(addButton);

        // Agregar el panel al marco
        frame.add(panel);

        // Configurar el tamaño y hacer visible el marco
        frame.setSize(1000, 700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void agregarIncidente(JTextField[] textFields, String atributosAdicionales) {
        Incident incidente = null;
        try {
            // Obtener valores de los campos de texto
            String atributo7 = textFields[6].getText();

            // Crear instancia de Incident o una de sus subclases según el tipo seleccionado
            switch (atributosAdicionales) {
                case "Android_Adware":
                    incidente = new Adware(
                            textFields[0].getText(),
                            textFields[1].getText(),
                            Integer.parseInt(textFields[2].getText()),
                            textFields[3].getText(),
                            Integer.parseInt(textFields[4].getText()),
                            Integer.parseInt(textFields[5].getText()),
                            atributo7,
                            Integer.parseInt(textFields[7].getText()),
                            new BigDecimal(textFields[8].getText())
                    );
                    break;
                case "Android_SMS_Malware":
                    incidente = new SMS(
                            textFields[0].getText(),
                            textFields[1].getText(),
                            Integer.parseInt(textFields[2].getText()),
                            textFields[3].getText(),
                            Integer.parseInt(textFields[4].getText()),
                            Integer.parseInt(textFields[5].getText()),
                            atributo7,
                            new BigDecimal(textFields[7].getText()),
                            new BigDecimal(textFields[8].getText())

                    );
                    break;
                case "Android_Scareware":
                    incidente = new Scareware(
                            textFields[0].getText(),
                            textFields[1].getText(),
                            Integer.parseInt(textFields[2].getText()),
                            textFields[3].getText(),
                            Integer.parseInt(textFields[4].getText()),
                            Integer.parseInt(textFields[5].getText()),
                            atributo7,
                            Integer.parseInt(textFields[7].getText())
                    );
                    break;
                case "Benign":
                    // En este ejemplo, se crea una instancia de la clase base Incident si no se selecciona una subclase
                    incidente = new Benign(
                            textFields[0].getText(),
                            textFields[1].getText(),
                            Integer.parseInt(textFields[2].getText()),
                            textFields[3].getText(),
                            Integer.parseInt(textFields[4].getText()),
                            Integer.parseInt(textFields[5].getText()),
                            atributo7,
                            Integer.parseInt(textFields[7].getText()),
                            Integer.parseInt(textFields[9].getText()),
                            new BigDecimal(textFields[8].getText()),
                            new BigDecimal(textFields[10].getText()),
                            new BigDecimal(textFields[11].getText())
                    );
            }
            System.out.println(incidente.getdetailedString());
            IncidentDAO iDAO = new IncidentDAOImpl();
            String a = iDAO.Insert(incidente);
            JOptionPane.showMessageDialog(null, a,"Insertion Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException | SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Not Valid Value","Error", JOptionPane.ERROR_MESSAGE);}}}