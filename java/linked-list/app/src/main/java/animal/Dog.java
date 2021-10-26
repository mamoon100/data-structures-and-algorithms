package animal;

public class Dog extends Animal {
  private final String type = "dog";

  public Dog(String name, String color, int age) {
    super(name, color, age, "dog");
  }

  public String getType() {
    return type;
  }
}
