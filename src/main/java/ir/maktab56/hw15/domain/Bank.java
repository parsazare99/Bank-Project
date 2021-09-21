package ir.maktab56.hw15.domain;

import ir.maktab56.hw15.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank extends BaseEntity<Integer> {
    public Bank() {
    }

    public Bank(String name, String branch) {
        this.name = name;
        Branch = branch;
    }

    @Column(name = "BANK_NAME")
    private String name;


    @Column(name = "BRANCH_NAME")
    private String Branch;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "MANAGER_NAME")
    private String managername;


    @OneToMany(mappedBy = "bank")
    private List<Account> accountList = new ArrayList<>();


    @OneToMany(mappedBy = "bank")
    private List<Employee> employeeList = new ArrayList<>();

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

    public void setManager(String manager) {
        this.address = manager;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
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


    public String showBankInfoForClient() {
        return "Bank{" +
                "id = '" + getId() + '\'' +
                "name = '" + name + '\'' +
                ", Branch ='" + Branch + '\'' +
                ", managername ='" + managername + '\'' +
                '}';
    }

}
