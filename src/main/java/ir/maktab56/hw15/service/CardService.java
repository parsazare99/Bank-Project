package ir.maktab56.hw15.service;

import ir.maktab56.hw15.base.repository.BaseEntityRepository;
import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.domain.Account;
import ir.maktab56.hw15.domain.Card;

public interface CardService extends BaseEntityService< Card  ,Integer> {

    void CardToCard(Account account);

    void changeCardPassword(Account account);

    void changeSecondPassword(Account account);


}
