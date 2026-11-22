package cat.iesesteveterradas.dbo;

import cat.iesesteveterradas.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FaccioDAO {

    public void mostrarFaccions() {

        String sql = "SELECT * FROM Faccio";

        try (
                Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("nom") + " | " +
                        rs.getString("resum")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}