package f.g.c.package_8;

import f.g.c.d.Ub;
import java.util.Collection;

public final class DescendingImmutableSortedMultiset<E>
  extends Ub<E>
{
  public final transient Ub<E> forward;
  
  public DescendingImmutableSortedMultiset(ImmutableSortedMultiset paramImmutableSortedMultiset)
  {
    forward = paramImmutableSortedMultiset;
  }
  
  public int count(Object paramObject)
  {
    return forward.count(paramObject);
  }
  
  public ImmutableSet createEntrySet()
  {
    return new DescendingImmutableSortedMultiset.1(this, forward.entrySet());
  }
  
  public ImmutableSortedMultiset descendingMultiset()
  {
    return forward;
  }
  
  public ImmutableSortedSet elementSet()
  {
    return forward.elementSet().descendingSet();
  }
  
  public Ye.a firstEntry()
  {
    return forward.lastEntry();
  }
  
  public ImmutableSortedMultiset headMultiset(Object paramObject, BoundType paramBoundType)
  {
    return forward.tailMultiset(paramObject, paramBoundType).descendingMultiset();
  }
  
  public boolean isPartialView()
  {
    return forward.isPartialView();
  }
  
  public Ye.a lastEntry()
  {
    return forward.firstEntry();
  }
  
  public int size()
  {
    return forward.size();
  }
  
  public ImmutableSortedMultiset tailMultiset(Object paramObject, BoundType paramBoundType)
  {
    return forward.headMultiset(paramObject, paramBoundType).descendingMultiset();
  }
}
