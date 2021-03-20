import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task01_JDBC {

    private final static HikariConfig config = new HikariConfig("/hikari.properties");
    private final static HikariDataSource ds = new HikariDataSource(config);

    public static void main(String[] args) {

        System.out.println("-------------------------------");
        System.out.println("第一题");
        System.out.println("-------------------------------");

        List<Student> list = new ArrayList<>();
        list.add(new Student("s001","老大",20,"计算机学院"));
        list.add(new Student("s002","老二",19,"计算机学院"));
        list.add(new Student("s003","老三",18,"计算机学院"));
        list.add(new Student("s004","老四",17,"计算机学院"));
        insert(list);

        for (Student s : selectAll()) {
            System.out.println(s);
        }


        System.out.println("-------------------------------");
        System.out.println("第二题");
        System.out.println("-------------------------------");

        for (Student s : selectAll()) {
            System.out.println(s);
        }


        System.out.println("-------------------------------");
        System.out.println("第三题");
        System.out.println("-------------------------------");
        deleteBySno("s004");

        for (Student s : selectAll()) {
            System.out.println(s);
        }

        System.out.println("-------------------------------");
        System.out.println("第四题");
        System.out.println("-------------------------------");

        Student student = selectBySno("s003");
        System.out.println(student);

        System.out.println("-------------------------------");
        System.out.println("第五题");
        System.out.println("-------------------------------");

        Student newStudent = new Student("s001", "老大", 20, "通信学院");
        update(newStudent);
        for (Student s : selectAll()) {
            System.out.println(s);
        }

    }

    private static List<Student> selectAll() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = ds.getConnection();
             Statement stat = conn.createStatement()) {
            try (ResultSet results = stat.executeQuery("select * from Student;")) {
                while (results.next()) {
                    students.add(new Student(results.getString(1),
                            results.getString(2),
                            results.getInt(3),
                            results.getString(4)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    private static Student selectBySno(String Sno) {
        String sql = "select * from Student where SNO = ?;";
        Student student = null;

        try (Connection conn = ds.getConnection();
             PreparedStatement stat = conn.prepareStatement(sql)) {
            stat.setString(1, Sno);
            try (ResultSet result = stat.executeQuery()) { // 只是为了让它关rt
                result.next();
                student = new Student(result.getString(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    private static void insert(List<Student> students) {
        String sql = "insert into Student values (?,?,?,?)";
        try (Connection conn = ds.getConnection();
             PreparedStatement stat = conn.prepareStatement(sql)) {
            for (Student s : students) {
                stat.setString(1, s.getSNO());
                stat.setString(2, s.getName());
                stat.setInt(3, s.getAge());
                stat.setString(4, s.getCollege());

                stat.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void deleteBySno(String Sno) {
        String sql = "delete from Student where SNO = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement stat = conn.prepareStatement(sql)) {
            stat.setString(1, Sno);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void update(Student s) {
        String sql = "update Student set SNO=?,Name=?,Age=?,College=? where SNO=?";
        try (Connection conn = ds.getConnection();
             PreparedStatement stat = conn.prepareStatement(sql)) {
            stat.setString(1,s.getSNO());
            stat.setString(2,s.getName());
            stat.setInt(3,s.getAge());
            stat.setString(4,s.getCollege());
            stat.setString(5,s.getSNO());

            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
