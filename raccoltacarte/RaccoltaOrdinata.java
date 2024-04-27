package raccoltacarte;

import java.util.TreeSet;

public class RaccoltaOrdinata {
  private TreeSet<Canzone> raccolta = new TreeSet<Canzone>();

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Lista Delle Canzoni:\n");
    int index = 1;
    for (Canzone canzone : this.raccolta) {
      sb.append(index++ + ") " + canzone.toString() + "\n");
    }
    return sb.toString();
  }

  public void addCanzone(String name, String author) {
    this.raccolta.add(new Canzone(name, author));
  }

  public void addCanzone(Canzone canzone) {
    this.raccolta.add(canzone);
  }

  public static void main(String[] args) {
    RaccoltaOrdinata raccoltaOrdinata = new RaccoltaOrdinata();

    raccoltaOrdinata.addCanzone(new Canzone("Gino", "BuonVino"));
    raccoltaOrdinata.addCanzone(new Canzone("Gino", "BuonVino_Remix"));
    raccoltaOrdinata.addCanzone(new Canzone("MioZio", "BuonVinoBianco"));
    raccoltaOrdinata.addCanzone(new Canzone("Gino", "AricciaCasaMia"));

    System.out.println(raccoltaOrdinata);
  }
}
