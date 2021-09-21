package ir.maktab56.hw15.service;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.domain.Account;
import ir.maktab56.hw15.domain.User;

public interface AccountService extends BaseEntityService<Account, Integer> {


    Account createAccount(User user);

    void showUserAccounts(User user);

    Account editAccount(User user);

    void removeAccount(User user);



}
