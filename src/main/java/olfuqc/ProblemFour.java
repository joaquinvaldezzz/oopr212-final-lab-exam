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
