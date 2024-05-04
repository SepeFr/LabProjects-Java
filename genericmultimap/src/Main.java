package genericmultimap.src;

import java.util.Map;
import java.util.function.Function;

/** Main */
public class Main {

  public static void main(String[] args) {
    MultiMap<String, Integer> multiMap = new MultiMap<String, Integer>();

    multiMap.put("A", 1);
    multiMap.put("A", 2);
    multiMap.put("B", 3);
    multiMap.put("C", 3);

    Function<Map.Entry<String, Integer>, String> function = entry -> entry.getValue() + " Euro";

    MultiMap<String, String> test = multiMap.transformToMultiMap(function);

    Function<Map.Entry<String, Integer>, Integer> function2 = entry -> entry.getValue() * 2;

    multiMap.mapEach(function2);
    System.out.println(multiMap);

    for (MultiMap<String, Integer>.Element<String, Integer> elemento : multiMap) {
      System.out.println(elemento);
    }
  }
}
