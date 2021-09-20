package ir.maktab56.hw15.domain;

import ir.maktab56.hw15.base.domain.BaseEntity;
import ir.maktab56.hw15.domain.Account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.time.LocalDate;


@Entity
public class Transaction extends BaseEntity<Integer> {

    public Transaction() {
        setDate(Date.valueOf(LocalDate.now()));
    }

    @Column(name = "ORIGIN_CARD")
    private String OriginCard;

    @Column(name = "DESTINATION_CARD")
    private String DestinationCard;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
