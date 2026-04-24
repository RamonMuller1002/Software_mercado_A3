package principal;

import database.DatabaseInitializer;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws SQLException {
        DatabaseInitializer.createDatabase();
    }
}
