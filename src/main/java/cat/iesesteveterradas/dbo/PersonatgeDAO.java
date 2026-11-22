package cat.iesesteveterradas.dbo;

import cat.iesesteveterradas.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonatgeDAO {

    public void mostrarPersonatges() {

        String sql = """
                SELECT *
                FROM Personatge
                """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("nom") + " | " +
                        rs.getDouble("atac") + " | " +
                        rs.getDouble("defensa")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPersonatgesPerFaccio(String faccio) {

        String sql = """
                SELECT p.nom
                FROM Personatge p
                JOIN Faccio f ON p.idFaccio = f.id
                WHERE f.nom = ?
                """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, faccio);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("nom"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void millorAtacant(String faccio) {

        String sql = """
                SELECT p.nom,p.atac
                FROM Personatge p
                JOIN Faccio f ON p.idFaccio = f.id
                WHERE f.nom = ?
                ORDER BY p.atac DESC
                LIMIT 1
                """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, faccio);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        rs.getString("nom") +
                        " -> Atac: " +
                        rs.getDouble("atac")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void millorDefensor(String faccio) {

        String sql = """
                SELECT p.nom,p.defensa
                FROM Personatge p
                JOIN Faccio f ON p.idFaccio = f.id
                WHERE f.nom = ?
                ORDER BY p.defensa DESC
                LIMIT 1
                """;

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, faccio);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        rs.getString("nom") +
                        " -> Defensa: " +
                        rs.getDouble("defensa")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}