package ir.maktab56.hw15;

import ir.maktab56.hw15.domain.Account;
import ir.maktab56.hw15.domain.Card;
import ir.maktab56.hw15.domain.Employee;
import ir.maktab56.hw15.domain.User;
import ir.maktab56.hw15.repository.imp.BankRepositoryImp;
import ir.maktab56.hw15.repository.imp.EmployeeRepositoryImp;
import ir.maktab56.hw15.service.imp.BankServiceImpl;
import ir.maktab56.hw15.service.imp.EmployeeServiceImpl;
import ir.maktab56.hw15.util.ApplicationContext;
import ir.maktab56.hw15.util.HibernateUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        new EmployeeServiceImpl(new EmployeeRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager())).addDefaultManager();


        Scanner input = new Scanner(System.in);

        System.out.println(Date.valueOf(LocalDate.now()));
        System.out.println("<><><><><><><><><> W E L C O M E <><><><><><><><><><>");
        while (true) {
            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
            System.out.println("1 : To register on the Bank\n" +
                    "2 : Log in to Bank\n"
                    + "3 : Exit ");
            int answer = input.nextInt();
            if (answer == 1) {
                System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                System.out.println("1 : Register as a customer\n" +
                        "2 : Register as a bank employee\n"
                        + "3 : Exit ");
                answer = input.nextInt();

                if (answer == 1) {
                    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                    ApplicationContext.getUserService().registerUser();
                    System.out.println("******You must be logged in to use bank servises******");


                } else if (answer == 2) {
                    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                    ApplicationContext.getEmployeeService().registerEmployee();
                    System.out.println("******You must be logged in to use bank servises******");
                } else break;


            } else if (answer == 2) {
                while (true) {
                    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                    System.out.println("1 : Log In as a customer\n" +
                            "2 : Log In as a bank employee or bank manager\n"
                            + "3 : Exit ");
                    answer = input.nextInt();
                    if (answer == 1) {
                        User user = ApplicationContext.getUserService().logInUser();

                        if (user != null && !user.isBlocked()) {
                            while (true) {
                                System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                System.out.println("1 : Create Account\n" +
                                        "2 : show my Accounts\n" +
                                        "3 : Account management\n" +
                                        "4 : Exit ");

                                answer = input.nextInt();
                                if (answer == 1) {
                                    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                    ApplicationContext.getAccountService().createAccount(user);

                                } else if (answer == 2) {
                                    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                    ApplicationContext.getAccountService().showUserAccounts(user);
                                } else if (answer == 3) {
                                    while (true) {
                                        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                        System.out.println("1 : withdraw from bank account\n" +
                                                "2 : Increase account balance\n" +
                                                "3 : Card to Card\n" +
                                                "4 : Change card password\n" +
                                                "5 : Set or change the second password of the card\n" +
                                                "6 : Exit ");
                                        answer = input.nextInt();
                                        if (answer == 1) {
                                            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                            ApplicationContext.getAccountService().withdrawFromAccount(user);

                                        } else if (answer == 2) {
                                            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                            ApplicationContext.getAccountService().IncreaseAccountBalance(user);

                                        } else if (answer == 3) {
                                            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                            ApplicationContext.getAccountService().showUserAccounts(user);
                                            System.out.println("Select the source account");
                                            int id = new Scanner(System.in).nextInt();
                                            if (ApplicationContext.getAccountService().existsById(id)) {

                                                Account byId = ApplicationContext.getAccountService().findById(id);
                                                System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                                ApplicationContext.getCardService().CardToCard(byId);
                                            }

                                        } else if (answer == 4) {
                                            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><>");
                                            ApplicationContext.getAccountService().showUserAccounts(user);
                                            System.out.println("enter account id");
                                            int id = new Scanner(System.in).nextInt();
                                            if (ApplicationContext.getAccountService().existsById(id)) {

                                                Account byId = ApplicationContext.getAccountService().findById(id);
                                                ApplicationContext.getCardService().changeCardPassword(byId);
                                            }
                                        } else if (answer == 5) {
                                            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                            ApplicationContext.getAccountService().showUserAccounts(user);
                                            System.out.println("enter account id");
                                            int id = new Scanner(System.in).nextInt();
                                            if (ApplicationContext.getAccountService().existsById(id)) {

                                                Account byId = ApplicationContext.getAccountService().findById(id);
                                                System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                                ApplicationContext.getCardService().changeSecondPassword(byId);
                                            }
                                        } else break;


                                    }

                                } else break;

                            }
                        } else {
                            if (user == null) {
                                System.out.println("log in error");
                            }

                            break;
                        }


                    } else if (answer == 2) {
                        Employee employee = ApplicationContext.getEmployeeService().logInEmployee();


                        if (employee != null) {
                            if (employee.isActive() && !employee.isBlocked()) {
                                while (true) {
                                    if (employee.isManager()) {
                                        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                        System.out.println("1 : active/de active employee\n" +
                                                "2 : active/de active user account\n" +
                                                "3 : show All Employees\n" +
                                                "4 : Exit ");
                                        answer = input.nextInt();
                                        if (answer == 1) {
                                            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                            ApplicationContext.getEmployeeService().managerService(employee);
                                        } else if (answer == 2) {
                                            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                            ApplicationContext.getEmployeeService().activeAndUnBlockAccount(employee);
                                        } else if (answer == 3) {
                                            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                            ApplicationContext.getEmployeeService().showAllEmployeesForManager(employee);
                                        } else break;


                                    } else {
                                        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                        System.out.println("1 : active/de active or block/unblock user account\n" +
                                                "2 : show user account\n" +
                                                "3 : Exit "
                                        );
                                        answer = input.nextInt();
                                        if (answer == 1) {
                                            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                            ApplicationContext.getEmployeeService().activeAndUnBlockAccount(employee);
                                        } else if (answer == 2) {
                                            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
                                            ApplicationContext.getEmployeeService().showAllAccountForEmployee(employee);

                                        } else break;

                                    }
                                }

                            } else {

                                break;
                            }


                        } else {
                            System.out.println("log in error");
                        }


                    } else {
                        break;
                    }

                }
            } else break;
        }

    }
}
