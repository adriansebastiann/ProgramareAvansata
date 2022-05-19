package databaseOperatios;

import objects.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prozoreanu Eduard and Alexoaie Adrian
 * This class contains commands for interacting with database
 */
public class Commands {

    //this method verifies if a username exists in the db
    public static boolean userExists(String username) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from users where username='" + username + "'")) {
            if (!rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    //this method inserts a users in the database
    public static boolean createUser(String userName) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into users (username) values (?)")) {
            System.out.println(userName);
            pstmt.setString(1, userName);
            pstmt.executeUpdate();
            con.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //this method return the id of a user by his username
    public static int getIdByUsername(String username) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id_user from users where username='" + username + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    //this one returns the name of a user by his id
    public static String getUsernameById(int userId) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select username from users where id_user='" + userId + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    //inserts a friendship between two users
    public static void insertFriendship(int idUser1, int idUser2) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into friendship(id_user1, id_user2) values (?, ?)")) {
            pstmt.setInt(1, idUser1);
            pstmt.setInt(2, idUser2);
            pstmt.executeUpdate();
        }
        Database.getConnection().commit();
    }

    //this method sends a message to a specific user
    public static void insertMessage(int idSender, int idReceiver, String body) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into messages(id_sender, id_receiver, body) values (?, ?, ?)")) {
            pstmt.setInt(1, idSender);
            pstmt.setInt(2, idReceiver);
            pstmt.setString(3, body);
            pstmt.executeUpdate();
        }
        Database.getConnection().commit();
    }

    //this method returns a list with all the friends given by username of a certain friend
    public static List<Integer> getFriendsByUsername(String username){
        Connection con = Database.getConnection();
        ArrayList<Integer> idFriendsForUser = new ArrayList<>();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from friendship where id_user1='" + getIdByUsername(username) + "'")) {
            while (rs.next()){
                idFriendsForUser.add(rs.getInt("id_user2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from friendship where id_user2='" + getIdByUsername(username) + "'")) {
            while (rs.next()){
                idFriendsForUser.add(rs.getInt("id_user1"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return removeDuplicates(idFriendsForUser);
    }

    //removes the duplicates from a list
    private static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> newList = new ArrayList<T>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    //this method returns a list with all the messages received by a user
    public static List<Message> getAllMessagesForUser(String username) {
        List<Message> messages = new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from messages where id_receiver='" + getIdByUsername(username) + "'")) {
            while (rs.next()) {
               messages.add(new Message((int) rs.getObject("id_sender"), (String) rs.getObject("body")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }
}
