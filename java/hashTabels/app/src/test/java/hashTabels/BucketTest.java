package hashTabels;

import org.junit.Test;
import static org.junit.Assert.*;

public class BucketTest {

  @Test
  public void testBucket() {
    Bucket<String,String> bucket = new Bucket<>("Yes","No");
    assertEquals("Yes",bucket.getKey());
    assertEquals("No",bucket.getValue());
  }
}
