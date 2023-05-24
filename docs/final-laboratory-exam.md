# Final Laboratory Exam

Valdez, John Joaquin A. - BS IT 2-YB-2 OOPR212

## DatabaseConnection.java

```java
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

```

## Problem no. 1

```java
package olfuqc;

public class ProblemOne {

  public static void main(String[] args) throws ClassNotFoundException {
    DatabaseConnection root = new DatabaseConnection(
      "",
      "root",
      "password1234" // Default password: `root`
    );
    root.connect();

    String database = "CREATE DATABASE Final_ExamDB;";

    root.create(database);

    DatabaseConnection connection = new DatabaseConnection(
      "Final_ExamDB",
      "root",
      "password1234" // Default password: `root`
    );
    connection.connect();

    String table =
      """
      CREATE TABLE Exam_tbl (
        Exam_ID INT PRIMARY KEY AUTO_INCREMENT,
        Prelim INT,
        Midterm INT,
        Finals INT
      );
      """;

    connection.create(table);
  }
}

```

## Problem no. 2

```java
package olfuqc;

public class ProblemTwo {

  public static void main(String[] args) throws ClassNotFoundException {
    DatabaseConnection connection = new DatabaseConnection(
      "Final_ExamDB",
      "root",
      "password1234" // Default password: `root`
    );
    connection.connect();

    String query =
      """
      INSERT INTO Exam_tbl (Prelim, Midterm, Finals)
        VALUES
          (89, 90, 99),
          (79, 88, 76),
          (78, 89, 88),
          (88, 50, 60);
      """;

    connection.create(query);
  }
}

```

## Problem no. 3

```java
package olfuqc;

public class ProblemThree {

  public static void main(String[] args) throws ClassNotFoundException {
    DatabaseConnection connection = new DatabaseConnection(
      "Final_ExamDB",
      "root",
      "password1234" // Default password: `root`
    );
    connection.connect();

    String query = "UPDATE Exam_tbl SET Prelim = 99 WHERE Exam_ID = 4;";

    connection.create(query);
  }
}

```

## Problem no. 4

```java
package olfuqc;

public class ProblemFour {

  public static void main(String[] args) throws ClassNotFoundException {
    DatabaseConnection connection = new DatabaseConnection(
      "Final_ExamDB",
      "root",
      "password1234" // Default password: `root`
    );
    connection.connect();

    String query = "DELETE FROM Exam_tbl WHERE Exam_ID = 4;";

    connection.create(query);
  }
}

```

## Problem no. 5

```java
package olfuqc;

public class ProblemFive {

  public static void main(String[] args) throws ClassNotFoundException {
    DatabaseConnection connection = new DatabaseConnection(
      "Final_ExamDB",
      "root",
      "password1234" // Default password: `root`
    );
    connection.connect();

    String query = "SELECT * FROM Exam_tbl;";

    connection.select(query);
  }
}

```
