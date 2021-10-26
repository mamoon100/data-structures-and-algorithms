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

    } else if (pref.equals("cat")) {
      this.cats = reverse(this.cats);
      temp = this.cats.pop();
      this.cats = reverse(this.cats);
      this.animals = reverse(this.animals);
      Node<Animal> current = this.animals.getTop();

    }
    return temp;
  }

//  public Animal dequeue() {
//
//    Animal temp = null;
//    while ()
//
//
//      return temp;
//  }

  private Stack<Animal> reverse(Stack<Animal> animalStack) {
    Stack<Animal> temp = new Stack<>();
    Node<Animal> current = animalStack.getTop();
    while (current != null) {
      temp.push(current.value);
      current = current.nextPointer;
    }
    return temp;
  }
}
