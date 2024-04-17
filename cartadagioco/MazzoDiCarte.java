package cartadagioco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.IntStream;

public class MazzoDiCarte implements Iterable<Carta> {
  private ArrayList<Carta> carte;
  private Iterator<Carta> iteratoreDiCarte;

  public MazzoDiCarte() {
    carte = new ArrayList<Carta>();
    for (Seme seme : Seme.values()) {
      IntStream.range(1, 13)
          .forEachOrdered(
              numero -> {
                carte.add(new Carta(seme, numero));
              });
    }
  }

  public ArrayList<Carta> getCarte() {
    return carte;
  }

  @Override
  public Iterator<Carta> iterator() {
    return new Iteratore();
  }

  public void mischia() {
    Collections.shuffle(carte);
  }

  public Carta prossimaCarta() {
    if (iteratoreDiCarte == null) {
      iteratoreDiCarte = new Iteratore();
    }
    return iteratoreDiCarte.next();
  }

  public boolean esisteProssimaCarta() {
    if (iteratoreDiCarte == null) {
      iteratoreDiCarte = new Iteratore();
    }
    return iteratoreDiCarte.hasNext();
  }

  private class Iteratore implements Iterator<Carta> {
    private int index;

    @Override
    public boolean hasNext() {
      return index < 48;
    }

    @Override
    public Carta next() {
      return carte.get(index++);
    }
  }

  public static void main(String[] args) {
    MazzoDiCarte mazzo = new MazzoDiCarte();
    mazzo.mischia();

    for (Carta c : mazzo) {
      System.out.println(c);
    }

  }
}
