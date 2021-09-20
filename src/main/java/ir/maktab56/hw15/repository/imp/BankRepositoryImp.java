package ir.maktab56.hw15.repository.imp;

import ir.maktab56.hw15.base.repository.imp.BaseEntityRepositoryImpl;
import ir.maktab56.hw15.domain.Bank;
import ir.maktab56.hw15.repository.BankRepository;

import javax.persistence.EntityManager;

public class BankRepositoryImp extends BaseEntityRepositoryImpl<Bank, Integer> implements BankRepository {
    public BankRepositoryImp(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Bank> getEntityClass() {
        return Bank.class;
    }
}
