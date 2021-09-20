package ir.maktab56.hw15.service.imp;

import ir.maktab56.hw15.base.service.BaseEntityService;
import ir.maktab56.hw15.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.hw15.domain.Card;
import ir.maktab56.hw15.repository.CardRepository;
import ir.maktab56.hw15.service.CardService;

public class CardServiceImpl extends BaseEntityServiceImpl<Card  , Integer, CardRepository>
        implements CardService {
    public CardServiceImpl(CardRepository repository) {
        super(repository);
    }
}
