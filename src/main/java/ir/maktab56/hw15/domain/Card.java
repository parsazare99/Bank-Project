package ir.maktab56.hw15.domain;

import ir.maktab56.hw15.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

@Entity
public class Card extends BaseEntity<Integer> {

    public Card() {
        setCardnumber();
        setCvv();
        setCreateDate(Date.valueOf(LocalDate.now()));
        setExpirationDate();

    }


    @Column(name = "CARD_NUMBER")
    private String cardnumber;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SECOND_PASWORD")
    private String secondPassword;

    @Column(name = "CVV2")
    private int cvv;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;


    @OneToOne(mappedBy = "card")
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber() {
        Random r = new Random();
        int a = r.nextInt(10);
        StringBuilder cardnumber = new StringBuilder();
        cardnumber.append(r.nextInt(8) + 1);
        for (int i = 0; i < 15; i++) {
            cardnumber.append(r.nextInt(10));
        }

        this.cardnumber = String.valueOf(cardnumber);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv() {
        Random r = new Random();
        this.cvv = r.nextInt(900) + 100;
        ;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate() {
        LocalDate now = LocalDate.now();
        StringBuilder append = new StringBuilder();
        append = append.append(now.getYear()+5).append("-")
                .append(now.getMonthValue()).append("-").append(now.getDayOfMonth());
        Date date = Date.valueOf(String.valueOf(append));
        this.expirationDate = date;

    }

    @Override
    public String toString() {
        return "Card{" +
                "cardnumber='" + cardnumber + '\'' +
                ", password='" + password + '\'' +
                ", cvv=" + cvv +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
