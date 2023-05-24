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
