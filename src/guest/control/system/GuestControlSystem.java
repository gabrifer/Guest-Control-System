/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guest.control.system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Gabriel Ferreira
 */
public class GuestControlSystem {

    /**
     * @param args the command line arguments
     */
    public static List<Dorms> dormsLst;
    public static List<Guest> guestLst;
    public static List<CheckIn> ckLst;
    public static List<CheckOut> coLst;
    public static DataBase dB;
    public static DefaultListModel previousModel;
    public static int loggedDormIndex;
    public static EmailSender sender;

    public static void main(String[] args) {
        // TODO code application logic here
        dormsLst = new LinkedList<>();
        guestLst = new LinkedList<>();
        ckLst = new LinkedList<>();
        coLst = new LinkedList<>();
        dB = new DataBase();
        sender = new EmailSender();
        previousModel = new DefaultListModel();
        //RETRIEVING ALL INFORMATION FROM THE DATABASE
        try {
            ResultSet result = dB.getSavedDorms().executeQuery();
            while (result.next()) {
                Dorms dorm = new Dorms();
                dorm.setName(result.getString("name"));
                dorm.setAddress(result.getString("address"));
                dorm.setRAname(result.getString("ra"));
                dorm.setDormType(Integer.parseInt(result.getString("type")));
                dorm.setMaxDorm(Integer.parseInt(result.getString("perDorm")));
                dorm.setMaxRoom(Integer.parseInt(result.getString("perRoom")));
                dorm.setMaxHost(Integer.parseInt(result.getString("perHost")));
                dorm.setLogin(result.getString("login"));
                dorm.setPassword(result.getString("password"));
                dormsLst.add(dorm);
            }

            result = dB.getSavedGuests().executeQuery();
            while (result.next()) {
                Guest g = new Guest();
                g.setIndex(Integer.parseInt(result.getString("idx")));
                g.setGuestName(result.getString("guestName"));
                g.setGuestPhoneNum(result.getString("guestPhone"));
                g.setGuestID(result.getString("guestId"));
                g.setGuestEmail(result.getString("email"));
                guestLst.add(g);
            }

            result = dB.getSavedCheckIns().executeQuery();
            while (result.next()) {
                CheckIn ck = new CheckIn();
                ck.setCheckInTime(result.getString("checkInTime"));
                ck.setHostName(result.getString("hostName"));
                ck.setHostId(result.getString("hostId"));
                ck.setHostRoom(result.getString("hostRoom"));
                ck.setDormIdx(Integer.parseInt(result.getString("dormIdx")));
                int guestIdx = Integer.parseInt(result.getString("guestIdx"));
                ck.setG(guestLst.get(guestIdx));
                ckLst.add(ck);
            }

            result = dB.getSavedCheckOuts().executeQuery();
            while (result.next()) {
                CheckOut co = new CheckOut();
                co.setCheckInIdx(Integer.parseInt(result.getString("checkInIdx")));
                co.setCheckOutTime(result.getString("time"));
                coLst.add(co);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestControlSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Dorms dormLst : dormsLst) {

            previousModel.addElement(dormLst.getName());
        }
        //sender.sendMessage();
        LoginScreen screen1 = new LoginScreen();
        screen1.setVisible(true);

    }

}
