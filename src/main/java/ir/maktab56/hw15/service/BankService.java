package ir.maktab56.hw15.service;

import ir.maktab56.hw15.base.repository.BaseEntityRepository;
import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.domain.Bank;

import java.util.List;

public interface BankService extends BaseEntityService<Bank, Integer> {

    List<Bank> addDefaultBranch();

    void showBankInfoForClient();



}
