package repository.card;

import model.Card;
import repository.BaseRepository;

public interface CardRepository extends BaseRepository<Card> {
    int p2p(Card outCard, Card inCard);

    int findByCardNum(Card card);


}
