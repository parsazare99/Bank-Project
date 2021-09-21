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

    @Column(name = "TRANSACTION_FEE")
    private int transactionFee=600;

    @Column(name = "TRANSFER_AMOUNT")
   private long TransferAmount;

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

    public String getOriginCard() {
        return OriginCard;
    }

    public int getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(int transactionFee) {
        this.transactionFee = transactionFee;
    }

    public void setOriginCard(String originCard) {
        OriginCard = originCard;
    }

    public long getTransferAmount() {
        return TransferAmount;
    }

    public void setTransferAmount(long transferAmount) {
        TransferAmount = transferAmount;
    }

    public String getDestinationCard() {
        return DestinationCard;
    }

    public void setDestinationCard(String destinationCard) {
        DestinationCard = destinationCard;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
