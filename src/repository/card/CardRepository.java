package repository.card;

import model.Card;
import repository.BaseRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface CardRepository extends BaseRepository<Card> {
    int p2p(Card outCard, Card inCard);

    int findByCardNum(Card card);
    ArrayList<Card> getUserCards(UUID userId);


}
