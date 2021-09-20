package ir.maktab56.hw15.service.imp;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Bank;
import ir.maktab56.hw15.repository.BankRepository;
import ir.maktab56.hw15.service.BankService;

public class BankServiceImpl extends BaseEntityServiceImpl< Bank , Integer, BankRepository>
        implements BankService {


    public BankServiceImpl(BankRepository repository) {
        super(repository);
    }
}
