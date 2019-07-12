package f.g.c.package_8;

import f.g.c.d.Of;
import f.g.c.d.Sb;
import f.g.c.d.vb;
import java.util.List;

public final class RegularImmutableSortedMap<K, V>
  extends Sb<K, V>
{
  public final transient Of<K> keySet;
  public final transient vb<V> valueList;
  
  public RegularImmutableSortedMap(RegularImmutableSortedSet paramRegularImmutableSortedSet, ImmutableList paramImmutableList)
  {
    keySet = paramRegularImmutableSortedSet;
    valueList = paramImmutableList;
  }
  
  public RegularImmutableSortedMap(RegularImmutableSortedSet paramRegularImmutableSortedSet, ImmutableList paramImmutableList, ImmutableSortedMap paramImmutableSortedMap)
  {
    super(paramImmutableSortedMap);
    keySet = paramRegularImmutableSortedSet;
    valueList = paramImmutableList;
  }
  
  private ImmutableSortedMap getSubMap(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size())) {
      return this;
    }
    if (paramInt1 == paramInt2) {
      return ImmutableSortedMap.emptyMap(comparator());
    }
    return ImmutableSortedMap.from(keySet.getSubSet(paramInt1, paramInt2), valueList.subList(paramInt1, paramInt2));
  }
  
  public ImmutableSortedMap createDescendingMap()
  {
    return new RegularImmutableSortedMap((RegularImmutableSortedSet)keySet.descendingSet(), valueList.reverse(), this);
  }
  
  public ImmutableSet createEntrySet()
  {
    return new Kf.a(this, null);
  }
  
  public Object get(Object paramObject)
  {
    int i = keySet.indexOf(paramObject);
    if (i == -1) {
      return null;
    }
    return valueList.get(i);
  }
  
  public ImmutableSortedMap headMap(Object paramObject, boolean paramBoolean)
  {
    RegularImmutableSortedSet localRegularImmutableSortedSet = keySet;
    if (paramObject != null) {
      return getSubMap(0, localRegularImmutableSortedSet.headIndex(paramObject, paramBoolean));
    }
    throw new NullPointerException();
  }
  
  public ImmutableSortedSet keySet()
  {
    return keySet;
  }
  
  public ImmutableSortedMap tailMap(Object paramObject, boolean paramBoolean)
  {
    RegularImmutableSortedSet localRegularImmutableSortedSet = keySet;
    if (paramObject != null) {
      return getSubMap(localRegularImmutableSortedSet.tailIndex(paramObject, paramBoolean), size());
    }
    throw new NullPointerException();
  }
  
  public ImmutableCollection values()
  {
    return valueList;
  }
}
