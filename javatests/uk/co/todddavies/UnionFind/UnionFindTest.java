package uk.co.todddavies.UnionFind;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class UnionFindTest {

  ImmutableList<Integer> TEST_ELEMENTS = 
      ImmutableList.of(0,1,2,3,4,5,6,7,8,9);
  
  @Test
  public void test() {
    UnionFind<Integer> uf = new UnionFind<>(TEST_ELEMENTS);
    uf.add(0,1);
    uf.add(0,2);
    uf.add(0,3);
    
    uf.add(4,5);
    uf.add(5,6);
    
    uf.add(6,0);
    
    int a = uf.root(3);
    int b = uf.root(6);
    int c = uf.root(0);
    
    assertEquals(a, b);
    assertEquals(b, c);
    assertEquals((Integer) 7, uf.root(7));
    assertEquals((Integer) 8, uf.root(8));
    assertEquals((Integer) 9, uf.root(9));
  }

}
