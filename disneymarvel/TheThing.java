package disneymarvel;

public class TheThing extends MarvelCharacter implements SuperHero {
  private static String THE_THING_NAME = "The Thing";
  private static String THE_THING_CATCHPHRASE = "Rocking in the 90s!";
  private static String THE_THING_THREATEN_STRING = " Roll";

  TheThing() {
    super(THE_THING_NAME, THE_THING_CATCHPHRASE, THE_THING_THREATEN_STRING);
  }

  @Override
  public void attack() {
    System.out.println("Punching SomeThings!");
  }

  public static void main(String[] args) {
    TheThing theThingTest = new TheThing();

    theThingTest.joke();

    theThingTest.threaten();

    theThingTest.attack();
  }
}
