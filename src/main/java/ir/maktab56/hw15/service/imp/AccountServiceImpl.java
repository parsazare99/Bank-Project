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

    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public Account createAccount(User user) {
        CardServiceImpl cardService = new CardServiceImpl(new CardRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager()));
        BankServiceImpl bankService = new BankServiceImpl(new BankRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager()));
        UserServiceImpl userService = new UserServiceImpl(new UserRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));


        user = userService.findById(user.getId());
        Account account = new Account();
        String cardPassword;
        bankService.showBankInfoForClient();
        System.out.println("Enter the bank ID that you want to open an account into");
        int id = new Scanner(System.in).nextInt();
        Bank bank = bankService.findById(id);
        account.setBank(bank);
        account.setUser(user);
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
        System.out.println("Account infomation : ");
        System.out.println(account.toString());
        System.out.println(account.getCard().toString());
        save(account);
        return account;
    }

    @Override
    public void showUserAccounts(User user) {
        UserServiceImpl userService = new UserServiceImpl(new UserRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));

        user = userService.findById(user.getId());
        List<Account> accountList = user.getAccountList();

        if (accountList.size() == 0 || accountList == null) {

            System.out.println("There is no account to display");

        } else {
            for (Account a : accountList) {
                System.out.println(a.toString());
            }
        }
    }

    @Override
    public Account editAccount(User user) {

        return null;
    }

    @Override
    public void removeAccount(User user) {

    }

    @Override
    public void withdrawFromAccount(User user) {


        showUserAccounts(user);
        System.out.println("enter your account id : ");
        int id = new Scanner(System.in).nextInt();
        if (existsById(id)) {
            Account byId = findById(id);
            if (byId.isActive()) {
                System.out.println("Enter the amount you want to withdraw from the account");
                long withdraw = new Scanner(System.in).nextLong();
                if (byId.getBalance() - withdraw >= 10000l) {
                    int count = 0;
                    while (true) {

                        System.out.println("enter your password");
                        String pass = new Scanner(System.in).next();
                        if (pass.equals(byId.getCard().getPassword())) {
                            byId.setBalance(byId.getBalance() - withdraw);
                            save(byId);
                            break;


                        } else {
                            count++;
                            if (count == 3) {
                                byId.setBlocked(true);
                                save(byId);
                                System.out.println("your account is blocked ..");
                                break;
                            }
                        }


                    }


                } else {
                    System.out.println("Your account balance is not enough");
                }

            } else {
                System.out.println("your accout is not active !!");
            }
        } else {
            System.out.println("account nit found !!");
        }


    }

    @Override
    public void IncreaseAccountBalance(User user) {

        showUserAccounts(user);
        System.out.println("enter your account id : ");
        int id = new Scanner(System.in).nextInt();
        if (existsById(id)) {
            Account byId = findById(id);
            if (byId.isActive()) {
                System.out.println("Enter the amount you want to increase account balance");
                long increase = new Scanner(System.in).nextLong();
                byId.setBalance(byId.getBalance() + increase);
                save(byId);
            } else {
                System.out.println("your account is not active!!");
            }

        } else {
            System.out.println("account id not exsist !");
        }

    }
}
