package JDBCTraining;

import java.sql.*;
import java.util.ArrayList;

public class StudentsApp {
    public static void main(String[] args) throws SQLException {
        //String dbpath = "src/resources/students.db";
        try {
            Class.forName("org.sqlite.JDBC");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/resources/students.db");
            Statement statement = connection.createStatement();
   //         statement.executeUpdate("CREATE TABLE IF NOT EXISTS students(id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, score INTEGER NOT NULL)");
          // statement.executeUpdate("INSERT INTO students (name, score) VALUES ('IvanPetrov', 4);");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            ArrayList<Students> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt(1) + " - " +
                                resultSet.getString(2) + " - " +
                                resultSet.getDouble("score") + " - "


                );
                arrayList.add(new Students(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt("score")));
            }
            System.out.println("");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
class Students{
    private Integer id;
    private String name;
    private Integer score;

    public Students(Integer id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}