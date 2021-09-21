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
        new EmployeeServiceImpl(new EmployeeRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager())).addDefaultManager();

























    }
}
