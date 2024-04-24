package raccoltacarte;

import java.util.HashSet;

public class Raccolta extends HashSet<Canzone> {
  public static void main(String[] args) {
    Raccolta raccolta = new Raccolta();
    raccolta.add(new Canzone("Gino", "BuonVino"));
    raccolta.add(new Canzone("Gin8", "BuonVino_Remix"));
    raccolta.add(new Canzone("MioZio", "BuonVinoBianco"));

    System.out.println(raccolta.toString());
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
