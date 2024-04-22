package disneymarvel;

public class Goofy extends DisneyCharacter {
  private static String GOOFY_NAME = "Goofy";
  private static String GOOFY_CATCHPHRASE = "Wha-hoo!";
  private static String GOOFY_MESSUP_PHRASE = " Forgot to add +c after integration ";

  private static String SUPER_GOOFY_NAME = "Super Goofy";
  private static String SUPER_GOOFY_CATCHPHRASE = " Super Wha-hoo!";
  private static String SUPER_GOOFY_MESSUP_PHRASE =
      " ... there are no mistakes, Super Goofy integrated the dircihlet's " + "function!";

  private AlterEgo<Goofy> state = new NormalState();

  Goofy() {
    super(GOOFY_NAME, GOOFY_CATCHPHRASE, GOOFY_MESSUP_PHRASE);
  }

  void setState(AlterEgo<Goofy> new_state) {
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

  public void giggle() {
    System.out.println("Goofy cannot hold it anymore");
    for (int i = 0; i < 3; i++) {
      this.joke();
    }
  }

  public static void main(String[] args) {
    Goofy goofyTest = new Goofy();
    goofyTest.joke();

    goofyTest.assumeSecretIdentity();
    goofyTest.joke();

    goofyTest.assumeSecretIdentity();
    goofyTest.messUp();

    goofyTest.assumePublicIdentity();
    goofyTest.messUp();

    goofyTest.giggle();
  }

  class NormalState implements AlterEgo<Goofy> {
    @Override
    public void assumePublicIdentity(Goofy context) {
      System.out.println("I'm Already Goofy");
    }

    @Override
    public void assumeSecretIdentity(Goofy context) {
      System.out.println("Switching to SuperGoofy, Ready do Fight!");
      context.setName(SUPER_GOOFY_NAME);
      context.setCatchphrase(SUPER_GOOFY_CATCHPHRASE);
      context.setMessUpPhrase(SUPER_GOOFY_MESSUP_PHRASE);

      context.setState(new SuperGoofy());
    }
  }

  class SuperGoofy implements AlterEgo<Goofy>, SuperHero {
    @Override
    public void assumePublicIdentity(Goofy context) {
      System.out.println("Mission Completed, Going Back to Goofy");
      context.setName(GOOFY_NAME);
      context.setCatchphrase(GOOFY_CATCHPHRASE);
      context.setMessUpPhrase(GOOFY_MESSUP_PHRASE);

      context.setState(new NormalState());
    }

    @Override
    public void assumeSecretIdentity(Goofy context) {
      System.out.println("I'm Already SuperGoofy!");
    }

    @Override
    public void attack() {
      System.out.println("GUM GUM PISTOL");
    }
  }
}
