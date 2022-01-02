/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import obj.Contact;
import util.DBContext;

/**
 *
 * @author LucasBV
 */
public class ContactDAO {

    public void insertContact(String fisrt, String last, int groupID, String phone) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO Contact(FirstName, LastName, CreatedDate, PhoneNumber, GroupID)\n"
                        + "VALUES(?, ?, GETDATE(), ?, ?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, fisrt);
                ps.setString(2, last);
                ps.setString(3, phone);
                ps.setInt(4, groupID);
                ps.executeUpdate();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            conn.close();
        }
    }

    public ArrayList<Contact> getListContact() throws SQLException {
        ArrayList<Contact> listContact = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            if (conn != null) {
                String sql = "SELECT ID, FirstName, LastName, CreatedDate, PhoneNumber , GroupID\n"
                        + "FROM Contact";
                 ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String firstName = rs.getString(2);
                    String lastName = rs.getString(3);
                    Date createdDate = rs.getDate(4);
                    String phone = rs.getString(5);
                    int groupID = rs.getInt(6);
                    listContact.add(new Contact(id, firstName, lastName, createdDate, phone, groupID));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return listContact;
    }

    public int countContact() throws SQLException {
        int result = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            if (conn != null) {
                String sql = "SELECT COUNT(ID) FROM Contact";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    result = rs.getInt(1);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return result;
    }

    public void updateContact(int contactID, String first, String last, int groupID, String phone) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            if (conn != null) {
                String sql = "UPDATE Contact\n"
                        + "SET FirstName = ?, LastName = ?, GroupID = ?, PhoneNumber= ?\n"
                        + "WHERE ID =? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, first);
                ps.setString(2, last);
                ps.setInt(3, groupID);
                ps.setString(4, phone);
                ps.setInt(5, contactID);
                ps.executeUpdate();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            conn.close();
        }
    }

    public void removeContact(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM Contact\n"
                        + "WHERE ID = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            conn.close();
        }
    }

    public Contact getContact(int contactID) throws SQLException {
        Contact contact = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            if (conn != null) {
                String sql = "SELECT FirstName, LastName, PhoneNumber, GroupID \n"
                        + "FROM Contact\n"
                        + "WHERE ID = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, contactID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String first = rs.getString(1);
                    String last = rs.getString(2);
                    String phone = rs.getString(3);
                    int groupID = rs.getInt(4);
                    contact = new Contact(contactID, first, last, null, phone, groupID);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return contact;
    }
}
