package cat.iesesteveterradas.db;

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

        stmt.executeUpdate("""
                    INSERT INTO Faccio (nom, resum)
                    VALUES ('Demacia',
                    'Regne orgullós amb una gran tradició militar');
                """);

        stmt.executeUpdate("""
                    INSERT INTO Faccio (nom, resum)
                    VALUES ('Noxus',
                    'Imperi poderós i expansionista');
                """);

        stmt.executeUpdate("""
                    INSERT INTO Faccio (nom, resum)
                    VALUES ('Ionia',
                    'Arxipèlag on la màgia i la natura conviuen');
                """);

        stmt.executeUpdate("""
                    INSERT INTO Personatge (nom, atac, defensa, idFaccio)
                    VALUES ('Galio',1,3,1);
                """);

        stmt.executeUpdate("""
                    INSERT INTO Personatge (nom, atac, defensa, idFaccio)
                    VALUES ('Lux',2,2,1);
                """);

        stmt.executeUpdate("""
                    INSERT INTO Personatge (nom, atac, defensa, idFaccio)
                    VALUES ('Garen',2,3,1);
                """);

        stmt.executeUpdate("""
                    INSERT INTO Personatge (nom, atac, defensa, idFaccio)
                    VALUES ('Darius',3,3,2);
                """);

        stmt.executeUpdate("""
                    INSERT INTO Personatge (nom, atac, defensa, idFaccio)
                    VALUES ('Katarina',2,1,2);
                """);

        stmt.executeUpdate("""
                    INSERT INTO Personatge (nom, atac, defensa, idFaccio)
                    VALUES ('Swain',1,2,2);
                """);

        stmt.executeUpdate("""
                    INSERT INTO Personatge (nom, atac, defensa, idFaccio)
                    VALUES ('Yasuo',3,2,3);
                """);

        stmt.executeUpdate("""
                    INSERT INTO Personatge (nom, atac, defensa, idFaccio)
                    VALUES ('Ahri',2,1,3);
                """);

        stmt.executeUpdate("""
                    INSERT INTO Personatge (nom, atac, defensa, idFaccio)
                    VALUES ('Irelia',3,2,3);
                """);
    }
}