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
        System.out.println("Enter the ID of the account you want");
        int accoountId = new Scanner(System.in).nextInt();
        Account account = accountService.findById(accoountId);

        System.out.println("1 : Block Account or Unblock" +
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
