package ir.maktab56.hw15.service.imp;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Account;
import ir.maktab56.hw15.domain.Card;
import ir.maktab56.hw15.domain.Transaction;
import ir.maktab56.hw15.repository.CardRepository;
import ir.maktab56.hw15.service.CardService;

import java.util.Scanner;

public class CardServiceImpl extends BaseEntityServiceImpl<Card, Integer, CardRepository>
        implements CardService {
    public CardServiceImpl(CardRepository repository) {
        super(repository);
    }

    @Override
    public void CardToCard(Account account) {
        Scanner input =new Scanner(System.in);
        Transaction tr=new Transaction();
        tr.setOriginCard(account.getCard().getCardnumber());
        while (true){

            System.out.println("Enter the 16-digit destination card number");
            String destinationCardNumber=new Scanner(System.in).next();
            if (destinationCardNumber.length()==16)break;else{
                System.out.println("Wrong Card Number!!!!!");
            }
        }





    }

    @Override
    public void changeCardPassword(Account account) {
        Card card = account.getCard();
        while (true) {
            System.out.println("Enter your new password :");
            System.out.println("Choose a four-digit password for your card :");
            String password = new Scanner(System.in).next();
            if (password.length() == 4) {
                card.setPassword(password);
                break;
            } else {
                System.out.println("The password entered is not acceptable");
            }
        }
        save(card);
    }

    @Override
    public void changeSecondPassword(Account account) {

        Card card = account.getCard();
        while (true) {
            System.out.println("Enter your new second password :");
            System.out.println("Choose a password longer than eight digits :");
            String secondPassword = new Scanner(System.in).next();
            if (secondPassword.length() >= 8) {
                card.setSecondPassword(secondPassword);
                break;
            } else {
                System.out.println("The password entered is not acceptable");
            }
        }
        save(card);
    }
}
