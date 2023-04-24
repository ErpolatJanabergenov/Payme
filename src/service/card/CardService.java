package service.card;

import model.Card;
import service.BaseService;

import java.util.ArrayList;
import java.util.UUID;

public interface CardService extends BaseService<Card> {
    Card findByCardNum(Card card);

    ArrayList<Card> getUserCards(UUID userId);
}
