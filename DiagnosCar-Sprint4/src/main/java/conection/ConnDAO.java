package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDAO {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String user = "rm554874";
    private static final String pwd = "231105";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, user, pwd);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados.");
            e.printStackTrace();
            return null;
        }
    }

    public static void desconectar(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar do banco de dados.");
                e.printStackTrace();
            }
        }
    }
}



