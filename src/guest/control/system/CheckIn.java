/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guest.control.system;

import java.util.Date;

/**
 *
 * @author Austen
 */
public class CheckIn {

    private Guest g = new Guest();
    private String checkInTime;
    private Date expectedCheckOutTime;
    private String hostName;
    private String hostId;
    private String hostRoom;
    private int dormIdx;

    public CheckIn() {
    }

    public void setG(Guest g) {
        this.g = g;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setDormIdx(int dormIdx) {
        this.dormIdx = dormIdx;
    }

    public void setExpectedCheckOutTime(Date expectedCheckOutTime) {
        this.expectedCheckOutTime = expectedCheckOutTime;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setHostRoom(String hostRoom) {
        this.hostRoom = hostRoom;
    }

    public int getDormIdx() {
        return dormIdx;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public Guest getG() {
        return g;
    }

    public String getHostId() {
        return hostId;
    }

    public String getHostName() {
        return hostName;
    }

    public String getHostRoom() {
        return hostRoom;
    }
    
    

}
