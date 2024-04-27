package esercizi_2_4_lab;

import java.util.Random;
import java.util.function.*;

public class Main {
  public static void main(String[] args) {
    /*
     * Esercizio 2.4.1. Si definisca in una riga una variabile del tipo di
     * un’interfaccia
     * funzionale standard del package java.util.function e le si associ una
     * lambda (non un riferimento a metodo) che, dato in input un intero, ne
     * calcola il quadrato. Si scriva quindi una seconda riga per invocare il
     * metodo dell’interfaccia.
     */

    Function<Integer, Integer> es2_4_1 = k -> k * k;
    System.out.println(es2_4_1.apply(4));

    /*
     * Esercizio 2.4.2. Si definisca in una riga una variabile del tipo di
     * un’interfaccia
     * funzionale standard del package java.util.function e le si associ una
     * lambda (non un riferimento a metodo) che, data in input una stringa, la
     * stampi a video. Si scriva quindi una seconda riga per invocare il metodo
     * dell’interfaccia.
     */

    Consumer<String> es2_4_2_old = s -> System.out.println(s);
    es2_4_2_old.accept("Ciao Mondo");

    Consumer<String> es2_4_2 = System.out::println;
    es2_4_2.accept("Ciao Mondo");

    /*
     * Esercizio 2.4.3. Si definisca in una riga una variabile del tipo di
     * un’interfaccia
     * funzionale standard del package java.util.function e le si associ una
     * lambda (non un riferimento a metodo) che, senza prendendo in input una
     * stringa e un intero, restituisca un booleano che verifica se la stringa
     * `e della lunghezza pari all’intero fornito in input. Si scriva quindi una
     * seconda riga per invocare il metodo dell’interfaccia.
     */

    BiPredicate<String, Integer> es2_4_3 = (s, i) -> (s.length() == i);
    System.out.println(es2_4_3.test("ciao", 5));
    System.out.println(es2_4_3.test("ciao", 4));

    /*
     * Esercizio 2.4.4. Si definisca in una riga una variabile del tipo di
     * un’interfaccia
     * funzionale standard del package java.util.function e le si associ una
     * lambda (non un riferimento a metodo) che, senza prendere nulla in input,
     * restituisca un numero intero casuale. Si scriva quindi una seconda riga
     * per invocare il metodo dell’interfaccia.
     */

    Supplier<Integer> es_2_4_4 = () -> (int) (new Random().nextInt());
    System.out.println(es_2_4_4.get());
    /*
     * ^
     * | Mentall Illness :O
     */

    /*
     * Esercizio 2.4.5. Si definisca in una riga una variabile del tipo di
     * un’interfaccia
     * funzionale standard del package java.util.function e le si associ una
     * lambda (non un riferimento a metodo) che, prendendo in input una stringa,
     * restituisca
     * un booleano che verifica se la stringa `e vuota oppure no. Si scriva
     * quindi una seconda riga per invocare il metodo dell’interfaccia.
     */
    Predicate<String> es2_4_5 = String::isEmpty;
    System.out.println(es2_4_5.test(""));
    System.out.println(es2_4_5.test("Ciao Mondo"));

    /*
     * Esercizio 2.4.6. Progettare un’interfaccia funzionale ElaboraStringhe che
     * esponga un metodo elabora il quale, data in input una stringa,
     * restituisca un’altra stringa. Scrivere quindi le seguenti espressioni
     * lambda da assegnare alla riga ElaboraStringhe e = in modo tale che: •
     * l’espressione restituisca la rappresentazione sotto forma di stringa
     * della lunghezza della stringa in input; • l’espressione restituisca i
     * primi 5 caratteri della stringa o, se pi`u piccola, la stringa per
     * intero.
     */

    @FunctionalInterface
    interface ElaboraStringhe {
      String elabora(String input);
    }

    ElaboraStringhe es2_4_6 =
        s -> String.valueOf(s.length()) + " " + (s.length() > 5 ? s.substring(0, 5) : s);
    System.out.println(es2_4_6.elabora("Free Media Heck Yea"));
    System.out.println(es2_4_6.elabora("FMHY"));

    /*
     * Esercizio 2.4.7. Progettare un’interfaccia funzionale VerificaStringhe
     * che
     *
     * esponga un metodo verifica il quale, date in input due stringhe s1 e s2,
     * resti-
     * tuisca un booleano. Scrivere quindi le seguenti espressioni lambda da
     * assegnare
     *
     * alla riga VerificaStringhe v = in modo tale che:
     * • l’espressione restituisca true se s2 `e contenuto in s1, false
     * altrimenti;
     * • l’espressione restituisca true se la lunghezza di s1 `e
     * maggiore di quella di s2 ed s1 non contiene s2 come suffisso.
     */
    @FunctionalInterface
    interface VerificaStringhe {
      Boolean verifica(String s1, String s2);
    }
    VerificaStringhe es2_4_7_prima = String::contains;
    boolean sanity_check = es2_4_7_prima.verifica("Ciao Mondo", "Mondo");
    boolean sanity_check2 = es2_4_7_prima.verifica("Ciao Mondo", "mondo");
    System.out.println(sanity_check);
    System.out.println(sanity_check2);

    VerificaStringhe es2_4_7_seconda = (s1, s2) -> ((s1.length() > s2.length()) & !s1.endsWith(s2));
    boolean sanity_check3 = es2_4_7_seconda.verifica("Mondo", "Ciao");
    boolean sanity_check4 = es2_4_7_seconda.verifica("CiaoCiaoCiao", "Ciao");

    System.out.println(sanity_check3);
    System.out.println(sanity_check4);
  }
}
