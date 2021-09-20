package ir.maktab56.hw15.service.imp;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Transaction;
import ir.maktab56.hw15.repository.TransactionRepository;
import ir.maktab56.hw15.service.TransactionService;

public class TransactionServiceImpl extends BaseEntityServiceImpl< Transaction , Integer, TransactionRepository>
        implements TransactionService {

    public TransactionServiceImpl(TransactionRepository repository) {
        super(repository);
    }
}
