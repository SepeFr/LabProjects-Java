package disneymarvel;

/** AlterEgo */
public interface AlterEgo<C> {

  void assumeSecretIdentity(C context);

  void assumePublicIdentity(C context);
}
