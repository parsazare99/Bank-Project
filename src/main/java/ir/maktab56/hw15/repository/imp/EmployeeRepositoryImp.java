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
        return null;
    }
}
