import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusquedaPanel extends JPanel {
    private JTextField puertoInicioField, puertoFinField;
    private List<JCheckBox> protocolosCheckBoxes;
    private List<JCheckBox> labelsCheckBoxes;
    private JButton buscarButton;
    private List<String> resultadosProtocolos;
    private List<String> resultadosLabels;

    // Lista para almacenar los resultados de la búsqueda


    public BusquedaPanel() {
        // Configurar el diseño del panel
        setLayout(new GridLayout(4, 7));

        // Componentes del formulario
        add(new JLabel("Min Port:"));
        puertoInicioField = new JTextField();
        add(puertoInicioField);

        add(new JLabel("Max Port:"));
        puertoFinField = new JTextField();
        add(puertoFinField);

        add(new JLabel("Protocol:"));
        protocolosCheckBoxes = new ArrayList<>();
        agregarCheckBox("0",1);
        agregarCheckBox("6",1);
        agregarCheckBox("17",1);

        add(new JLabel("Label:"));
        labelsCheckBoxes = new ArrayList<>();
        agregarCheckBox("Android_Scareware",2);
        agregarCheckBox("Android_Adware",2);
        agregarCheckBox("Android_SMS_Malware",2);
        agregarCheckBox("Benign",2);

        // Botón de búsqueda
        buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarBusqueda();
            }
        });
        add(buscarButton);
    }

    private void agregarCheckBox(String label, int a) {
        JCheckBox checkBox = new JCheckBox(label);
        if (a==1) {
            protocolosCheckBoxes.add(checkBox);
        } else {
            labelsCheckBoxes.add(checkBox);
        }
        add(checkBox);
    }

    private void realizarBusqueda() {
        try {
            resultadosProtocolos = new ArrayList<>();
            resultadosLabels = new ArrayList<>();
            // Recuperar los valores ingresados por el usuario
            int puertoInicio = Integer.parseInt(puertoInicioField.getText());
            int puertoFin = Integer.parseInt(puertoFinField.getText());
            for (JCheckBox checkBox : protocolosCheckBoxes) {
                if (checkBox.isSelected()) {
                    resultadosProtocolos.add(checkBox.getText());
                }
            }
            for (JCheckBox checkBox : labelsCheckBoxes) {
                if (checkBox.isSelected()) {
                    resultadosLabels.add(checkBox.getText());
                }
            }
            System.out.println(puertoFin);
            System.out.println(puertoInicio);
            System.out.println(resultadosProtocolos);
            System.out.println(resultadosLabels);
            try {
                IncidentDAO iDAO = new IncidentDAOImpl();
                List<Incident> incidents = iDAO.Busqueda(resultadosProtocolos,puertoInicio,puertoFin,resultadosLabels);
                Main.Resultado(incidents);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (NumberFormatException ex) {
            // Manejar la excepción si no se puede convertir a int
            System.out.println("Error: Ingresa valores válidos para los puertos.");
        }
    }


}



