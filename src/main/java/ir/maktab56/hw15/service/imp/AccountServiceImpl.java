package ir.maktab56.hw15.service.imp;

import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Account;
import ir.maktab56.hw15.domain.Bank;
import ir.maktab56.hw15.domain.Card;
import ir.maktab56.hw15.domain.User;
import ir.maktab56.hw15.repository.AccountRepository;
import ir.maktab56.hw15.repository.imp.BankRepositoryImp;
import ir.maktab56.hw15.repository.imp.CardRepositoryImp;
import ir.maktab56.hw15.repository.imp.UserRepositoryImpl;
import ir.maktab56.hw15.service.AccountService;
import ir.maktab56.hw15.util.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class AccountServiceImpl extends BaseEntityServiceImpl<Account, Integer, AccountRepository>
        implements AccountService {


    CardServiceImpl cardService = new CardServiceImpl(new CardRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager()));
    BankServiceImpl bankService = new BankServiceImpl(new BankRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager()));
    UserServiceImpl userService = new UserServiceImpl(new UserRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));

    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public Account createAccount(User user) {
        user=userService.findById(user.getId());
        Account account = new Account();
        String cardPassword;
        bankService.showBankInfoForClient();
        System.out.println("Enter the bank ID that you want to open an account into");
        int id = new Scanner(System.in).nextInt();
        Bank bank = bankService.findById(id);
        account.setBank(bank);
        Card card = new Card();
        while (true) {
            System.out.println("Choose a four-digit password for your card");
            cardPassword = new Scanner(System.in).next();
            if (cardPassword.length() == 4) {
                card.setPassword(cardPassword);
                break;
            } else {
                System.out.println("The password entered is not acceptable");
            }
        }
        cardService.save(card);
        account.setCard(card);
        System.out.println("Your account has been created\n" +
                " You will have to wait for your account to be verified\n");

        System.out.println(account.toString());
        System.out.println(account.getCard().toString());

        System.out.println("Your account is not Active\n" +
                "and you can not use the service\n\n" +
                "Do you want to leave a message for bank employees to expedite the activation process?\n" +
                "1 : YES\n" +
                "2 : NO");
        int answer = new Scanner(System.in).nextInt();
        if (answer == 1) {
            System.out.println("Enter your message");
            String massage = new Scanner(System.in).nextLine();
            user.setMassage(massage);
            userService.save(user);

        }
        save(account);
        return account;
    }


    @Override
    public void showUserAccounts(User user) {

        List<Account> accountList = userService.findById(user.getId()).getAccountList();
        for (Account a : accountList) {
            a.toString();
        }
    }

    @Override
    public Account editAccount(User user) {

        return null;
    }

    @Override
    public void removeAccount(User user) {

    }


}
