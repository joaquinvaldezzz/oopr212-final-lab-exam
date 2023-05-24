package olfuqc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

  private Connection connection;
  private String database;
  private String user;
  private String password;

  public DatabaseConnection(String database, String user, String password) {
    this.database = database;
    this.user = user;
    this.password = password;
  }

  public void connect() throws ClassNotFoundException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection =
        DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/" + database,
          user,
          password
        );
      System.out.println("Connected to the database successfully.");
    } catch (SQLException se) {
      System.err.println("Failed to connect to the database.");
      System.err.println(se);
    }
  }

  public void create(String query) {
    try {
      connection.createStatement().execute(query);
      System.out.println("Query executed successfully.");
    } catch (SQLException se) {
      System.err.println("Failed to execute the query.");
      System.err.println(se);
    }
  }

  public void execute(String query) {
    try {
      connection.createStatement().executeQuery(query);
      System.out.println("Query executed successfully.");
    } catch (SQLException se) {
      System.err.println("Failed to execute the query.");
      System.err.println(se);
    }
  }

  public void select(String query) {
    try {
      ResultSet results = connection.createStatement().executeQuery(query);
      System.out.println("Exam_ID\tPrelim\tMidterm\tFinals");
      while (results.next()) {
        String id = results.getString("Exam_ID");
        String prelim = results.getString("Prelim");
        String midterm = results.getString("Midterm");
        String finals = results.getString("Finals");

        System.out.format("%s \t%s \t%s \t%s\n", id, prelim, midterm, finals);
      }
      System.out.println("\n");
    } catch (SQLException se) {
      System.err.println("Failed to execute the query.");
      System.err.println(se);
    }
  }
}
