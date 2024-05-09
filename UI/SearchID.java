import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchID extends JPanel {
    private JTextField idField;
    private JButton searchButton;
    private List<String> searchResults;

    public SearchID() {
        // Configurar el diseño del panel
        setLayout(new GridLayout(2, 2));

        // Componentes del formulario
        add(new JLabel("Flow ID:"));
        idField = new JTextField();
        add(idField);

        // Botón de búsqueda
        searchButton = new JButton("Buscar");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });
        add(searchButton);
    }

    private void performSearch() {
        try {String id=idField.getText();
            try {
                IncidentDAO iDAO = new IncidentDAOImpl();
                List<Incident> incidents = iDAO.get(id);
                Main.Resultado(incidents);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }




        } catch (Exception ex) {
            // Manejar cualquier excepción que pueda ocurrir
            ex.printStackTrace();
        }
    }


}