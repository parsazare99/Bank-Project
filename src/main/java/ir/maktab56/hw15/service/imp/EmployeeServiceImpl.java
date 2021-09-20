package ir.maktab56.hw15.service.imp;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Bank;
import ir.maktab56.hw15.domain.Employee;
import ir.maktab56.hw15.repository.EmployeeRepository;
import ir.maktab56.hw15.repository.imp.BankRepositoryImp;
import ir.maktab56.hw15.service.EmployeeService;
import ir.maktab56.hw15.util.HibernateUtil;

import java.util.List;

public class EmployeeServiceImpl extends BaseEntityServiceImpl<Employee, Integer, EmployeeRepository>
        implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public void addDefaultManager() {

        if (findAll().size() == 0) {
            BankServiceImpl bankService = new BankServiceImpl(new BankRepositoryImp(HibernateUtil.getEntityMangerFactory().createEntityManager()));
            List<Bank> bankList = bankService.addDefaultBranch();

            Employee employee1 = new Employee("parsa", "zare", "parsazare", "9909999099", true, true,22);
            Employee employee2 = new Employee("amir", "alemi", "mahdialemi", "12345678", true, true,34);
            Employee employee3 = new Employee("reza", "akbari", "rezaakbari", "22446688", true, true,45);
            Employee employee4 = new Employee("ehsan", "alava", "ehsanalavi", "11335577", true, true,30);


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
}
