import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Sample_Rep extends JPanel {
    private static final Integer[] INTEGERS = {10, 100, 1000, 10000, 100000, 355609};

    public Sample_Rep() {
        // Configurar el diseño del panel
        setLayout(new GridLayout(2, 3));

        // Crear y agregar botones con los strings especificados
        for (Integer i : INTEGERS) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    RealizarReport(i);
                    System.out.println("Botón presionado: " + i);
                }
            });
            add(button);
        }
    }

    private void RealizarReport(int i) {
        try {
            IncidentDAO iDAO = new IncidentDAOImpl();
            List<Incident> incidents = iDAO.Sampling(i);
            Main.Resultado(incidents);
            List<Integer> a = iDAO.Report(incidents);

            // Crear un nuevo marco para el informe
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle("Report");

            // Crear un panel para el contenido
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

            // Crear una etiqueta con el contenido del informe
            JLabel label1 = new JLabel("B="+a.get(0)+", M="+a.get(1)+", UDP="+a.get(2)+", TCP="+a.get(3)+", TOTAL="+a.get(4));
            panel.add(label1);

            // Agregar el panel al marco
            frame.add(panel);

            // Configurar el tamaño y hacer visible el marco
            frame.setSize(300, 100);
            frame.setVisible(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}