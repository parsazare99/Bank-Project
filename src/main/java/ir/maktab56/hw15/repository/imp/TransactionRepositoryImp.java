package ir.maktab56.hw15.repository.imp;

import ir.maktab56.hw15.base.repository.imp.BaseEntityRepositoryImpl;
import ir.maktab56.hw15.domain.Transaction;
import ir.maktab56.hw15.repository.TransactionRepository;

import javax.persistence.EntityManager;

public class TransactionRepositoryImp extends BaseEntityRepositoryImpl<Transaction, Integer> implements TransactionRepository {


    public TransactionRepositoryImp(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Transaction> getEntityClass() {
        return null;
    }
}
