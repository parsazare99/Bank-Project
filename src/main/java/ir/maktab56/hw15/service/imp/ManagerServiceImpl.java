package ir.maktab56.hw15.service.imp;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Manager;
import ir.maktab56.hw15.repository.ManagerRepository;
import ir.maktab56.hw15.service.ManagerService;

public class ManagerServiceImpl extends BaseEntityServiceImpl< Manager , Integer, ManagerRepository>
        implements ManagerService {
    public ManagerServiceImpl(ManagerRepository repository) {
        super(repository);
    }
}
