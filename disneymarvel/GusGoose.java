package disneymarvel;

public class GusGoose extends DisneyCharacter {
  private static String GUS_GOOSE_NAME = "Gus Goose";
  private static String GUS_GOOSE_CATCHPHRASE = "I'm Hungry!";
  private static String GUS_GOOSE_MESSUP_PHRASE = "Ate the cake again";

  private static String SUPER_GUS_GOOSE_NAME = "Super Gus Goose";
  private static String SUPER_GUS_GOOSE_CATCHPHRASE = "I'm Hungry For Victory!";
  private static String SUPER_GUS_GOOSE_MESSUP_PHRASE =
      "... There are no mistakes, he is buffing himsealf with a medium rare " + "steak";

  private AlterEgo<GusGoose> state = new NormalState();

  GusGoose() {
    super(GUS_GOOSE_NAME, GUS_GOOSE_CATCHPHRASE, GUS_GOOSE_MESSUP_PHRASE);
  }

  void setState(AlterEgo<GusGoose> new_state) {
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

  public void overAte() {
    System.out.println(
        this.getName() + " Is eating a Very Spicy meal, HIS STATS ARE NOW OVER 9000!");
  }

  public static void main(String[] args) {
    GusGoose goofyTest = new GusGoose();
    goofyTest.joke();

    goofyTest.assumeSecretIdentity();
    goofyTest.joke();

    goofyTest.assumeSecretIdentity();
    goofyTest.messUp();

    goofyTest.assumePublicIdentity();
    goofyTest.messUp();

    goofyTest.overAte();
  }

  class NormalState implements AlterEgo<GusGoose> {
    @Override
    public void assumePublicIdentity(GusGoose context) {
      System.out.println("I'm Already GusGoose");
    }

    @Override
    public void assumeSecretIdentity(GusGoose context) {
      System.out.println("Switching to SuperGusGoose, Ready do Fight!");
      context.setName(SUPER_GUS_GOOSE_NAME);
      context.setCatchphrase(SUPER_GUS_GOOSE_CATCHPHRASE);
      context.setMessUpPhrase(SUPER_GUS_GOOSE_MESSUP_PHRASE);
      context.setState(new SuperGusGoose());
    }
  }

  class SuperGusGoose implements AlterEgo<GusGoose>, SuperHero {
    @Override
    public void assumePublicIdentity(GusGoose context) {
      System.out.println("Mission Completed, Going Back to GusGoose");
      context.setName(GUS_GOOSE_NAME);
      context.setCatchphrase(GUS_GOOSE_CATCHPHRASE);
      context.setMessUpPhrase(GUS_GOOSE_MESSUP_PHRASE);
      context.setState(new NormalState());
    }

    @Override
    public void assumeSecretIdentity(GusGoose context) {
      System.out.println("I'm Already SuperGusGoose!");
    }

    @Override
    public void attack() {
      System.out.println("Er Cazzotto della vendetta");
    }
  }
}
