// repository/TaskRepo.java
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskRepo {
    Connection connection;
    public Statement statement;

    public TaskRepo() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/to_do",
                    "postgres",
                    "alonerog12345");
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



