package ir.maktab56.hw15.service.imp;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Account;
import ir.maktab56.hw15.repository.AccountRepository;
import ir.maktab56.hw15.service.AccountService;

import java.util.List;

public class AccountServiceImpl extends BaseEntityServiceImpl< Account , Integer, AccountRepository>
        implements AccountService {


    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public Account createAccount() {
        return null;
    }

    @Override
    public List<Account> showUserAccounts() {
        return null;
    }

    @Override
    public void removeAccount() {

    }
}
