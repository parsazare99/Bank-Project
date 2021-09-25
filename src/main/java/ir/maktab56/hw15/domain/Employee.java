package ir.maktab56.hw15.domain;

import ir.maktab56.hw15.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Employee extends Profile {


    public Employee() {
        setRegisterDate(Date.valueOf(LocalDate.now()));

    }

    public Employee(String firstname, String lastname, String username, String password, boolean isActive, boolean isManager, int age) {
        setFirstname(firstname);
        setLastname(lastname);
        setUsername(username);
        setPassword(password);
        this.isActive = isActive;
        this.isManager = isManager;
        setAge(age);
        setRegisterDate(Date.valueOf(LocalDate.now()));

    }

    @Column(name = "IS_ACTIVE")
    private boolean isActive = false;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "IS_MANAGER")
    private boolean isManager = false;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public boolean isActive() {
        return isActive;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID ='" + getId() + '\'' +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", isActive=" + isActive +
                ", age=" + getAge() +
                ", isBlocked=" + isBlocked() +
                ", isManager=" + isManager +
                ", massage='" + getMassage() + '\'' +
                '}';
    }
}
