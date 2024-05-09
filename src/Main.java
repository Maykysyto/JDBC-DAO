import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        //Incident Incidente= new Incident("1","2","3","4","5","6");
        //System.out.println(Incidente);
        //Connection con = DB.getConnection();
        //if (con!=null){
        //    System.out.println("Done");
        //List<Integer> P= List.of(6);
        //int p1 = 0;
        //int p2 = 100000;
        //List<String> L=List.of("Android_SMS_Malware");
        //List<Incident> b = iDAO.Busqueda(P,p1,p2,L);
        //for (Incident incident:b) {
        //    if (incident instanceof SMS) {
        //        SMS smsIncident = (SMS) incident;
        //        // Realizar operaciones específicas de PersonTipoA
        //        System.out.println(smsIncident.getdetailedString());

        //}

        //}
        //System.out.println(b.size());

            SwingUtilities.invokeLater(() -> {
                JFrame initialFrame = new JFrame("Malware Searcher");
                initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JButton getAllButton = new JButton("Get All Incidents");
                getAllButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            IncidentDAO iDAO = new IncidentDAOImpl();
                            List<Incident> incidents = iDAO.getAll();
                            Resultado(incidents);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                JButton Buscar = new JButton("Search Filter");
                Buscar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            JFrame busquedaFrame = new JFrame("Search Filter");
                            busquedaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            BusquedaPanel busquedaPanel = new BusquedaPanel();
                            busquedaFrame.getContentPane().add(busquedaPanel);
                            busquedaFrame.pack();
                            busquedaFrame.setSize(600, 400); // Ajusta el tamaño según tus necesidades
                            busquedaFrame.setLocationRelativeTo(null);
                            busquedaFrame.setVisible(true);
                        }

                });
                JButton IDsearch = new JButton("ID Search");
                IDsearch.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame("ID Search");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        SearchID searchPanel = new SearchID();
                        frame.getContentPane().add(searchPanel);
                        frame.add(searchPanel);
                        frame.setSize(500, 150);
                        frame.setVisible(true);
                        frame.setLocationRelativeTo(null);
                    }


                });
                JButton Samplig_Report = new JButton("Sampling_Report");
                Samplig_Report.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame("Sampling");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        Sample_Rep searchPanel = new Sample_Rep();
                        frame.getContentPane().add(searchPanel);
                        frame.add(searchPanel);
                        frame.setSize(500, 150);
                        frame.setVisible(true);
                        frame.setLocationRelativeTo(null);
                    }


                });
                JButton insertionButton = new JButton("Insertion");
                insertionButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame insertionFrame = new JFrame("Insertion");
                        insertionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        Insertion insertionPanel = new Insertion();
                        insertionFrame.getContentPane().add(insertionPanel);
                        insertionFrame.setSize(500, 150);
                        insertionFrame.setVisible(true);
                        insertionFrame.setLocationRelativeTo(null);
                    }
                });

                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout());
                panel.add(getAllButton);
                panel.add(Buscar);
                panel.add(IDsearch);
                panel.add(Samplig_Report);
                panel.add(insertionButton);


                initialFrame.getContentPane().add(panel);
                initialFrame.pack();
                initialFrame.setSize(300,300);
                initialFrame.setLocationRelativeTo(null);
                initialFrame.setVisible(true);
            });
        }
    public static void Resultado(List<Incident> incidents) throws SQLException {
        JFrame frame = new JFrame("Resultado de la Búsqueda");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        String numberOfResults = String.valueOf(incidents.size());
        if (incidents.size()==0){numberOfResults="No Coincidences";}
        frame.setTitle("Search Result - Number of Results: " + String.valueOf(numberOfResults));

        IncidentListPanel incidentListPanel = new IncidentListPanel(incidents);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(incidentListPanel), BorderLayout.CENTER);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setSize(1200,800);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    }










