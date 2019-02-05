package com.kenzan.codechallenge.kcodechallenge.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Employee {
    @Id
    private int id;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private Date dateOfBirth;
    private Date dateOfEmployement;
    private boolean status;

    public Employee(int id, String firstName, String middleInitial, String lastName,
                    Date dateOfBirth, Date dateOfEmployement, boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEmployement = dateOfEmployement;
        this.status = status;
    }

    public Employee() {
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

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfEmployement() {
        return dateOfEmployement;
    }

    public void setDateOfEmployement(Date dateOfEmployement) {
        this.dateOfEmployement = dateOfEmployement;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Employee[" +
                "id: " + id +
                ", firstName: " + firstName +
                ", middleInitial: " + middleInitial +
                ", lastName: " + lastName +
                ", dateOfBirth: " + dateOfBirth +
                ", dateOfEmployement: " + dateOfEmployement +
                ", status: " + status
        +"]";
    }
}
