package controller;

import model.Card;
import model.User;

import java.util.ArrayList;

import static controller.Main.*;


public class UserUI {
    public static void userMenu(User user) {
        int cm  = 0;
        while (true) {
            System.out.println("1. Add card\t2. Peer to peer\t3. History by Card\t4. Show card\t5. IsBlock\t0. Back");
            cm = scanNum.nextInt();
            switch (cm) {
                case 1 -> {
                    addCard(user);
                }
                case 2 -> {
                    P2P(user);
                }
                case 3 -> {
                    history(user);
                }
                case 4 -> {
                    showCard(user);
                }
                case 5 -> {
                    isBlock(user);
                }
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Wrong input");
                    return;
                }
            }
        }
    }

    private static void isBlock(User user) {

    }

    private static void showCard(User user) {
        ArrayList<Card> userCards = cardService.getUserCards(user.getId());
        if (userCards.isEmpty()) {
            System.out.println("Hozircha kartayngiz yo'q");
        }
        int i = 1;
        for (Card userCard : userCards) {
            System.out.println(i++ + ": " + userCard.getName() + " || " + userCard.getAmount());
        }

    }

    private static void history(User user) {

    }

    private static void P2P(User user) {
        while (true) {
            System.out.print("Enter card num: ");
            String cardNum = scanStr.nextLine();

            Card card = new Card(cardNum);
            if (cardService.findByCardNum(card) == null) {
                System.out.println("Bunaqa karta toplmadi");
                    continue;
            }
            System.out.print("Enter amount: ");
            Double amount = scanNum.nextDouble();
            showCard(user);
            System.out.print("\nChoose card: ");
            int index = scanNum.nextInt();

        }
    }

    private static void addCard(User user) {
        System.out.print("Enter name: ");
        String name = scanStr.nextLine();

        System.out.print("Enter card num: ");
        String cardNum = scanStr.nextLine();

        Card card = new Card(name,cardNum,10000D,user.getId());

        if (cardService.add(card) == -1) {
            System.out.println("Bunaqa karta oldindan bor");
        }else {
            System.out.println("Success");
        }
    }
}
