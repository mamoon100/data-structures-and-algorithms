package animal;

public abstract class Animal {
  private String name;
  private String color;
  private int age;
  private String type;

  public Animal(String name, String color, int age, String type) {
    this.name = name;
    this.color = color;
    this.age = age;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getType() {
    return type;
  }
}
