package ir.maktab56.hw15.repository;

import ir.maktab56.hw15.base.repository.BaseEntityRepository;
import ir.maktab56.hw15.domain.Card;

public interface CardRepository extends BaseEntityRepository<Card, Integer> {

    boolean existByCardNumber(String cardNumber);

    Card findByCardNumber(String cardNumbr);

}
