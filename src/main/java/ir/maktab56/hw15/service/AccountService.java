package ir.maktab56.hw15.service;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Account;

import java.util.List;

public interface AccountService extends BaseEntityService<Account,Integer> {


    Account createAccount();

    List<Account> showUserAccounts();


    void removeAccount();

}
