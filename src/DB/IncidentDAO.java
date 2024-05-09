import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IncidentDAO {
    List<Incident> Sampling(int rate) throws  SQLException;

    List<Integer> Report(List<Incident> Iproporcionados);

    List<Incident> get(String FlowID) throws SQLException;
    List<Incident> getAll() throws SQLException;
    List<Incident> Busqueda(List<String> Protocol, int rbajo, int ralto,List<String> Label) throws SQLException;
    List<Incident> Top15(String label) throws SQLException;

    List<List<Incident>> Top215(String label) throws SQLException;
    String Save(Incident incident) throws SQLException;
    String Update(Incident incident) throws SQLException;
    String Insert(Incident incident) throws SQLException;
    String Delete(Incident incident) throws SQLException;


}
