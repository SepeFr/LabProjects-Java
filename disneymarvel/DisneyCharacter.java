package disneymarvel;

public class DisneyCharacter extends Character {
  private String catchphrase;
  private String messUpPhrase;

  private static final String DEFAULT_NAME = "DisneyCharacter";
  private static final String DEFAULT_CATCHPHRASE = "TheFunnyJoke";
  private static final String DEFAULT_MESS_UP_PHRASE = "TheFunnyAction";

  DisneyCharacter(String nome, String catchphrase, String messUpPhrase) {
    super(nome);
    this.setMessUpPhrase(messUpPhrase);
    this.setCatchphrase(catchphrase);
  }

  DisneyCharacter() {
    this(DEFAULT_NAME, DEFAULT_CATCHPHRASE, DEFAULT_MESS_UP_PHRASE);
  }

  void joke() {
    System.out.println(catchphrase);
  }

  void messUp() {
    System.out.println(
        "OH NO! " + this.getName().toUpperCase() + " JUST " + this.getMessUpPhrase() + "!");
  }

  public String getCatchphrase() {
    return catchphrase;
  }

  public String getMessUpPhrase() {
    return messUpPhrase;
  }

  public void setCatchphrase(String catchphrase) {
    this.catchphrase = catchphrase;
  }

  public void setMessUpPhrase(String messUpPhrase) {
    this.messUpPhrase = messUpPhrase.toUpperCase();
  }
}
