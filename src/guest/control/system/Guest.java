/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guest.control.system;

/**
 *
 * @author Gabriel Ferreira
 */
public class Guest {

    public String guestID;
    public String guestName;
    public String guestPhoneNum;
    public String guestEmail;
    public int index;

    public Guest() {

    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setGuestPhoneNum(String guestPhoneNum) {
        this.guestPhoneNum = guestPhoneNum;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }
    

    public String getGuestID() {
        return guestID;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getGuestPhoneNum() {
        return guestPhoneNum;
    }

    public int getIndex() {
        return index;
    }

    public String getGuestEmail() {
        return guestEmail;
    }
    
    

}
