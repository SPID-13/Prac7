package container;

import java.util.LinkedList;
import java.util.Deque;
import java.util.Scanner;

public class Ex3 {
    static void outDeque (Deque st) {
        while (st.peekFirst() != null)
            System.out.print (st.pollFirst()+" ");
    }

    public static void main(String[] args) {
        final int N = 5;

        Scanner s = new Scanner(System.in);

        Deque<Card> deck1 = new LinkedList<> ();
        Deque<Card> deck2 = new LinkedList<> ();

        int v1[] = new int[N];

        for (int i = 0; i < N; i++) {
            v1[i] = s.nextInt();
            deck1.offerLast(new Card(v1[i]));
        }

        int v2[] = new int[N];

        for (int i = 0; i < N; i++) {
            v2[i] = s.nextInt();
            deck2.offerLast(new Card(v2[i]));
        }

        int kol = 0;

        while (deck1.peekFirst() != null && deck2.peekFirst() != null) {

            kol++;
            int card1 = deck1.pollFirst().getValue();
            int card2 = deck2.pollFirst().getValue();

            if ((card1 == 0 && card2 == 9) || (card1 == 9 && card2 == 0)) {
                if (card1 > card2) {
                    deck2.offerLast(new Card(card1));
                    deck2.offerLast(new Card(card2));
                } else {
                    deck1.offerLast(new Card(card1));
                    deck1.offerLast(new Card(card2));
                }
            }
            else {

                if (card1 < card2) {
                    deck2.offerLast(new Card(card1));
                    deck2.offerLast(new Card(card2));
                } else {
                    deck1.offerLast(new Card(card1));
                    deck1.offerLast(new Card(card2));
                }

                if (kol == 106) {
                    break;
                }
            }
        }



        if (kol == 106) {
            System. out.println("botva");
        } else {
            if (deck1.peekFirst() == null)
                System.out.println("second " + kol);
            else
                System.out.println("first " + kol);
        }
    }


}
