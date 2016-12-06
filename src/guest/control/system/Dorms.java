/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guest.control.system;

import java.util.Random;

/**
 *
 * @author Gabriel Ferreira
 */
public class Dorms {

    private String name = new String();
    private String address = new String();
    private String RAname = new String();
    private String login = new String();
    private String password = new String();
    private int numberOfRooms;
    private int dormType;
    private int maxDorm;
    private int maxRoom;
    private int maxHost;

    public Dorms() {
        name = "";
        address = "";
        RAname = "";
        numberOfRooms = 0;
        dormType = 0;
        maxDorm = 0;
        maxRoom = 0;
        maxHost = 0;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public int getDormType() {
        return dormType;
    }

    public int getMaxDorm() {
        return maxDorm;
    }

    public int getMaxHost() {
        return maxHost;
    }

    public int getMaxRoom() {
        return maxRoom;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getRAname() {
        return RAname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDormType(int dormType) {
        this.dormType = dormType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setRAname(String RAname) {
        this.RAname = RAname;
    }

    public void setMaxDorm(int maxDorm) {
        this.maxDorm = maxDorm;
    }

    public void setMaxHost(int maxHost) {
        this.maxHost = maxHost;
    }

    public void setMaxRoom(int maxRoom) {
        this.maxRoom = maxRoom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void generanteLogin() {
        login = name.toLowerCase();
        login = login.replaceAll(" ", "");
        login += numberOfRooms;
    }

    public void generatePassword() {
        Random generator = new Random();
        password = Integer.toString(generator.nextInt(999999) + 100000);
    }
}
