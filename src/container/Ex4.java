package container;

import java.util.Stack;
import java.util.Scanner;

public class Ex4 {

    static void outStack (Stack st) {
        while (st.empty() == false)
            System.out.print (st.pop()+" ");
    }

    static Stack reverse (Stack st) {
        Stack newSt = new Stack();
        while (st.empty() == false) {
            newSt.push(st.pop());
        }
        return newSt;
    }

    public static void main(String[] args) {
        final int N = 5;

        Scanner s = new Scanner(System.in);

        Stack<Card> deck1 = new Stack<> ();
        Stack<Card> deck2 = new Stack<> ();

        int v1[] = new int[N];

        System.out.print("Карточная игра 'пьяница'.\n");
        System.out.print("Введите колоду первого игрока: ");

        for (int i = 0; i < N; i++) {
            v1[i] = s.nextInt();
        }

        for (int i = 0; i < N; i++) {
            deck1.push(new Card(v1[N-i-1]));
        }

        int v2[] = new int[N];

        System.out.print("Введите колоду второго игрока: ");

        for (int i = 0; i < N; i++) {
            v2[i] = s.nextInt();
        }

        for (int i = 0; i < N; i++) {
            deck2.push(new Card(v2[N-i-1]));
        }

        int kol = 0;

        while (deck1.empty() == false && deck2.empty() == false) {

            kol++;
            int card1 = deck1.pop().getValue();
            int card2 = deck2.pop().getValue();

            if ((card1 == 0 && card2 == 9) || (card1 == 9 && card2 == 0)) {
                if (card1 > card2) {
                    deck2 = reverse(deck2);
                    deck2.push(new Card(card1));
                    deck2.push(new Card(card2));
                    deck2 = reverse(deck2);
                } else {
                    deck1 = reverse(deck1);
                    deck1.push(new Card(card1));
                    deck1.push(new Card(card2));
                    deck1 = reverse(deck1);
                }
            }
            else {

                if (card1 < card2) {
                    deck2 = reverse(deck2);
                    deck2.push(new Card(card1));
                    deck2.push(new Card(card2));
                    deck2 = reverse(deck2);
                } else {
                    deck1 = reverse(deck1);
                    deck1.push(new Card(card1));
                    deck1.push(new Card(card2));
                    deck1 = reverse(deck1);
                }

                if (kol == 106) {
                    break;
                }
            }
        }

        if (kol == 106) {
            System. out.println("Ничья, игра длится слишком долго.");
        } else {
            if (deck1.empty() == true)
                System.out.println("Победил второй игрок за " + kol + " ходов.");
            else
                System.out.println("Победил первый игрок за " + kol + " ходов.");
        }
    }
}

