package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.d.Ye;
import f.g.c.d.ng;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

@a
@b
public abstract interface SortedMultiset<E>
  extends Ye<E>, ng<E>
{
  public abstract Comparator comparator();
  
  public abstract SortedMultiset descendingMultiset();
  
  public abstract SortedSet elementSet();
  
  public abstract Ye.a firstEntry();
  
  public abstract SortedMultiset headMultiset(Object paramObject, BoundType paramBoundType);
  
  public abstract Iterator iterator();
  
  public abstract Ye.a lastEntry();
  
  public abstract Ye.a pollFirstEntry();
  
  public abstract Ye.a pollLastEntry();
  
  public abstract SortedMultiset subMultiset(Object paramObject1, BoundType paramBoundType1, Object paramObject2, BoundType paramBoundType2);
  
  public abstract SortedMultiset tailMultiset(Object paramObject, BoundType paramBoundType);
}
