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
