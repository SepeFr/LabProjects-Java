package genericmultimap.src;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultiMap<K, V> implements Iterable<MultiMap<K, V>.Element<K, V>> {

  class Element<T, S> {
    private final T key;
    private final S value;

    Element(T key, S value) {
      this.key = key;
      this.value = value;
    }

    public T getKey() {
      return key;
    }

    public S getValue() {
      return value;
    }

    @Override
    public String toString() {
      return ("Key : " + this.getKey().toString() + " - Value : " + this.getValue().toString());
    }
  }

  class ElementIterator implements Iterator<Element<K, V>> {
    private Iterator<Entry<K, ArrayList<V>>> mapIterator = multiMap.entrySet().iterator();
    private Entry<K, ArrayList<V>> currentEntry;
    private Iterator<V> valueIterator;

    @Override
    public boolean hasNext() {
      if ((valueIterator != null && valueIterator.hasNext()) || mapIterator.hasNext()) {
        return true;
      }
      return false;
    }

    @Override
    public MultiMap<K, V>.Element<K, V> next() {
      if (valueIterator == null || !valueIterator.hasNext()) {
        if (!mapIterator.hasNext()) {
          throw new NoSuchElementException();
        }
        currentEntry = mapIterator.next();
        valueIterator = currentEntry.getValue().iterator();
      }
      return new Element<>(currentEntry.getKey(), valueIterator.next());
    }
  }

  private HashMap<K, ArrayList<V>> multiMap = new HashMap<K, ArrayList<V>>();

  @Override
  public Iterator<MultiMap<K, V>.Element<K, V>> iterator() {
    return new ElementIterator();
  }

  public void put(K key, V value) {
    List<V> currentValues = this.keyValueExists(key);
    currentValues.add(value);
  }

  public void put(K key, List<V> values) {
    List<V> currentValues = this.keyValueExists(key);
    currentValues.addAll(values);
  }

  public void putAll(MultiMap<K, V> sourceMap) {
    for (Map.Entry<K, ArrayList<V>> element : sourceMap.getEntrySet()) {
      multiMap.put(element.getKey(), new ArrayList<>(element.getValue()));
    }
  }

  public void removeAll(MultiMap<K, V> sourceMap) {
    for (Map.Entry<K, ArrayList<V>> element : sourceMap.getEntrySet()) {
      this.remove(element.getKey());
    }
  }

  public void remove(K key) {
    this.multiMap.remove(key);
  }

  public Set<V> get(K key) {
    ArrayList<V> list = multiMap.get(key);
    if (list == null) {
      return Collections.emptySet();
    }

    Set<V> setElements = new HashSet<V>(list);
    return setElements;
  }

  public Set<V> get(K key, Predicate<V> predicate) {
    Set<V> setElements = this.get(key);
    return setElements.stream().filter(predicate).collect(Collectors.toSet());
  }

  public Stream<V> getValuesStream() {
    return this.getEntrySet().stream().flatMap(entry -> entry.getValue().stream());
  }

  public ArrayList<V> values() {
    Stream<V> stream = getValuesStream();
    return stream.collect(Collectors.toCollection(ArrayList::new));
  }

  public HashSet<V> valuesSet() {
    Stream<V> stream = getValuesStream();
    return stream.collect(Collectors.toCollection(HashSet::new));
  }

  public Set<Entry<K, ArrayList<V>>> getEntrySet() {
    Set<Entry<K, ArrayList<V>>> entrySet = new HashSet<>();
    for (Entry<K, ArrayList<V>> entry : multiMap.entrySet()) {
      entrySet.add(
          new AbstractMap.SimpleEntry<>(entry.getKey(), new ArrayList<>(entry.getValue())));
    }
    return entrySet;
  }

  public <Z> MultiMap<K, Z> transformToMultiMap(Function<Map.Entry<K, V>, Z> trasformer) {
    MultiMap<K, Z> trasformed = new MultiMap<K, Z>();
    for (Map.Entry<K, ArrayList<V>> entry : multiMap.entrySet()) {
      ArrayList<Z> trasformedValues = new ArrayList<>();
      for (V value : entry.getValue()) {
        Z newValue = trasformer.apply(new AbstractMap.SimpleEntry<>(entry.getKey(), value));
        trasformedValues.add(newValue);
      }
      trasformed.multiMap.put(entry.getKey(), trasformedValues);
    }
    return trasformed;
  }

  public void mapEach(Function<Map.Entry<K, V>, V> transformer) {
    for (Map.Entry<K, ArrayList<V>> entry : multiMap.entrySet()) {
      ArrayList<V> newValues = new ArrayList<>();
      for (V value : entry.getValue()) {
        V newValue = transformer.apply(new AbstractMap.SimpleEntry<>(entry.getKey(), value));
        newValues.add(newValue);
      }
      entry.setValue(newValues);
    }
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();

    for (Map.Entry<K, ArrayList<V>> element : multiMap.entrySet()) {
      sb.append("Key  : " + element.getKey() + " Value " + element.getValue() + "\n");
    }

    return sb.toString();
  }

  public HashMap<K, ArrayList<V>> getMultiMap() {
    return multiMap;
  }

  public void setMultiMap(HashMap<K, ArrayList<V>> multiMap) {
    this.multiMap = multiMap;
  }

  private List<V> keyValueExists(K key) {
    return this.multiMap.computeIfAbsent(key, _key -> new ArrayList<>());
  }
}
