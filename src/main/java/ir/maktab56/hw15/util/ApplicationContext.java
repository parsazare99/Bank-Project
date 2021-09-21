package ir.maktab56.hw15.util;

import ir.maktab56.hw15.domain.Employee;
import ir.maktab56.hw15.domain.Transaction;
import ir.maktab56.hw15.repository.*;
import ir.maktab56.hw15.repository.imp.*;
import ir.maktab56.hw15.service.*;
import ir.maktab56.hw15.service.imp.*;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final UserRepository userRepository;
    private static final EmployeeRepository employeeRepository;
    private static final AccountRepository accountRepository;
    private static final CardRepository cardRepository;
    private static final TransactionRepository transactionRepository;
    private static final BankRepository bankRepository;

    private static final UserService userService;
    private static final EmployeeService employeeService;
    private static final CardService cardService;
    private static final AccountService accountService;
    private static final TransactionService transactionService;
    private static final BankService bankService;


    private ApplicationContext() {
    }

    static {
        EntityManager entityManager = HibernateUtil.getEntityMangerFactory().createEntityManager();
        userRepository = new UserRepositoryImpl(entityManager);
        userService = new UserServiceImpl(userRepository);

        employeeRepository = new EmployeeRepositoryImp(entityManager);
        accountRepository = new AccountRepositoryImp(entityManager);
        cardRepository = new CardRepositoryImp(entityManager);
        transactionRepository = new TransactionRepositoryImp(entityManager);
        bankRepository = new BankRepositoryImp(entityManager);

        employeeService = new EmployeeServiceImpl(employeeRepository);
        cardService = new CardServiceImpl(cardRepository);
        accountService = new AccountServiceImpl(accountRepository);
        transactionService = new TransactionServiceImpl(transactionRepository);
        bankService = new BankServiceImpl(bankRepository);
    }

    public static UserService getUserService() {
        return userService;
    }

    public static EmployeeService getEmployeeService() {
        return employeeService;
    }

    public static AccountService getAccountService() {
        return accountService;
    }

    public static CardService getCardService() {
        return cardService;
    }

    public static TransactionService getTransactionService() {
        return transactionService;
    }

    public static BankService getBankService() {
        return bankService;
    }


}