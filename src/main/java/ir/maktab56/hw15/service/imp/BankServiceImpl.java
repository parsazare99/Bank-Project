package ir.maktab56.hw15.service.imp;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Bank;
import ir.maktab56.hw15.domain.Employee;
import ir.maktab56.hw15.repository.BankRepository;
import ir.maktab56.hw15.service.BankService;

import java.util.ArrayList;
import java.util.List;

public class BankServiceImpl extends BaseEntityServiceImpl<Bank, Integer, BankRepository>
        implements BankService {


    public BankServiceImpl(BankRepository repository) {
        super(repository);
    }

    @Override
    public List<Bank> addDefaultBranch() {
        List<Bank> bankList = new ArrayList<>();
        if (findAll().size() == 0) {
            Bank bank1 = new Bank("refah", "emam reza");
            Bank bank2 = new Bank("refah", "17 shahrivar");
            Bank bank3 = new Bank("refah", "farhang");
            Bank bank4 = new Bank("refah", "shariati");
            save(bank1);
            save(bank2);
            save(bank3);
            save(bank4);
            bankList.add(bank1);
            bankList.add(bank2);
            bankList.add(bank3);
            bankList.add(bank4);


        }
        return bankList;

    }
}
