package cartadagioco;

public class Carta {
  private Seme seme;
  private int valore;

  public Carta(Seme inputSeme, int inputValore) {
    this.seme = inputSeme;
    this.valore = inputValore;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (obj.getClass() != this.getClass()) {
      return false;
    }

    final Carta carta2 = (Carta) obj;
    boolean firstCheck = this.seme.equals(carta2.seme);
    if (firstCheck) {
      return (this.valore == carta2.valore);
    }
    return false;
  }

  public String toString() {
    return this.seme.toString() + "|" + String.valueOf(this.valore);
  }
}
