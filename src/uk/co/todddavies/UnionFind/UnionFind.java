package uk.co.todddavies.UnionFind;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class UnionFind<T> implements EquivalenceSetList<T> {

  private HashMap<T, Integer> locations;
  private ArrayList<T> elements;
  private int[] edges, sizes;
  
  public UnionFind(Collection<T> items) {
    this.elements = new ArrayList<>(items);
    this.locations = new HashMap<>(items.size());
    edges = new int[items.size()];
    sizes = new int[items.size()]; 
    int i = 0;
    for (T element : items) {
      edges[i] = i;
      sizes[i] = 1;
      locations.put(element, i);
      i++;
    }
  }
  
  @Override
  public void add(T a, T b) {
    T rootA = root(a), rootB = root(b);
    int aLoc = locations.get(rootA), bLoc = locations.get(rootB);
    if (sizes[aLoc] > sizes[bLoc]) {
      edges[bLoc] = aLoc;
      sizes[aLoc] += sizes[bLoc];
    } else {
      edges[aLoc] = bLoc;
      sizes[bLoc] += sizes[aLoc];
    }
  }

  @Override
  public T root(T a) {
    int i = edges[locations.get(a)];
    while (i != locations.get(a)) {
      a = elements.get(edges[i]);
      edges[i] = edges[edges[i]];
      i = edges[locations.get(a)];
    }
    return a;
  }
}
