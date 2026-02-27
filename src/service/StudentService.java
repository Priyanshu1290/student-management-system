package service;

import model.Student;
import util.DBConnection;

import java.sql.*;

public class StudentService {

    public void addStudent(Student student) throws Exception {

        Connection conn = DBConnection.getConnection();

        String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, student.getName());
        pst.setString(2, student.getEmail());
        pst.setString(3, student.getCourse());

        pst.executeUpdate();
        conn.close();

        System.out.println("Student Added Successfully!");
    }

    public void viewStudents() throws Exception {

        Connection conn = DBConnection.getConnection();

        String sql = "SELECT * FROM students";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getString("email") + " | " +
                            rs.getString("course")
            );
        }

        conn.close();
    }

    public void deleteStudent(int id) throws Exception {

        Connection conn = DBConnection.getConnection();

        String sql = "DELETE FROM students WHERE id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);

        pst.executeUpdate();
        conn.close();

        System.out.println("Student Deleted Successfully!");
    }

    // ✅ NEW UPDATE METHOD
    public void updateStudent(int id, String name, String email, String course) throws Exception {

        Connection conn = DBConnection.getConnection();

        String sql = "UPDATE students SET name=?, email=?, course=? WHERE id=?";
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, course);
        pst.setInt(4, id);

        pst.executeUpdate();
        conn.close();

        System.out.println("Student Updated Successfully!");
    }
}