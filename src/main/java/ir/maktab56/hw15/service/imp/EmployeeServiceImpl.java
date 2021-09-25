package ir.maktab56.hw15.service.imp;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Account;
import ir.maktab56.hw15.domain.Bank;
import ir.maktab56.hw15.domain.Employee;
import ir.maktab56.hw15.domain.User;
import ir.maktab56.hw15.repository.EmployeeRepository;
import ir.maktab56.hw15.repository.imp.AccountRepositoryImp;
import ir.maktab56.hw15.repository.imp.BankRepositoryImp;
import ir.maktab56.hw15.repository.imp.UserRepositoryImpl;
import ir.maktab56.hw15.service.EmployeeService;
import ir.maktab56.hw15.util.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl extends BaseEntityServiceImpl<Employee, Integer, EmployeeRepository>
        implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    AccountServiceImpl accountService = new AccountServiceImpl(new AccountRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager()));
    UserServiceImpl userService = new UserServiceImpl(new UserRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));
    BankServiceImpl bankService = new BankServiceImpl(new BankRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager()));


    @Override
    public Employee registerEmployee() {
        Scanner input = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Enter your First Name :");
        employee.setFirstname(input.next());

        System.out.println("Enter your Last Name :");
        employee.setLastname(input.next());
        while (true) {
            System.out.println("Enter your UserName :");
            String username = input.next();
            if (!repository.existByUsername(username)) {
                employee.setUsername(username);
                break;
            } else {
                System.out.println("sorry, this username is already taken ");
            }

        }

        while (true) {
            System.out.println("Enter your passWord :");
            System.out.println("Password length must be 8 or more ");
            String password = new Scanner(System.in).next();
            if (password.length() >= 8) {
                employee.setPassword(password);
                break;
            }
            System.out.println("The length of the password is shor\nplease try againe");
        }

        System.out.println("Enter your age :");
        employee.setAge(new Scanner(System.in).nextInt());
        bankService.showBankInfoForClient();
        System.out.println("Enter the bank ID in which you want to be employed");
        int bankId = new Scanner(System.in).nextInt();
        if (bankService.existsById(bankId)) {
            Bank byId = bankService.findById(bankId);
            employee.setBank(byId);
        } else {
            System.out.println("wrong bank id !!!");
        }


        System.out.println("Wellcome to Refah Bank\n");
        System.out.println("Your registration has been completed successfully.\n" +
                " Please wait for administrator approval to activate your account");
        save(employee);
        return employee;
    }

    @Override
    public Employee logInEmployee() {
        int answer = 0;
        int wrongPassword = 0;
        int wrongUsername = 0;
        Employee employee;
        String username;
        String password;
        while (true) {
            System.out.println("Enter your Username :");
            username = new Scanner(System.in).next();
            if (repository.existByUsername(username)) {
                employee = repository.findByUsername(username);

                if (employee.isBlocked()) {
                    System.out.println("Your account is blocked\n" +
                            "and you can not use the service\n\n" +
                            "Do you want to leave a message for bank manager to unblock your account?\n" +
                            "1 : YES\n" +
                            "2 : NO");
                    answer = new Scanner(System.in).nextInt();
                    if (answer == 1) {
                        System.out.println("Enter your message");
                        String massage = new Scanner(System.in).nextLine();
                        employee.setMassage(massage);
                        save(employee);
                    }
                    return employee;
                } else if (!employee.isActive()) {
                    System.out.println("Your account not active \n" +
                            "and you can not use the service\n\n" +
                            "Do you want to leave a message for bank manager to active your account?\n" +
                            "1 : YES\n" +
                            "2 : NO");
                    answer = new Scanner(System.in).nextInt();
                    if (answer == 1) {
                        System.out.println("Enter your message...");
                        String massage = new Scanner(System.in).nextLine();
                        employee.setMassage(massage);
                        save(employee);
                    }
                    return employee;
                } else {

                    while (true) {
                        System.out.println("please Enter your password : ");
                        password = new Scanner(System.in).next();
                        if (password.equals(employee.getPassword())) {
                            System.out.println("The log in was successful !");
                            return employee;
                        } else {
                            wrongPassword++;
                            if (wrongPassword == 3) {
                                employee.setBlocked(true);
                                save(employee);
                                System.out.println("Your account has been blocked\n" +
                                        "due to incorrect password entry");
                                System.out.println("Do you want to leave a message for bank employees to unblock your account?\n" +
                                        "1 : YES\n" +
                                        "2 : NO");
                                answer = new Scanner(System.in).nextInt();
                                if (answer == 1) {
                                    System.out.println("Enter your message");
                                    employee.setMassage(new Scanner(System.in).nextLine());
                                    save(employee);
                                }
                                return null;

                            }
                        }

                        System.out.println("wrong password!!\n" +
                                "please try again");
                    }

                }

            } else {
                wrongUsername++;
                if (wrongUsername == 3) break;
                System.out.println("This username is not available!!!\n" +
                        "please try again");

            }

        }

        return null;
    }

    @Override
    public void addDefaultManager() {

        if (findAll().size() == 0) {
            BankServiceImpl bankService = new BankServiceImpl(new BankRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager()));
            List<Bank> bankList = bankService.addDefaultBranch();

            Employee employee1 = new Employee("parsa", "zare", "parsazare", "9909999099", true, true, 22);
            Employee employee2 = new Employee("amir", "alemi", "mahdialemi", "12345678", true, true, 34);
            Employee employee3 = new Employee("reza", "akbari", "rezaakbari", "22446688", true, true, 45);
            Employee employee4 = new Employee("ehsan", "alava", "ehsanalavi", "11335577", true, true, 30);


            employee1.setBank(bankList.get(0));
            employee2.setBank(bankList.get(1));
            employee3.setBank(bankList.get(2));
            employee4.setBank(bankList.get(3));
            save(employee1);
            save(employee2);
            save(employee3);
            save(employee4);

            List<Employee> employeeList = findAll();
            String s = "";
            int k = 0;
            Bank bank;
            for (int i = 1; i < 5; i++) {
                s = employeeList.get(k).getFirstname() + " " + employeeList.get(k).getLastname();
                bank = bankService.findById(i);
                bank.setManagername(s);
                bankService.save(bank);
                k++;
            }
        }

    }

    @Override
    public void showAllAccountForEmployee(Employee employee) {
        Bank bank = employee.getBank();
        List<Account> accountList = bank.getAccountList();
        if (accountList.size() == 0 || accountList == null) {

            System.out.println("There is no account to display");

        } else {
            for (int i = 0; i < accountList.size(); i++) {
                System.out.println(accountList.get(i).toString());
            }
        }


    }

    @Override
    public void activeAndUnBlockAccount(Employee employee) {
        showAllAccountForEmployee(employee);
        Bank bank = employee.getBank();
        List<Account> accountList = bank.getAccountList();
        if (accountList.size() == 0 || accountList == null) {
            //System.out.println("There is no account to display");
        } else {
            System.out.println("Enter the ID of the account you want");
            int accoountId = new Scanner(System.in).nextInt();
            Account account = accountService.findById(accoountId);

            System.out.println("1 : Block Account or Unblock\n" +
                    "2 : Active Account or Deactivate ");
            int ans = new Scanner(System.in).nextInt();

            if (ans == 1) {

                if (account.isBlocked()) {
                    System.out.println("do you want UnBlock this account ?\n" +
                            "1 : YES\n" +
                            "2 : NO");
                    ans = new Scanner(System.in).nextInt();
                    if (ans == 1) {
                        account.setBlocked(false);
                    }

                } else {
                    System.out.println("do you want Block this account ?\n" +
                            "1 : YES\n" +
                            "2 : NO");
                    ans = new Scanner(System.in).nextInt();
                    if (ans == 1) {
                        account.setBlocked(true);
                    }
                }


            } else if (ans == 2) {

                if (account.isActive()) {
                    System.out.println("do you want Deactivate this account ?\n" +
                            "1 : YES\n" +
                            "2 : NO");
                    ans = new Scanner(System.in).nextInt();
                    if (ans == 1) {
                        account.setActive(false);
                    }

                } else {
                    System.out.println("do you want Activate this account ?\n" +
                            "1 : YES\n" +
                            "2 : NO");
                    ans = new Scanner(System.in).nextInt();
                    if (ans == 1) {
                        account.setActive(true);
                    }
                }


            } else {
                System.out.println("wrong answer!!");
            }

            accountService.save(account);
        }


    }

    @Override
    public void managerService(Employee employee) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> employeeList = employee.getBank().getEmployeeList();
        showAllEmployeesForManager(employee);
        System.out.println("Enter the ID of the employee you want to Active or DeActive");
        int ans = scanner.nextInt();

        if (existsById(ans)) {

            Employee byId = findById(ans);
            if (byId.isActive()) {
                System.out.println("do you want DeActive this employee ?\n" +
                        "1 : YES\n" +
                        "2 : NO");
                ans = scanner.nextInt();
                if (ans == 1) {
                    byId.setActive(false);
                }


            } else if (byId.isActive() == false) {

                System.out.println("do you want active this employee ?\n" +
                        "1 : YES\n" +
                        "2 : NO");
                ans = scanner.nextInt();
                if (ans == 1) {
                    byId.setActive(true);
                }

            }

            save(byId);
        } else {
            System.out.println("wrong ID !!!!");
        }


    }

    @Override
    public void showAllEmployeesForManager(Employee employee) {

        List<Employee> employeeList = employee.getBank().getEmployeeList();
        if (employeeList.size() < 2 || employeeList == null) {

            System.out.println("There are no employees in this bank");

        } else {

            for (int i = 0; i < employeeList.size(); i++) {
                if (!employeeList.get(i).isManager()) {
                    System.out.println(employeeList.get(i).toString());
                }

            }

        }

    }

}
