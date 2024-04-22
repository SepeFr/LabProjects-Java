package disneymarvel;

public class DonaldDuck extends DisneyCharacter {
  private static String DONALD_DUCK_NAME = "Donald Duck";
  private static String DONALD_DUCK_CATCHPHRASE = "Quack Quack";
  private static String DONALD_DUCK_MESSUP_PHRASE = " fell to the ground ";

  private static String PAPERINIK_NAME = "Paperinik";
  private static String PAPERINIK_CATCHPHRASE = " Not So Quack Quack My Dear!";
  private static String PAPERINIK_MESSUP_PHRASE = " ... there are no mistakes in this world";

  private AlterEgo<DonaldDuck> state = new NormalState();

  DonaldDuck() {
    super(DONALD_DUCK_NAME, DONALD_DUCK_CATCHPHRASE, DONALD_DUCK_MESSUP_PHRASE);
  }

  void setState(AlterEgo<DonaldDuck> new_state) {
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
    DonaldDuck donaldTest = new DonaldDuck();
    donaldTest.joke();

    donaldTest.assumeSecretIdentity();
    donaldTest.joke();

    donaldTest.assumeSecretIdentity();
    donaldTest.messUp();

    donaldTest.assumePublicIdentity();
    donaldTest.messUp();
  }

  class NormalState implements AlterEgo<DonaldDuck> {
    @Override
    public void assumePublicIdentity(DonaldDuck context) {
      System.out.println("I'm Already DonaldDuck");
    }

    @Override
    public void assumeSecretIdentity(DonaldDuck context) {
      System.out.println("Switching to Paperinik, Ready do Fight!");
      context.setName(PAPERINIK_NAME);
      context.setCatchphrase(PAPERINIK_CATCHPHRASE);
      context.setMessUpPhrase(PAPERINIK_MESSUP_PHRASE);
      context.setState(new Paperinik());
    }
  }

  class Paperinik implements AlterEgo<DonaldDuck>, SuperHero {
    @Override
    public void assumePublicIdentity(DonaldDuck context) {
      System.out.println("Mission Completed, Going Back to DonaldDuck");
      context.setName(DONALD_DUCK_NAME);
      context.setCatchphrase(DONALD_DUCK_CATCHPHRASE);
      context.setMessUpPhrase(DONALD_DUCK_MESSUP_PHRASE);

      context.setState(new NormalState());
    }

    @Override
    public void assumeSecretIdentity(DonaldDuck context) {
      System.out.println("I'm Already Paperinik!");
    }

    @Override
    public void attack() {
      System.out.println("Pugno");
    }
  }
}
