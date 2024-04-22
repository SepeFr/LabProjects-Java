package disneymarvel;

public class PeterParker extends MarvelCharacter {
  private static String PETER_PARKER_NAME = "Peter Parker";
  private static String PETER_PARKER_CATCHPHRASE = "Get Ready For Spiderman!";
  private static String PETER_PARKER_THREATEN_STRING = " Made you Laugh :) ";

  private static String SPIDERMAN_NAME = "Spiderman";
  private static String SPIDERMAN_CATCHPHRASE = "My Spidersense Never Lies!";
  private static String SPIDERMAN_THREATEN_STRING = " Throwed spiderwebs at you! ";

  private AlterEgo<PeterParker> state = new NormalState();

  PeterParker() {
    super(PETER_PARKER_NAME, PETER_PARKER_CATCHPHRASE, PETER_PARKER_THREATEN_STRING);
  }

  void setState(AlterEgo<PeterParker> new_state) {
    this.state = new_state;
  }

  public void assumePublicIdentity() {
    state.assumePublicIdentity(this);
  }

  public void assumeSecretIdentity() {
    state.assumeSecretIdentity(this);
  }

  public void attack() {
    if (state instanceof SuperHero) {
      ((SuperHero) state).attack();
    } else {
      System.out.println("I Can't attack in this state!");
    }
  }

  public static void main(String[] args) {
    PeterParker goofyTest = new PeterParker();
    goofyTest.joke();

    goofyTest.assumeSecretIdentity();
    goofyTest.joke();

    goofyTest.assumeSecretIdentity();
    goofyTest.threaten();

    goofyTest.assumePublicIdentity();
    goofyTest.threaten();

  }

  class NormalState implements AlterEgo<PeterParker> {
    @Override
    public void assumePublicIdentity(PeterParker context) {
      System.out.println("I'm Already PeterParker");
    }

    @Override
    public void assumeSecretIdentity(PeterParker context) {
      System.out.println("Switching to Spiderman, Ready do Fight!");
      context.setName(SPIDERMAN_NAME);
      context.setCatchphrase(SPIDERMAN_CATCHPHRASE);
      context.setThreatenString(SPIDERMAN_THREATEN_STRING);
      context.setState(new Spiderman());
    }
  }

  class Spiderman implements AlterEgo<PeterParker>, SuperHero {
    @Override
    public void assumePublicIdentity(PeterParker context) {
      System.out.println("Mission Completed, Going Back to PeterParker");
      context.setName(PETER_PARKER_NAME);
      context.setCatchphrase(PETER_PARKER_CATCHPHRASE);
      context.setThreatenString(PETER_PARKER_THREATEN_STRING);
      context.setState(new NormalState());
    }

    @Override
    public void assumeSecretIdentity(PeterParker context) {
      System.out.println("I'm Already Spiderman!");
    }

    @Override
    public void attack() {
      System.out.println("Shooting Webs!");
    }
  }
}
