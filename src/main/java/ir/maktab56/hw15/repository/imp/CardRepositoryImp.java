package ir.maktab56.hw15.repository.imp;

import ir.maktab56.hw15.base.repository.imp.BaseEntityRepositoryImpl;
import ir.maktab56.hw15.domain.Card;
import ir.maktab56.hw15.repository.CardRepository;

import javax.persistence.EntityManager;

public class CardRepositoryImp extends BaseEntityRepositoryImpl<Card, Integer> implements CardRepository {
    public CardRepositoryImp(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Card> getEntityClass() {
        return Card.class;
    }

    @Override
    public boolean existByCardNumber(String cardNumber) {
        return entityManager.createQuery(
                "select count(id) from " + getEntityClass().getSimpleName() +
                        " where cardnumber = :cardnumber",
                Long.class
        ).setParameter("cardnumber", cardNumber)
                .getSingleResult() == 1L;

    }

    @Override
    public Card findByCardNumber(String cardNumbr) {
        Card card = entityManager.createQuery(
                "from " + getEntityClass().getSimpleName() +
                        " u where u.cardnumber = :cardnumber"
                , this.getEntityClass()).setParameter("username", cardNumbr).getSingleResult();

        return card;
    }
}
