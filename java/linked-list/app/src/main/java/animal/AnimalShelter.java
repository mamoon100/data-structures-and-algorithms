package animal;

import linked.list.Node;
import stack.Stack;

public class AnimalShelter {
  private Stack<Animal> dogs;
  private Stack<Animal> cats;
  private Stack<Animal> animals;


  public AnimalShelter() {
    dogs = new Stack<>();
    cats = new Stack<>();
    animals = new Stack<>();
  }

  public void enqueue(Animal animal) {
    if (animal.getClass().getName().equals("animal.Dog")) dogs.push(animal);
    else cats.push(animal);
    animals.push(animal);
  }

  public Animal dequeue(String pref) {
    Animal temp = null;
    if (pref.equals("dog")) {
      this.dogs = reverse(this.dogs);
      temp = this.dogs.pop();
      this.dogs = reverse(this.dogs);
      this.animals = reverse(this.animals);
      if (this.animals.getTop().value.getType().equals("dog")) {
        this.animals.setTop(this.animals.getTop().nextPointer);
      } else {
        Node<Animal> current = this.animals.getTop();
        while (current.value.getType().equals("dog")) {
          current = current.nextPointer;
        }
        current.nextPointer = current.nextPointer.nextPointer;
      }
      this.animals = reverse(this.animals);
    } else if (pref.equals("cat")) {
      this.cats = reverse(this.cats);
      temp = this.cats.pop();
      this.cats = reverse(this.cats);
      this.animals = reverse(this.animals);
      if (this.animals.getTop().value.getType().equals("cat")) {
        this.animals.setTop(this.animals.getTop().nextPointer);
      } else {
        Node<Animal> current = this.animals.getTop();
//      if (current.value.getType().equals("cat")) this.animals.setTop(current);

        while (!current.nextPointer.value.getType().equals("cat")) {
          current = current.nextPointer;
        }
        current.nextPointer = current.nextPointer.nextPointer;
      }
      this.animals = reverse(this.animals);
    }
    return temp;
  }

  public Animal dequeue() {
    Animal temp;
    this.animals = reverse(this.animals);
    temp = this.animals.pop();
    this.animals = reverse(this.animals);
    if (temp.getType().equals("dog")) {
      this.dogs = reverse(this.dogs);
      this.dogs.pop();
      this.dogs = reverse(this.dogs);
    } else {
      this.cats = reverse(this.cats);
      this.cats.pop();
      this.cats = reverse(this.cats);
    }
    return temp;
  }

  private Stack<Animal> reverse(Stack<Animal> animalStack) {
    Stack<Animal> temp = new Stack<>();
    Node<Animal> current = animalStack.getTop();
    while (current != null) {
      temp.push(current.value);
      current = current.nextPointer;
    }
    return temp;
  }

  @Override
  public String toString() {
    String msg = "";
    msg += "Front =>";
    this.animals = reverse(this.animals);
    Node<Animal> current = this.animals.getTop();
    while (current != null) {
      msg += "{" + current.value.getType() + ":" + current.value.getName() + "} =>";
      current = current.nextPointer;
    }
    msg += " Null";
    this.animals = reverse(this.animals);

    return msg;
  }

  public Stack<Animal> getAnimals() {
    return reverse(animals);
  }
}
