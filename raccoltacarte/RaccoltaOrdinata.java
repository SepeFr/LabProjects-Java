package raccoltacarte;

import java.util.TreeSet;

public class RaccoltaOrdinata extends TreeSet<Canzone> {
  public static void main(String[] args) {
    Raccolta raccoltaOrdinata = new Raccolta();

    raccoltaOrdinata.add(new Canzone("Gino", "BuonVino"));
    raccoltaOrdinata.add(new Canzone("Gino", "BuonVino_Remix"));
    raccoltaOrdinata.add(new Canzone("MioZio", "BuonVinoBianco"));
    raccoltaOrdinata.add(new Canzone("Gino", "AricciaCasaMia"));

    System.out.println(raccoltaOrdinata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Lista Delle Canzoni:\n");
    int index = 1;
    for (Canzone canzone : this) {
      sb.append(index++ + ") " + canzone.toString() + "\n");
    }
    return sb.toString();
  }
}
