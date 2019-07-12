package f.g.c.package_8;

import f.g.c.d.Of;
import f.g.c.d.Ub;
import f.g.c.j.g;
import f.g.c.package_10.Preconditions;
import java.util.List;

public final class RegularImmutableSortedMultiset<E>
  extends Ub<E>
{
  public final transient int[] counts;
  public final transient long[] cumulativeCounts;
  public final transient Of<E> elementSet;
  public final transient int length;
  public final transient int offset;
  
  public RegularImmutableSortedMultiset(RegularImmutableSortedSet paramRegularImmutableSortedSet, int[] paramArrayOfInt, long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    elementSet = paramRegularImmutableSortedSet;
    counts = paramArrayOfInt;
    cumulativeCounts = paramArrayOfLong;
    offset = paramInt1;
    length = paramInt2;
  }
  
  private Ye.a getEntry(int paramInt)
  {
    return Multisets.immutableEntry(elementSet.asList().get(paramInt), counts[(offset + paramInt)]);
  }
  
  public int count(Object paramObject)
  {
    int i = elementSet.indexOf(paramObject);
    if (i == -1) {
      return 0;
    }
    return counts[(i + offset)];
  }
  
  public ImmutableSet createEntrySet()
  {
    return new Nf.a(this, null);
  }
  
  public ImmutableSortedSet elementSet()
  {
    return elementSet;
  }
  
  public Ye.a firstEntry()
  {
    return getEntry(0);
  }
  
  public ImmutableSortedMultiset getSubMultiset(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, length);
    if (paramInt1 == paramInt2) {
      return ImmutableSortedMultiset.emptyMultiset(comparator());
    }
    if ((paramInt1 == 0) && (paramInt2 == length)) {
      return this;
    }
    return new RegularImmutableSortedMultiset((RegularImmutableSortedSet)elementSet.getSubSet(paramInt1, paramInt2), counts, cumulativeCounts, offset + paramInt1, paramInt2 - paramInt1);
  }
  
  public ImmutableSortedMultiset headMultiset(Object paramObject, BoundType paramBoundType)
  {
    RegularImmutableSortedSet localRegularImmutableSortedSet = elementSet;
    if (paramBoundType != null)
    {
      boolean bool;
      if (paramBoundType == BoundType.CLOSED) {
        bool = true;
      } else {
        bool = false;
      }
      return getSubMultiset(0, localRegularImmutableSortedSet.headIndex(paramObject, bool));
    }
    throw new NullPointerException();
  }
  
  public boolean isPartialView()
  {
    return (offset > 0) || (length < counts.length);
  }
  
  public Ye.a lastEntry()
  {
    return getEntry(length - 1);
  }
  
  public int size()
  {
    long[] arrayOfLong = cumulativeCounts;
    int i = offset;
    return g.b(arrayOfLong[(length + i)] - arrayOfLong[i]);
  }
  
  public ImmutableSortedMultiset tailMultiset(Object paramObject, BoundType paramBoundType)
  {
    RegularImmutableSortedSet localRegularImmutableSortedSet = elementSet;
    if (paramBoundType != null)
    {
      boolean bool;
      if (paramBoundType == BoundType.CLOSED) {
        bool = true;
      } else {
        bool = false;
      }
      return getSubMultiset(localRegularImmutableSortedSet.tailIndex(paramObject, bool), length);
    }
    throw new NullPointerException();
  }
}
