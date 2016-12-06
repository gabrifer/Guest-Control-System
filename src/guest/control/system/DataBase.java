/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guest.control.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Ferreira
 */
public class DataBase {

    private final String url;
    Connection con;

    public DataBase() {
        url = "jdbc:mysql://localhost/softeng";
        try {
            con = DriverManager.getConnection(url, "root", "vertrigo");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONNECTING THE DATABASE" + e);
        }
    }

    public void addDorm(int index, String name, String address, String ra, int type, int perDorm, int perRoom, int perHost, String login, String password) {
        String sql = "INSERT INTO dorms(idx,name,address,ra,type,perDorm,perRoom,perHost,login,password) "
                + "values(" + index + ",'" + name + "','" + address + "','" + ra + "'," + type + "," + perDorm + "," + perRoom + "," + perHost + ",'" + login + "','" + password + "')";
        try {
            PreparedStatement insert = con.prepareStatement(sql);
            insert.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void addGuest(int index, String name, String phone, String email, String id) {
        String sql = "INSERT INTO guests(idx,guestName,guestPhone,email,guestId) "
                + "values(" + index + ",'" + name + "','" + phone + "','" + email + "','" + id + "')";
        try {
            PreparedStatement insert = con.prepareStatement(sql);
            insert.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void addCheckIn(int index, int guestIdx, String checkInTime, String hostName, String hostId, String hostRoom, int dormIdx) {
        String sql = "INSERT INTO checkin(idx, guestIdx, checkInTime, hostName, hostId, hostRoom, dormIdx) "
                + "values(" + index + "," + guestIdx + ",'" + checkInTime + "','" + hostName + "','" + hostId + "', '" + hostRoom + "', " + dormIdx + ")";
        try {
            PreparedStatement insert = con.prepareStatement(sql);
            insert.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void addCheckOut(int index, String time, int checkInIdx) {
        String sql = "INSERT INTO checkout(idx, time, checkInIdx) "
                + "values(" + index + ",'" + time + "'," + checkInIdx + ")";
        try {
            PreparedStatement insert = con.prepareStatement(sql);
            insert.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public PreparedStatement getSavedDorms() throws SQLException {
        PreparedStatement query = con.prepareStatement("SELECT * FROM dorms");
        return query;
    }

    public PreparedStatement getSavedGuests() throws SQLException {
        PreparedStatement query = con.prepareStatement("SELECT * FROM guests");
        return query;
    }

    public PreparedStatement getSavedCheckIns() throws SQLException {
        PreparedStatement query = con.prepareStatement("SELECT * FROM checkin");
        return query;
    }
    public PreparedStatement getSavedCheckOuts() throws SQLException {
        PreparedStatement query = con.prepareStatement("SELECT * FROM checkout");
        return query;
    }

    public PreparedStatement findGuest(String name) throws SQLException {
        PreparedStatement query = con.prepareStatement("SELECT * FROM guests WHERE guestName = '" + name + "'");
        return query;
    }

    public PreparedStatement getCheckInIdx(String name) throws SQLException {
        PreparedStatement query = con.prepareStatement("SELECT * FROM checkin where hostName = '" + name + "'");
        return query;
    }

}
