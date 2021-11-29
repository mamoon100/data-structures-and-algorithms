package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VertexTest {
  Vertex<String> stringVertex = new Vertex<>("String Vertex");
  Vertex<Integer> integerVertex = new Vertex<>(1024);
  List<String> stringList = new ArrayList<>();


  @Test
  public void initializeVertexTest() {
    //can initialize multiple Vertices with different generic type
    stringList.add("First ele");
    stringList.add("Second ele");
    Vertex<List<String>> listVertex = new Vertex<>(stringList);
    // check the value
    assertEquals("There was problem getting the value in String generic value","String Vertex",stringVertex.getValue());
    assertEquals("There was problem getting the value in Integer generic value",(Integer) 1024, integerVertex.getValue());
    assertEquals("There was problem getting the value in List generic value", stringList, listVertex.getValue());
  }

  @Test
  public void setterAndGetterTest() {
    stringVertex.setValue("Setter");
    assertEquals("There was problem in the setter and gitter ", stringVertex.getValue(),"Setter");
    integerVertex.setValue(50);
    assertEquals("There was problem in the setter of the integer", integerVertex.getValue(),(Integer) 50);
  }

}
