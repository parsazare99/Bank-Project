package ir.maktab56.hw15.service.imp;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Account;
import ir.maktab56.hw15.domain.Card;
import ir.maktab56.hw15.domain.Transaction;
import ir.maktab56.hw15.repository.CardRepository;
import ir.maktab56.hw15.repository.imp.*;
import ir.maktab56.hw15.service.CardService;
import ir.maktab56.hw15.util.HibernateUtil;

import java.sql.Date;
import java.util.Scanner;

public class CardServiceImpl extends BaseEntityServiceImpl<Card, Integer, CardRepository>
        implements CardService {
    public CardServiceImpl(CardRepository repository) {
        super(repository);
    }


    @Override
    public void CardToCard(Account account) {
        TransactionServiceImpl transactionService = new TransactionServiceImpl(new TransactionRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager()));
        AccountServiceImpl accountService = new AccountServiceImpl(new AccountRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager()));

        if (account.isActive() && account.isBlocked() == false) {


            if (account.getCard().getSecondPassword() != null) {
                Scanner input = new Scanner(System.in);
                Transaction tran = new Transaction();
                String destinationCardNumber;
                String password;

                tran.setOriginCard(account.getCard().getCardnumber());
                while (true) {
                    System.out.println("Enter the 16-digit destination card number");
                    destinationCardNumber = new Scanner(System.in).next();
                    if (repository.existByCardNumber(destinationCardNumber)) {
                        break;
                    } else {
                        System.out.println("Wrong Card Number!!!!!");
                    }
                }
                tran.setDestinationCard(destinationCardNumber);

                System.out.println("Enter the amount you want to transfer");
                long transfer = input.nextLong();
                if (account.getBalance() - transfer - 600l > 10000) {
                    //gereftan cvv2
                    while (true) {
                        System.out.println("Enter your Card CVV2 :");
                        int cvv = new Scanner(System.in).nextInt();
                        if (cvv == account.getCard().getCvv()) {
                            break;
                        } else {
                            System.out.println("Wrong CVV2!!!!");
                        }
                    }
                    //gereftan tarikh
                    while (true) {
                        System.out.println("Enter your card Expiration Date :");
                        String date = new Scanner(System.in).next();
                        StringBuilder builder = new StringBuilder();
                        builder.append(account.getCard().getExpirationDate());

                        if (date.equals(String.valueOf(builder))) {
                            break;
                        } else {
                            System.out.println("wrong Date!!!!!");
                        }
                    }

                    //gereftan ramz dovom
                    while (true) {
                        System.out.println("Enter your second password :");
                        String second = new Scanner(System.in).next();
                        if (second.equals(account.getCard().getSecondPassword())) {
                            break;
                        } else {
                            System.out.println("Wrong Second Password!!!!");
                        }
                    }

                    Card card2 = repository.findByCardNumber(destinationCardNumber);
                    card2.getAccount().setBalance(card2.getAccount().getBalance() + transfer);
                    save(card2);
                    tran.setAccount(account);
                    account.setBalance(account.getBalance() - transfer - 600);

                    accountService.save(account);
                    transactionService.save(tran);


                } else {
                    System.out.println("Your account balance is not enough!!!!!\n" +
                            "Charge your account first and then try again");
                }

            } else {
                System.out.println("you have not second pass\n" +
                        "first set second pass and try again latar");
            }


        } else {
            System.out.println("your account is blocked or not active");
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
