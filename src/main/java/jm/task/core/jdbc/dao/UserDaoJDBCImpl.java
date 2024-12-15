//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class UserDaoJDBCImpl extends Util implements UserDao {
//    Connection connection = getConnection();
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        String sql = """
//                CREATE TABLE IF NOT EXISTS users \
//                (
//                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
//                    name VARCHAR(64),
//                    lastname VARCHAR(64),
//                    age TINYINT
//                );""";
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.err.println("Ошибка при создании таблицы users");
//        }
//
//    }
//
//    public void dropUsersTable() {
//        String sql = "DROP TABLE IF EXISTS users;";
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.err.println("Ошибка при удалении таблицы users");
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)";
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.setString(1, name);
//            ps.setString(2, lastName);
//            ps.setByte(3, age);
//            ps.executeUpdate();
//            System.out.println("User с именем - " + name + " добавлен в базу данных");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.err.println("Ошибка при добавлении пользователя");
//        }
//
//    }
//
//    public void removeUserById(long id) {
//        String sql = "DELETE FROM users WHERE id = ?";
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.setLong(1, id);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.err.println("Ошибка при удалении пользователя");
//        }
//
//    }
//
//    public List<User> getAllUsers() {
//        List<User> userArrayList = new ArrayList<>();
//        String sql = "SELECT * FROM users";
//        try (Statement st = connection.createStatement()) {
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                User user = new User();
//                user.setId(rs.getLong("id"));
//                user.setName(rs.getString("name"));
//                user.setLastName(rs.getString("lastname"));
//                user.setAge(rs.getByte("age"));
//                userArrayList.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.err.println("Ошибка формирования результата");
//        }
//        return userArrayList;
//    }
//
//    public void cleanUsersTable() {
//        String sql = "TRUNCATE TABLE USERS;";
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.err.println("Ошибка при удалении таблицы users");
//        }
//    }
//
//
//}
