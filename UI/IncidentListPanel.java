import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class IncidentListPanel extends JPanel {


        private DefaultListModel<Incident> IncidentListModel;
        private JList<Incident> incidentList;

        public IncidentListPanel(List<Incident> b) {
            IncidentListModel = new DefaultListModel<>();
            incidentList = new JList<>(IncidentListModel);

            incidentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            incidentList.setLayoutOrientation(JList.VERTICAL);

            JButton detailsButton = new JButton("Show Details");
            detailsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showDetails();
                }
            });

            add(new JScrollPane(incidentList));
            add(detailsButton);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            // Agregar algunas instancias de Persona a la lista
            for (Incident i: b){
            IncidentListModel.addElement(i);
        }
        }

        void showDetails() {
            Incident incident = incidentList.getSelectedValue();
            if (incident != null) {
                String details = null;

                if (incident instanceof Adware) {
                    Adware i = (Adware) incident;
                    details = i.getdetailedString();

                } else if (incident instanceof SMS) {
                    SMS i = (SMS) incident;

                    details = i.getdetailedString();

                } else if (incident instanceof Benign) {
                    Benign i = (Benign) incident;

                    details = i.getdetailedString();}

                else if (incident instanceof Scareware){
                    Scareware i = (Scareware) incident;
                    details = i.getdetailedString();
                }

                JOptionPane.showMessageDialog(this, details, "Incident details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Select an Incident", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

}
