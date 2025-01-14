package repository.card;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Card;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class CardRepositoryImpl implements CardRepository{

    private static final CardRepositoryImpl instance = new CardRepositoryImpl();

    public static CardRepositoryImpl getInstance() {
        return instance;
    }

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String cardPath = "C:\\Users\\User\\IdeaProjects\\Payme\\src\\recurse\\Card.json";

    private CardRepositoryImpl() {
    }



    @Override
    public int save(Card card) {
        ArrayList<Card> cards;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cardPath))){
            cards = gson.fromJson(bufferedReader, new TypeToken<>(){});
            for (Card card1 : cards) {
                if (Objects.equals(card1.getCardNum(),card.getCardNum())) {
                    return -1;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cards.add(card);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(cardPath))){
            gson.toJson(cards, bufferedWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }


    @Override
    public int p2p(Card outCard, Card inCard, Double amount) {
        double v = amount + amount * 0.01;
        if (outCard.getBalance() < v) {
            return -1;
        }
        Double balance = outCard.getBalance();
        Double balance1 = inCard.getBalance();
        outCard.setBalance(balance - v);
        inCard.setBalance(balance1 + v);
        return 1;
    }

    @Override
    public ArrayList<Card> getUserCards(UUID userId) {
        ArrayList<Card> myCards = new ArrayList<>();
        ArrayList<Card> cards;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cardPath))){
            cards = gson.fromJson(bufferedReader, new TypeToken<>(){});
            for (Card card1 : cards) {
                if (Objects.equals(card1.getUserId(),userId)) {
                    myCards.add(card1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return myCards;
    }

    @Override
    public ArrayList<Card> findByCardNum(Card card) {
        ArrayList<Card> cards1 = new ArrayList<>();
        ArrayList<Card> cards;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cardPath))){
            cards = gson.fromJson(bufferedReader, new TypeToken<>(){});
            for (Card card1 : cards) {
                if (Objects.equals(card1.getCardNum(), card.getCardNum())) {
                   cards1.add(card1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cards1;
    }
}
