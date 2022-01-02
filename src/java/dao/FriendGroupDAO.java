/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import obj.FriendGroup;
import util.DBContext;

/**
 *
 * @author LucasBV
 */
public class FriendGroupDAO {

    public ArrayList<FriendGroup> getListFriendGroup() throws SQLException {
        ArrayList<FriendGroup> listGroup = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            if (conn != null) {
                String sql = "SELECT ID, Name, Description FROM FriendGroup";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String description = rs.getString(3);
                    listGroup.add(new FriendGroup(id, name, description));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return listGroup;
    }

    public FriendGroup getFriendGroup(int groupID) throws SQLException {
        FriendGroup fg = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            if (conn != null) {
                String sql = "SELECT Name, Description FROM FriendGroup\n"
                        + "WHERE ID = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, groupID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String name = rs.getString(1);
                    String des = rs.getString(2);
                    fg = new FriendGroup(groupID, name, des);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return fg;
    }

    public void addGroup(String name, String description) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO FriendGroup(Name, Description)\n"
                        + "VALUES(?, ?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, description);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            conn.close();
        }
    }
}
