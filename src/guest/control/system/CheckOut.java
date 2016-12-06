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
public class CheckOut {

    String checkOutTime;
    int checkInIdx;
    public CheckOut() {
    }

    public int getCheckInIdx() {
        return checkInIdx;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void setCheckInIdx(int checkInIdx) {
        this.checkInIdx = checkInIdx;
    }
    
    
    
}
