package disneymarvel;

public class Magneto extends MarvelCharacter implements SuperHero {
  private static String THE_THING_NAME = "Magneto";
  private static String THE_THING_CATCHPHRASE = "Surrend to gravity!";
  private static String THE_THING_THREATEN_STRING = " MADE IN HEAVEN";

  Magneto() {
    super(THE_THING_NAME, THE_THING_CATCHPHRASE, THE_THING_THREATEN_STRING);
  }

  @Override
  public void attack() {
    System.out.println("Lasers, Pew Pew!");
  }

  public static void main(String[] args) {
    Magneto magnetoTest = new Magneto();

    magnetoTest.joke();

    magnetoTest.threaten();

    magnetoTest.attack();
  }
}
