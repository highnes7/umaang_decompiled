package f.g.c.package_8;

import f.g.c.d.Sb;
import f.g.c.d.Wb;
import java.util.Comparator;
import java.util.Map;

public final class EmptyImmutableSortedMap<K, V>
  extends Sb<K, V>
{
  public final transient Wb<K> keySet;
  
  public EmptyImmutableSortedMap(Comparator paramComparator)
  {
    keySet = ImmutableSortedSet.emptySet(paramComparator);
  }
  
  public EmptyImmutableSortedMap(Comparator paramComparator, ImmutableSortedMap paramImmutableSortedMap)
  {
    super(paramImmutableSortedMap);
    keySet = ImmutableSortedSet.emptySet(paramComparator);
  }
  
  public ImmutableSortedMap createDescendingMap()
  {
    return new EmptyImmutableSortedMap(Ordering.from(comparator()).reverse(), this);
  }
  
  public ImmutableSet createEntrySet()
  {
    throw new AssertionError("should never be called");
  }
  
  public ImmutableSet entrySet()
  {
    return ImmutableSet.of();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Map)) {
      return ((Map)paramObject).isEmpty();
    }
    return false;
  }
  
  public Object get(Object paramObject)
  {
    return null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public ImmutableSortedMap headMap(Object paramObject, boolean paramBoolean)
  {
    if (paramObject != null) {
      return this;
    }
    throw new NullPointerException();
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public ImmutableSortedSet keySet()
  {
    return keySet;
  }
  
  public int size()
  {
    return 0;
  }
  
  public ImmutableSortedMap tailMap(Object paramObject, boolean paramBoolean)
  {
    if (paramObject != null) {
      return this;
    }
    throw new NullPointerException();
  }
  
  public String toString()
  {
    return "{}";
  }
  
  public ImmutableCollection values()
  {
    return ImmutableList.of();
  }
}
