package ir.maktab56.hw15.repository.imp;

import ir.maktab56.hw15.base.repository.imp.BaseEntityRepositoryImpl;
import ir.maktab56.hw15.domain.Manager;
import ir.maktab56.hw15.repository.ManagerRepository;

import javax.persistence.EntityManager;

public class ManagerRepositoryImp extends BaseEntityRepositoryImpl<Manager, Integer> implements ManagerRepository {
    public ManagerRepositoryImp(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Manager> getEntityClass() {
        return null;
    }
}
