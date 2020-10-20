package container;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex2 {
    static void outQueue (Queue st) {
        while (st.peek() != null)
            System.out.print (st.poll()+" ");
    }

    static Queue reverse (Queue st) {
        Queue newSt = new LinkedList(   ) {
        };
        while (st.peek() != null) {
            newSt.offer(st.poll());
        }
        return newSt;
    }

    public static void main(String[] args) {
        final int N = 5;

        Scanner s = new Scanner(System.in);

        Queue<Card> deck1 = new LinkedList<> ();
        Queue<Card> deck2 = new LinkedList<> ();

        int v1[] = new int[N];

        for (int i = 0; i < N; i++) {
            v1[i] = s.nextInt();
            deck1.offer(new Card(v1[i]));
        }

        int v2[] = new int[N];

        for (int i = 0; i < N; i++) {
            v2[i] = s.nextInt();
            deck2.offer(new Card(v2[i]));
        }

        int kol = 0;

        while (deck1.peek() != null && deck2.peek() != null) {

            kol++;
            int card1 = deck1.poll().getValue();
            int card2 = deck2.poll().getValue();

            if ((card1 == 0 && card2 == 9) || (card1 == 9 && card2 == 0)) {
                if (card1 > card2) {
                    deck2 = reverse(deck2);
                    deck2.offer(new Card(card1));
                    deck2.offer(new Card(card2));
                    deck2 = reverse(deck2);
                } else {
                    deck1 = reverse(deck1);
                    deck1.offer(new Card(card1));
                    deck1.offer(new Card(card2));
                    deck1 = reverse(deck1);
                }
            }
            else {

                if (card1 < card2) {
                    deck2 = reverse(deck2);
                    deck2.offer(new Card(card1));
                    deck2.offer(new Card(card2));
                    deck2 = reverse(deck2);
                } else {
                    deck1 = reverse(deck1);
                    deck1.offer(new Card(card1));
                    deck1.offer(new Card(card2));
                    deck1 = reverse(deck1);
                }

                if (kol == 106) {
                    break;
                }
            }
        }

        if (kol == 106) {
            System. out.println("botva");
        } else {
            if (deck1.peek() == null)
                System.out.println("second " + kol);
            else
                System.out.println("first " + kol);
        }
    }

}
