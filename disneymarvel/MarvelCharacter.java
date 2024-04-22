package disneymarvel;

public class MarvelCharacter extends Character {
  private String catchphrase;
  private String threatenString;

  private static final String DEFAULT_NAME = "MarvelCharacter";
  private static final String DEFAULT_CATCHPHRASE = "TheFunnyJoke";
  private static final String DEFAULT_THREATEN = "TheNotSoFunnyAction";

  MarvelCharacter(String nome, String catchphrase, String messUpPhrase) {
    super(nome);
    this.setThreatenString(messUpPhrase);
    this.setCatchphrase(catchphrase);
  }

  MarvelCharacter() {
    this(DEFAULT_NAME, DEFAULT_CATCHPHRASE, DEFAULT_THREATEN);
  }

  void joke() {
    System.out.println(catchphrase);
  }

  void threaten() {
    System.out.println("I WILL " + this.getThreatenString() + "!");
  }

  public String getCatchphrase() {
    return catchphrase;
  }

  public String getThreatenString() {
    return threatenString;
  }

  public void setCatchphrase(String catchphrase) {
    this.catchphrase = catchphrase;
  }

  public void setThreatenString(String threatenString) {
    this.threatenString = threatenString;
  }
}
