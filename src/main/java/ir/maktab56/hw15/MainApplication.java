package ir.maktab56.hw15;

import ir.maktab56.hw15.domain.Card;
import ir.maktab56.hw15.repository.imp.BankRepositoryImp;
import ir.maktab56.hw15.repository.imp.EmployeeRepositoryImp;
import ir.maktab56.hw15.service.imp.BankServiceImpl;
import ir.maktab56.hw15.service.imp.EmployeeServiceImpl;
import ir.maktab56.hw15.util.HibernateUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {

        // new EmployeeServiceImpl(new EmployeeRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager())).addDefaultManager();

        Card card = new Card();
        System.out.println(card.getCreateDate());
        System.out.println(card.getExpirationDate());
        StringBuilder builder = new StringBuilder();
        builder.append(card.getExpirationDate());
        //builder.append("parsa");

        System.out.println("Enter your card Expiration Date :");
        String date = new Scanner(System.in).next();
        if (date.equals(String.valueOf(builder)) ) {
            System.out.println("yessssssssssssssssssssss");
        } else {
            System.out.println("wrong   ghjklkjhgfgbhnjmk");
        }


//        if (Date.valueOf(date).getYear() == card.getExpirationDate().getYear()) {
//
//            if (Date.valueOf(date).getMonth() == card.getExpirationDate().getMonth()) {
//                System.out.println("yessssssssssssssssssssss");
//            } else {
//                System.out.println("Wrong Expiration Date!!!!");
//            }
//
//        } else {
//            System.out.println("Wrong Expiration Date!!!!");
//        }


        //System.out.println("datatatat            "+String.valueOf(card.getExpirationDate()));
//        System.out.println("Enter your card Expiration Date :");
//        String date = new Scanner(System.in).next();
//        if ( Date.valueOf(date).getYear()== card.getExpirationDate().getYear()) {
//
//            System.out.println("yesssssssssssss");
//
//        } else {
//            System.out.println("Wrong Expiration Date!!!!");
        //      }

//        LocalDate now = LocalDate.now();
//        int year = now.getYear()+5;
//        int monthValue = now.getMonthValue();
//        int dayOfMonth = now.getDayOfMonth();
//
//
//        StringBuilder append = new StringBuilder();
//        append = append.append(year).append("-")
//                .append(monthValue).append("-").append(dayOfMonth);
//
//
//        System.out.println("append  "+append);
//
//        Date date = Date.valueOf(String.valueOf(append));
//        Date expirationDate = date;
//        System.out.println(expirationDate);


        System.out.println("end");
    }
}
