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
