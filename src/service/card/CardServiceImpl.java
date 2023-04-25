package service.card;

import model.Card;
import repository.card.CardRepositoryImpl;

import java.util.ArrayList;
import java.util.UUID;

public class CardServiceImpl implements CardService {

    private static final CardServiceImpl instance = new CardServiceImpl();

    public static CardServiceImpl getInstance() {
        return instance;
    }

    private CardServiceImpl() {
    }

    CardRepositoryImpl cardRepository = CardRepositoryImpl.getInstance();
    @Override
    public int add(Card card) {
        int save = cardRepository.save(card);
        if (save == -1){
            return save;
        }
        return 1;
    }


    @Override
    public ArrayList<Card> findByCardNum(Card card) {
        return cardRepository.findByCardNum(card);
    }

    @Override
    public ArrayList<Card> getUserCards(UUID userId) {
        return cardRepository.getUserCards(userId);
    }

    @Override
    public int p2p(Card outCard, Card inCard, Double amount) {
        return cardRepository.p2p(outCard,inCard,amount);
    }
}
