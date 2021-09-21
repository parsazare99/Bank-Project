package ir.maktab56.hw15.repository.imp;

import ir.maktab56.hw15.base.repository.imp.BaseEntityRepositoryImpl;
import ir.maktab56.hw15.domain.Employee;
import ir.maktab56.hw15.repository.EmployeeRepository;

import javax.persistence.EntityManager;

public class EmployeeRepositoryImp extends BaseEntityRepositoryImpl<Employee, Integer> implements EmployeeRepository {
    public EmployeeRepositoryImp(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }

    @Override
    public boolean existByUsername(String username) {
        return entityManager.createQuery(
                "select count(id) from " + getEntityClass().getSimpleName() +
                        " where username = :username",
                Long.class
        ).setParameter("username", username)
                .getSingleResult() >= 1L;

    }

    @Override
    public boolean existByPassword(String username, String password) {

        return entityManager.createQuery(
                "select count(id) from " + getEntityClass().getSimpleName() +
                        " where username= :username and password= :password ",
                Long.class
        ).setParameter("username", username).setParameter("password", password)
                .getSingleResult() >= 1L;
    }

    @Override
    public Employee findByUsernameAndPassword(String username, String password) {
        Employee employee = entityManager.createQuery(
                "from " + getEntityClass().getSimpleName() +
                        " u where u.username = :username and u.password = :password"
                , this.getEntityClass()).setParameter("username", username).setParameter("password", password).getSingleResult();

        return employee;
    }

    @Override
    public Employee findByUsername(String username) {
        Employee employee = entityManager.createQuery(
                "from " + getEntityClass().getSimpleName() +
                        " u where u.username = :username"
                , this.getEntityClass()).setParameter("username", username).getSingleResult();

        return employee;
    }
}
