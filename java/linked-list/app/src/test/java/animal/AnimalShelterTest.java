package animal;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalShelterTest {

  @Test
  public void shelterTest() {
    Cat cat = new Cat("coco", "White", 2);
    Dog dog = new Dog("boby", "brown", 4);
    Cat cat2 = new Cat("momo", "black", 5);
    Dog dog2 = new Dog("dodo", "brown", 4);
    Dog dog3 = new Dog("soso", "brown", 4);
    Cat cat3 = new Cat("psps", "Ssss", 5);
    AnimalShelter animalShelter = new AnimalShelter();
    animalShelter.enqueue(cat);
    animalShelter.enqueue(dog);
    animalShelter.enqueue(cat2);
    animalShelter.enqueue(dog2);
    animalShelter.enqueue(dog3);
    animalShelter.enqueue(cat3);
    assertEquals("The first item name should be cocc", animalShelter.getAnimals().getTop().value.getName(), "coco");
    assertEquals("The first dequeue without pref should also mutch coco", animalShelter.dequeue().getName(), "coco");
    assertEquals("The duqueu for cat should match momo", animalShelter.dequeue("cat").getName(), "momo");
    assertEquals("The first animal should be boby", animalShelter.getAnimals().getTop().value.getName(), "boby");
  }
}
