package ir.maktab56.hw15.domain;

import ir.maktab56.hw15.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank extends BaseEntity<Integer> {

    @Column(name = "BANK_NAME")
    private String name;


    @Column(name = "BRANCH_NAME")
    private String Branch;

    @Column(name = "ADDRESS")
    private String address;

    @OneToMany(mappedBy = "bank")
    private List<Account> accountList = new ArrayList<>();


    @OneToMany(mappedBy = "bank")
    private List<Employee> employeeList = new ArrayList<>();


    @OneToOne
    @JoinColumn(name = "MANAGER_ID")
    private Manager manager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
