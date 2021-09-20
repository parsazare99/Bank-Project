package ir.maktab56.hw15.repository.imp;

import ir.maktab56.hw15.base.repository.imp.BaseEntityRepositoryImpl;
import ir.maktab56.hw15.domain.Account;
import ir.maktab56.hw15.repository.AccountRepository;

import javax.persistence.EntityManager;

public class AccountRepositoryImp extends BaseEntityRepositoryImpl<Account, Integer> implements AccountRepository {
    public AccountRepositoryImp(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }
}
