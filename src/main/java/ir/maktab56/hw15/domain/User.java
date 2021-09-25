package ir.maktab56.hw15.domain;

import ir.maktab56.hw15.base.domain.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends Profile {

    public User() {
        setRegisterDate(Date.valueOf(LocalDate.now()));
    }

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
        setRegisterDate(Date.valueOf(LocalDate.now()));
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accountList = new ArrayList<>();


    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }



    @Override
    public String toString() {
        return "User{" +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", isBlocked=" + isBlocked() +
                ", massage='" + getMassage() + '\'' +
                '}';
    }
}
