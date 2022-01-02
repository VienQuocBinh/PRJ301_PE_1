/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obj;

import java.sql.Date;

/**
 *
 * @author LucasBV
 */
public class Contact {

    private int id;
    private String firstName;
    private String lastName;
    private Date createdDate;
    private String phoneNumber;
    private int groupID;

    public Contact() {
    }

    public Contact(int id, String firstName, String lastName, Date createdDate, String phoneNumber, int groupID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdDate = createdDate;
        this.phoneNumber = phoneNumber;
        this.groupID = groupID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    @Override
    public String toString() {
        return "ID=" + id + ",Fisrt Name=" + firstName + ",Last Name=" + lastName + ",CreateDate=" + createdDate + ",Phone Number=" + phoneNumber + ",GroupID=" + groupID;
    }

}
