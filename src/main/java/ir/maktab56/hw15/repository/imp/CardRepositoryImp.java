package ir.maktab56.hw15.repository.imp;

import ir.maktab56.hw15.base.repository.imp.BaseEntityRepositoryImpl;
import ir.maktab56.hw15.domain.Card;
import ir.maktab56.hw15.repository.CardRepository;

import javax.persistence.EntityManager;

public class CardRepositoryImp  extends BaseEntityRepositoryImpl<Card, Integer> implements CardRepository {
    public CardRepositoryImp(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Card> getEntityClass() {
        return Card.class;
    }
}
