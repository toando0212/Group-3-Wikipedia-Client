package vn.edu.usth.wikipediaclient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDataBase {
    private static final String URL = "jdbc:sqlite:users.db";

    // Kết nối SQLite
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Kết nối SQLite thành công!");
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại: " + e.getMessage());
        }
        return conn;
    }


    // Tạo bảng users
    public static void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + " username TEXT UNIQUE NOT NULL,"
                + " password TEXT NOT NULL"
                + ");";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
            System.out.println("Tạo bảng users thành công!");
        } catch (SQLException e) {
            System.out.println("Tạo bảng thất bại: " + e.getMessage());
        }
    }

    // Đăng ký người dùng
    public static boolean registerUser(String username, String password) {
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("Đăng ký thành công!");
            return true;
        } catch (SQLException e) {
            System.out.println("Đăng ký thất bại: " + e.getMessage());
            return false;
        }
    }

    // Đăng nhập người dùng
    public static boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Đăng nhập thành công!");
                return true;
            } else {
                System.out.println("Sai tên đăng nhập hoặc mật khẩu!");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Đăng nhập thất bại: " + e.getMessage());
            return false;
        }
    }

    // Main: Giao diện Console
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createUserTable();

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Thoát");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Xử lý Enter sau khi nhập số

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên đăng nhập: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    String regPassword = scanner.nextLine();
                    registerUser(regUsername, regPassword);
                    break;
                case 2:
                    System.out.print("Nhập tên đăng nhập: ");
                    String logUsername = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    String logPassword = scanner.nextLine();
                    loginUser(logUsername, logPassword);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }
    }
}


