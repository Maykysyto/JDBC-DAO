import java.sql.*;


public class DB {
    private static final String URL="jdbc:mysql://localhost:3306/max_sample_set_2";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "1234";
    public static Connection getConnection() throws SQLException{
        Connection con = null;
        con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        return con;
    }
    public static void closeConnection(Connection con) throws SQLException {
        con.close();
    }

    public static void closeStatement(Statement st) throws SQLException {
        st.close();
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }

    public static void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }
}