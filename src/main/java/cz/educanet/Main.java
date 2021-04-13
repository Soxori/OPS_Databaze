package cz.educanet;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/c3zoo", "root",""
        );

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                "SELECT z.id, z.jmeno, d.nazev FROM zvirata AS Z JOIN druhy as D ON (Z.druh = D.id) LIMIT 10"
        );

        while(result.next()) {
            int id = result.getInt("id");
            String title = result.getString("jmeno");
            String nazevDruhu = result.getString("nazev");
            System.out.println("+--------------------------------+");
            System.out.println("|" + id + "\t;" + title + "\t;" + nazevDruhu);
        }
        connection.close();
    }
}
