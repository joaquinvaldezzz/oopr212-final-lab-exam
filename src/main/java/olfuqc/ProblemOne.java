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
