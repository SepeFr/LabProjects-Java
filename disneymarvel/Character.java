package disneymarvel;

abstract class Character {
  private String name;

  Character(String name) {
    setName(name);
  }

  public void setName(String nome) {
    this.name = nome;
  }

  public String getName() {
    return name;
  }
}
