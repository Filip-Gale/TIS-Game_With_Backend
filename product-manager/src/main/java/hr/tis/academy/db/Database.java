package hr.tis.academy.db;

import hr.tis.academy.repository.ProductRepository;
import hr.tis.academy.repository.ProductRepositoryDB;

import java.sql.*;

public class Database {

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        init();
    }

    private static final String DB_URL = "jdbc:h2:./db/academy";
    private static Database instance;

    private Database() {

    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
            init();
        }
        return instance;
    }

    public static void init() {
        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            System.out.println("INIT DB");
            statement.execute("RUNSCRIPT FROM 'classpath:init.sql'");
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, "sa", "");
    }

}
