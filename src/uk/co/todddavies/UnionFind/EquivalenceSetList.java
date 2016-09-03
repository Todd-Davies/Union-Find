package uk.co.todddavies.UnionFind;

public interface EquivalenceSetList<T> {

  public void add(T a, T b);
  public T root(T a);
}
