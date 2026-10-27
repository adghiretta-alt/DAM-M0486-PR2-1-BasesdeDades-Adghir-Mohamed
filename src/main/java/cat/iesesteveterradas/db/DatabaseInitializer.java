package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void init() {
        String createFaccio = """
            CREATE TABLE IF NOT EXISTS Faccio (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom VARCHAR(15),
                resum VARCHAR(500)
            );
            """;

        String createPersonatge = """
            CREATE TABLE IF NOT EXISTS Personatge (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom VARCHAR(15),
                atac REAL,
                defensa REAL,
                idFaccio INTEGER,
                FOREIGN KEY (idFaccio) REFERENCES Faccio(id)
            );
            """;

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            // Crear tablas
            stmt.execute(createFaccio);
            stmt.execute(createPersonatge);

            // Poblar con datos iniciales si la tabla Faccio está vacía
            var rs = stmt.executeQuery("SELECT COUNT(*) FROM Faccio");
            if (rs.next() && rs.getInt(1) == 0) {
                insertInitialData(stmt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertInitialData(Statement stmt) throws SQLException {
        // Aquí insertas las sentencias SQL de los anexos
        stmt.executeUpdate("INSERT INTO Faccio (nom, resum) VALUES ('Demacia', 'Regne orgullós...')");
        // ... el resto de INSERTs
    }
}