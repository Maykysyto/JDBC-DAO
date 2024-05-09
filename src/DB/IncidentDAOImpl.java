import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
;

public class IncidentDAOImpl implements IncidentDAO {
    @Override
    public List<Incident> get(String FlowID) throws SQLException {
        Connection con = DB.getConnection();
        String sql = "SELECT `ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label`,`Flow Duration`,`Total Fwd Packets`,`Flow Packets/s`,`Average Packet Size`,`Packet Length Variance` FROM malw_sample_set_2 WHERE `ï»¿Flow ID` = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, FlowID);
        ResultSet rs = ps.executeQuery();
        List<Incident> Listainc = Incidentassignation(rs);
        con.close();
        ps.close();
        rs.close();
        return Listainc;

    }

    @Override
    public List<Incident> getAll() throws SQLException {
        Connection con = DB.getConnection();
        String sql = "SELECT `ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label`,`Flow Duration`,`Total Fwd Packets`,`Flow Packets/s`,`Average Packet Size`,`Packet Length Variance` FROM malw_sample_set_2";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Incident> Listainc = Incidentassignation(rs);
        con.close();
        st.close();
        rs.close();
        return Listainc;
    }

    @Override
    public String Save(Incident incident) throws SQLException {
        return null;
    }

    @Override
    public String Update(Incident incident) throws SQLException {
        return null;
    }

    @Override
    public String Insert(Incident incident) throws SQLException {
            System.out.println(incident.getdetailedString());
            String a=null;
            String sql;
            Connection con = DB.getConnection();
            int result;

        PreparedStatement ps= null;
        if (Objects.equals(incident.getLabel(), "Benign")){
                    sql = "INSERT INTO malw_sample_set_2 (`ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label`,`Flow Duration`,`Total Fwd Packets`,`Flow Packets/s`,`Average Packet Size`,`Packet Length Variance`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    ps = con.prepareStatement(sql);
                    ps = con.prepareStatement(sql);
                    ps.setString(1,incident.getFlowID());
                    ps.setString(2,incident.getSourceIP());
                    ps.setInt(3,incident.getSourcePort());
                    ps.setString(4,incident.getDestinationID());
                    ps.setInt(5,incident.getDestinationPort());
                    ps.setInt(6,incident.getProtocol());
                    ps.setString(7,incident.getLabel());
                    ps.setInt(8,incident.getFlowDuration());
                    ps.setInt(9,incident.getTotalFlow());
                    ps.setBigDecimal(10,incident.getFlowPacket());
                    ps.setBigDecimal(11,incident.getPacketLength());
                    ps.setBigDecimal(12,incident.getAvPacket());
                    result = ps.executeUpdate();
                    if(result>0){a="Succes";}
                    else {a="Error";}}
            else if (Objects.equals(incident.getLabel(), "Android_Scareware")){
                    sql = "INSERT INTO malw_sample_set_2 (`ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label`,`Flow Duration`,`Total Fwd Packets`,`Flow Packets/s`,`Average Packet Size`,`Packet Length Variance`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    ps = con.prepareStatement(sql);
                    ps = con.prepareStatement(sql);
                    ps.setString(1,incident.getFlowID());
                    ps.setString(2,incident.getSourceIP());
                    ps.setInt(3,incident.getSourcePort());
                    ps.setString(4,incident.getDestinationID());
                    ps.setInt(5,incident.getDestinationPort());
                    ps.setInt(6,incident.getProtocol());
                    ps.setString(7,incident.getLabel());
                    ps.setInt(8,incident.getFlowDuration());
                    ps.setInt(9,0);
                    ps.setBigDecimal(10, BigDecimal.valueOf(0));
                    ps.setBigDecimal(11,BigDecimal.valueOf(0));
                    ps.setBigDecimal(12,BigDecimal.valueOf(0));
                    result = ps.executeUpdate();
                    if(result>0){a="Succes";}
                    else {a="Error";}}
            else if (Objects.equals(incident.getLabel(), "Android_Adware")){
                    sql = "INSERT INTO malw_sample_set_2 (`ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label`,`Flow Duration`,`Total Fwd Packets`,`Flow Packets/s`,`Average Packet Size`,`Packet Length Variance`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    ps = con.prepareStatement(sql);
                    ps = con.prepareStatement(sql);
                    ps.setString(1,incident.getFlowID());
                    ps.setString(2,incident.getSourceIP());
                    ps.setInt(3,incident.getSourcePort());
                    ps.setString(4,incident.getDestinationID());
                    ps.setInt(5,incident.getDestinationPort());
                    ps.setInt(6,incident.getProtocol());
                    ps.setString(7,incident.getLabel());
                    ps.setInt(8,0);
                    ps.setInt(9,incident.getTotalFlow());
                    ps.setBigDecimal(10,incident.getFlowPacket());
                    ps.setBigDecimal(11,BigDecimal.valueOf(0));
                    ps.setBigDecimal(12,BigDecimal.valueOf(0));
                    result = ps.executeUpdate();
                    if(result>0){a="Succes";}
                    else {a="Error";}}
            else if(Objects.equals(incident.getLabel(), "Android_SMS_Malware")){
                    sql = "INSERT INTO malw_sample_set_2 (`ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label`,`Flow Duration`,`Total Fwd Packets`,`Flow Packets/s`,`Average Packet Size`,`Packet Length Variance`) VAlUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    ps = con.prepareStatement(sql);
                    ps = con.prepareStatement(sql);
                    ps.setString(1,incident.getFlowID());
                    ps.setString(2,incident.getSourceIP());
                    ps.setInt(3,incident.getSourcePort());
                    ps.setString(4,incident.getDestinationID());
                    ps.setInt(5,incident.getDestinationPort());
                    ps.setInt(6,incident.getProtocol());
                    ps.setString(7,incident.getLabel());
                    ps.setInt(8,0);
                    ps.setInt(9,0);
                    ps.setBigDecimal(10,BigDecimal.valueOf(0));
                    ps.setBigDecimal(11,incident.getPacketLength());
                    ps.setBigDecimal(12,incident.getAvPacket());
                    result = ps.executeUpdate();
                    if(result>0){a="Succes";}
                    else {a="Error";}}

            con.close();
            ps.close();

            return a;
        }



    @Override
    public String Delete(Incident incident) throws SQLException {
        return null;
    }

    public List<Incident> Sampling(int rate) throws SQLException {
        Connection con = DB.getConnection();
        String sql = "SELECT `ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label`,`Flow Duration`,`Total Fwd Packets`,`Flow Packets/s`,`Average Packet Size`,`Packet Length Variance`  FROM malw_sample_set_2 ORDER BY RAND() LIMIT ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, rate);
        ResultSet rs = ps.executeQuery();
        List<Incident> Listainc = Incidentassignation(rs);
        con.close();
        ps.close();
        rs.close();
        return Listainc;

    }

    @Override
    public List<Integer> Report(List<Incident> Iproporcionados) {
        int B = 0;
        int M = 0;
        int UDP = 0;
        int TCP = 0;
        int Count = 0;
        for (Incident i : Iproporcionados) {
            if ("Benign".equals(i.getLabel())) {
                B++;
            } else {
                M++;
            }
            if (i.getProtocol() == 6) {
                TCP++;
            } else {
                UDP++;
            }
            Count++;
        }
        return new ArrayList<>(List.of(B, M, UDP, TCP, Count));
    }

    @Override
    public List<Incident> Busqueda(List<String> Protocol, int pbajo, int palto, List<String> Labels) throws SQLException {

        Connection con = DB.getConnection();
        String sql = "SELECT `ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label`,`Flow Duration`,`Total Fwd Packets`,`Flow Packets/s`,`Average Packet Size`,`Packet Length Variance` FROM malw_sample_set_2 WHERE `Label` IN ";
        StringBuilder sqllabel = new StringBuilder();
        for (String label : Labels) {
            sqllabel.append("'" + label + "'").append(", ");
        }
        sqllabel.setLength(sqllabel.length() - 2);
        sql += "(" + sqllabel + ")";
        StringBuilder sqlprotocol = new StringBuilder();
        for (String i : Protocol) {
            sqlprotocol.append(i).append(", ");
        }
        sqlprotocol.setLength(sqlprotocol.length() - 2);
        sql += " AND `Protocol` IN (" + sqlprotocol + ")";
        StringBuilder sqlport = new StringBuilder();
        if (pbajo == palto) {
            sqlport.append("= " + palto);
        } else {
            sqlport.append("BETWEEN " + pbajo + " AND " + palto);
        }
        sql += " AND `Destination Port` " + sqlport;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Incident> Listainc = Incidentassignation(rs);
        System.out.println(sql);
        con.close();
        st.close();
        rs.close();
        return Listainc;
    }

    @Override
    public List<Incident> Top15(String label) throws SQLException {
        List<Incident> Listainc = new ArrayList<>();
        Connection con = DB.getConnection();
        String sql = "SELECT `ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label`,`Flow Duration`,`Total Fwd Packets`,`Flow Packets/s`,`Average Packet Size`,`Packet Length Variance` FROM malw_sample_set_2 ORDER BY ? LIMIT 15";
        PreparedStatement ps = con.prepareStatement(sql);
        if (Objects.equals(label, "Android_Adware")) {
            ps.setString(1, "`Total Fwd Packets`");

        } else if (Objects.equals(label, "Android_SMS_Malware")) {
            ps.setString(1, "`Average Packet Size`");

        } else if (Objects.equals(label, "Android_Scareware")) {
            ps.setString(1, "`Flow Duration`");
        }

        return Listainc;
    }

    public List<List<Incident>> Top215(String label) throws SQLException {
        List<Incident> Listainc1 = new ArrayList<>();
        List<Incident> Listainc2 = new ArrayList<>();
        Connection con = DB.getConnection();
        if ("Android_Adware".equals(label)) {
            String sql = "SELECT `ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label` FROM malw_sample_set_2 WHERE `Label`='Android_Adware' ORDER BY `Flow Packets/s` DESC LIMIT 15";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Incident i = new Incident(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
                Listainc1.add(i);
            }
            String sql2 = "SELECT `ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label` FROM malw_sample_set_2 WHERE `Label`='Android_Adware' ORDER BY `Total Fwd Packets` DESC LIMIT 15";
            Statement st1 = con.createStatement();
            ResultSet rs1 = st.executeQuery(sql2);
            while (rs1.next()) {
                Incident i = new Incident(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
                Listainc2.add(i);
            }
        } else {
            String sql = "SELECT `ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label` FROM malw_sample_set_2 WHERE `Label`='Android_SMS_Malware' ORDER BY `Average Packet Size` DESC LIMIT 15";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Incident i = new Incident(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
                Listainc1.add(i);
            }
            String sql2 = "SELECT `ï»¿Flow ID`, `Source IP`, `Source Port`, `Destination IP`, `Destination Port`, `Protocol`,`Label` FROM malw_sample_set_2 WHERE `Label`='Android_Adware' ORDER BY `Packet Length Variance` DESC LIMIT 15";
            Statement st1 = con.createStatement();
            ResultSet rs1 = st.executeQuery(sql2);
            while (rs1.next()) {
                Incident i = new Incident(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
                Listainc2.add(i);
            }
        }
        List<List<Incident>> Listainc = List.of(Listainc1, Listainc2);

        return Listainc;
    }

    private List<Incident> Incidentassignation(ResultSet rs) throws SQLException {
        List<Incident> Listainc = new ArrayList<>();
        while (rs.next()) {

            Incident i;
            switch (rs.getString(7)) {
                case "Benign":
                    i = new Benign(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(10), rs.getBigDecimal(9), rs.getBigDecimal(11), rs.getBigDecimal(12));
                    Listainc.add(i);
                    break;
                case "Android_Scareware":
                    i = new Scareware(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
                    Listainc.add(i);
                    break;
                case "Android_Adware":
                    i = new Adware(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(9), rs.getBigDecimal(10));
                    Listainc.add(i);
                    break;
                case "Android_SMS_Malware":
                    i = new SMS(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getBigDecimal(11), rs.getBigDecimal(12));
                    Listainc.add(i);
                    break;

            }



        }
        return Listainc;
    }

}
