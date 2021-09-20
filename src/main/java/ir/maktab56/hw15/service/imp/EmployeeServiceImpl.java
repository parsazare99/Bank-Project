package ir.maktab56.hw15.service.imp;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Employee;
import ir.maktab56.hw15.repository.EmployeeRepository;
import ir.maktab56.hw15.service.EmployeeService;

public class EmployeeServiceImpl extends BaseEntityServiceImpl< Employee , Integer, EmployeeRepository>
        implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }
}
