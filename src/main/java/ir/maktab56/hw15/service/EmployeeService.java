package ir.maktab56.hw15.service;

import ir.maktab56.hw15.base.repository.BaseEntityRepository;
import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.domain.Employee;
import ir.maktab56.hw15.domain.User;

public interface EmployeeService extends BaseEntityService< Employee  ,Integer> {

    void addDefaultManager();


    void showAllAccountForEmployee(Employee employee);

    void activeAndUnBlockAccount(Employee employee);

    void managerService(Employee employee);

    void showAllEmployeesForManager(Employee employee);
}
