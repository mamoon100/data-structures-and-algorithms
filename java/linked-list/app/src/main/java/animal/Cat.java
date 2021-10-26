package animal;

public class Cat extends Animal {
  private final String type = "cat";

  public Cat(String name, String color, int age) {
    super(name, color, age, "cat");
  }

  public String getType() {
    return type;
  }
}
