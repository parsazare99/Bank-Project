package ir.maktab56.hw15.domain;

import ir.maktab56.hw15.base.domain.BaseEntity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account extends BaseEntity<Integer> {
    public Account() {
        setAccountOpeningDate(Date.valueOf(LocalDate.now()));
    }

    @Column(name = "BALANCE")
    private long balance = 10000l;

    @Column(name = "ACCOUNT_OPENING_DATE")
    private Date AccountOpeningDate;

    @Column(name = "IS_ACTIVE")
    private boolean isActive = false;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "CARD_ID")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactionList = new ArrayList<>();

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Date getAccountOpeningDate() {
        return AccountOpeningDate;
    }

    public void setAccountOpeningDate(Date accountOpeningDate) {
        AccountOpeningDate = accountOpeningDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Id = " + getId() +
                "balance = " + balance +
                ", AccountOpeningDate = " + AccountOpeningDate +
                ", isActive = " + isActive +
                ", bank name = " + bank.getName() + "  " + ", bank branch = " + bank.getBranch() +
                '}';
    }
}
