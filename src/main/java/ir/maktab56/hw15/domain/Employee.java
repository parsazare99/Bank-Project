package ir.maktab56.hw15.domain;

import ir.maktab56.hw15.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Employee extends BaseEntity<Integer> {


    public Employee() {
        setRegisterDate(Date.valueOf(LocalDate.now()));

    }

    public Employee(String firstname, String lastname, String username, String password, boolean isActive, boolean isManager ,int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.isManager = isManager;
        this.age=age;
        setRegisterDate(Date.valueOf(LocalDate.now()));

    }

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstname;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastname;

    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "IS_ACTIVE")
    private boolean isActive = false;

    @Column(name = "REGISTER_DATE", nullable = false)
    private Date registerDate;

    @Column(name = "AGE")
    private int age;

    @Column(name = "PHONE_NUMBER")
    private String phonenumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "IS_BLOCKED")
    private boolean isBlocked = false;

    @Column(name = "IS_MANAGER")
    private boolean isManager = false;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @Column(name = "MASSAGE")
    private String massage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
