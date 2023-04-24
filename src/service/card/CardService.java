package service.card;

import model.Card;
import service.BaseService;

public interface CardService extends BaseService<Card> {
    Card findByCardNum(Card card);
}
