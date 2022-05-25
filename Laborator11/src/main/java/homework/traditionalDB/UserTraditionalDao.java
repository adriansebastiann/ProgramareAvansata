package homework.traditionalDB;
import homework.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTraditionalDao {

    public static User getUserById(int idUser) {
        Connection con = Database.getConnection();
        User user  = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from user where id_user=" + idUser)) {
            while (rs.next()) {
                user = new User(rs.getInt("id_user"), rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
