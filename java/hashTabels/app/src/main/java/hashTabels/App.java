/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hashTabels;

import java.util.Arrays;

public class App {

  public static void main(String[] args) {
    System.out.print("Let's Declare a new Hash Table that we implement and print it  =>  ");
    HashTable<String, String> hashTable = new HashTable<>();
    System.out.println(hashTable);
    System.out.println("As you can see the Hash Table is currently empty so let's add some values");
    System.out.println("Let's add the following values to the Hash Table {key1,value1} and {key2,value2}");
    hashTable.add("key1", "value1");
    hashTable.add("key2", "value2");
    System.out.println("Let's print the Hash Table again =>> " + hashTable);
    System.out.println("Let's get the value for key1 => " + hashTable.get("key1"));
    System.out.println("Let's check if the Table has key2 =>  " + hashTable.contains("key2"));
    System.out.println("Let's check for key3 =>> " + hashTable.contains("key3"));
    System.out.println("Let's see how many items are inside the table right now  =>>  " + hashTable.size());
    System.out.println("Let's check it's full capacity =>> " + hashTable.capacity());
    System.out.println("You will notice that the capacity is 2 which will the hash table start from capacity of 1 \nand will get bigger by 2 every time the size reach the capacity");
    System.out.println("============Repeated Word Method===========");
    System.out.println("Let's Test the string \n'It was a queer, sultry summer, the summer they electrocuted the Rosenbergs, and I didn’t know what I was doing in New York...' \non the repeated word method and see the most repeated word among the words =>>  "+repeatedWord("It was a queer, sultry summer, the summer they electrocuted the Rosenbergs, and I didn’t know what I was doing in New York..."));
  }

  public static String repeatedWord(String str) {
    String[] words = str.toLowerCase().split(" ");
    HashTable<String, Integer> hashTable = new HashTable<>();
    int max = 0;
    String repeatedWord = "";
    for (String word : words) {
      //clean the word from punctuation
      word = word.replaceAll("[^a-zA-Z0-9]", "").trim();
      if (hashTable.contains(word)) hashTable.add(word, hashTable.get(word) + 1);
      else hashTable.add(word, 1);
      if (hashTable.get(word) > max) {
        max = hashTable.get(word);
        repeatedWord = word;
      }
    }

    return repeatedWord;
  }
}