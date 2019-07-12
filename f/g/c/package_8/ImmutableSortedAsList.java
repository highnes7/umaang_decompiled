package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.ng;
import f.g.c.d.zf;
import java.util.Comparator;

@b(emulated=true)
public final class ImmutableSortedAsList<E>
  extends zf<E>
  implements ng<E>
{
  public ImmutableSortedAsList(ImmutableSortedSet paramImmutableSortedSet, ImmutableList paramImmutableList)
  {
    super(paramImmutableSortedSet, paramImmutableList);
  }
  
  public Comparator comparator()
  {
    return delegateCollection().comparator();
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public ImmutableSortedSet delegateCollection()
  {
    return (ImmutableSortedSet)delegate;
  }
  
  public int indexOf(Object paramObject)
  {
    int i = delegateCollection().indexOf(paramObject);
    if ((i >= 0) && (get(i).equals(paramObject))) {
      return i;
    }
    return -1;
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return indexOf(paramObject);
  }
  
  public ImmutableList subListUnchecked(int paramInt1, int paramInt2)
  {
    return new RegularImmutableSortedSet(super.subListUnchecked(paramInt1, paramInt2), comparator()).asList();
  }
}
