//package ir.maktab56.hw15.domain;
//
//import ir.maktab56.hw15.base.domain.BaseEntity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Manager extends BaseEntity<Integer> {
//
//
//    @Column(name = "FIRST_NAME")
//    private String firstname;
//
//    @Column(name = "LAST_NAME")
//    private String lastname;
//
//    @Column(name = "USER_NAME", nullable = false, unique = true)
//    private String username;
//
//    @Column(name = "PASSWORD", nullable = false)
//    private String password;
//
//    @OneToOne(mappedBy = "manager")
//    private Bank bank;
//
//
//    @OneToMany(mappedBy = "manager")
//    private List<Employee> employeeList = new ArrayList<>();
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Bank getBank() {
//        return bank;
//    }
//
//    public void setBank(Bank bank) {
//        this.bank = bank;
//    }
//
//    public List<Employee> getEmployeeList() {
//        return employeeList;
//    }
//
//    public void setEmployeeList(List<Employee> employeeList) {
//        this.employeeList = employeeList;
//    }
//
//}
