package raccoltacarte;

import java.util.HashSet;

public class Raccolta {
  private HashSet<Canzone> raccolta = new HashSet<Canzone>();

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
    Raccolta raccolta = new Raccolta();

    raccolta.addCanzone(new Canzone("Gino", "BuonVino"));
    raccolta.addCanzone("Gin8", "BuonVino_Remix");
    raccolta.addCanzone(new Canzone("MioZio", "BuonVinoBianco"));

    System.out.println(raccolta.toString());
  }
}
